package com.spider.sts.user.web;

import com.spider.sts.common.util.CommonResult;
import com.spider.sts.common.util.ResultCode;
import com.spider.sts.user.model.AppUser;
import com.spider.sts.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserContoller {

    @Autowired
    UserService userService;

    /**
     * 检查用户名是否已被使用
     * @param username
     * @return
     */
    @GetMapping("/check_username")
    public CommonResult checkUsernameUnused(@Param("username") String username){
        if (userService.checkNameUnused(username)) {
            return CommonResult.failed(ResultCode.USERNAME_USED);
        }
        return CommonResult.success();
    }


    @PostMapping("/register")
    public CommonResult register(@RequestBody AppUser userParam){
        AppUser appUser = userService.register(userParam);
        if (appUser == null) {
            return CommonResult.failed(ResultCode.USERNAME_USED);
        }
        return CommonResult.success(appUser);

    }





}
