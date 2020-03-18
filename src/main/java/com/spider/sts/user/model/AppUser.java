package com.spider.sts.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spider.sts.common.model.CommonDbFields;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class AppUser extends CommonDbFields {

    @Column(name = "user_name", nullable = false)
    private String userName;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @JsonIgnore
    @Column(name = "salt", nullable = false)
    private String salt;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "identify_number", nullable = false)
    private String identifyNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }
}
