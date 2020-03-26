package com.spider.sts.user.service.impl;

import com.spider.sts.user.mapper.AppUserMapper;
import com.spider.sts.user.model.AppUser;
import com.spider.sts.user.model.AppUserExample;
import com.spider.sts.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    AppUserMapper appUserMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean checkNameUnused(String username) {
        AppUserExample example = new AppUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<AppUser> appUserList = appUserMapper.selectByExample(example);
        if (appUserList.isEmpty()) {
            return false;
        }
        return true;
    }

    // 一般用户名写了之后，用ajax技术先去扫一个表，看有没有被占用。
    // 如果没占用的话，先放到服务器缓存区里，这时这个名字就不允许别人用了。
    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public AppUser register(AppUser userParam) {
        AppUser appUser = new AppUser();
        BeanUtils.copyProperties(userParam, appUser);
        // 如果用户名已存在，返回null
        AppUserExample example = new AppUserExample();
        example.createCriteria().andUsernameEqualTo(appUser.getUsername());
        List<AppUser> appUserList = appUserMapper.selectByExample(example);
        if (appUserList.isEmpty()) {
            return null;
        }
        String encodePassword = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encodePassword);
        appUserMapper.insert(appUser);
        return appUser;
    }


}
