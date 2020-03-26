package com.spider.sts.user.service;


import com.spider.sts.user.model.AppUser;

public interface UserService {

    boolean checkNameUnused(String username);

    AppUser register(AppUser userParam);


}
