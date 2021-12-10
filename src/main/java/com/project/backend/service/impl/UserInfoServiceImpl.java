package com.project.backend.service.impl;

import com.project.backend.model.UserInfo;
import com.project.backend.repository.UserInfoRepository;
import com.project.backend.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {


    @Autowired
    UserInfoRepository userInfoRepository;


    public void  save(UserInfo userInfo){
        userInfoRepository.save(userInfo);
    }
    public UserInfo getInfoByUsename(String user){
        return userInfoRepository.findByUser(user);
    }

}
