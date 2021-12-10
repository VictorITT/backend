package com.project.backend.controller;


import com.project.backend.dto.Message;
import com.project.backend.dto.UserInfoDto;
import com.project.backend.model.User;
import com.project.backend.model.UserInfo;
import com.project.backend.security.service.UserService;
import com.project.backend.service.impl.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userinfo")
@CrossOrigin(origins = "*")
public class UserInfoController {

    @Autowired
    UserInfoServiceImpl userInfoService;

    @Autowired
    UserService userService;

    @GetMapping("/detailname/{username}")
    public ResponseEntity<UserInfo> get(@PathVariable("username") String username){
        UserInfo userInfo = userInfoService.getInfoByUsename(username);
        if(userInfo==null)
            return new ResponseEntity(new Message("Introduce data"), HttpStatus.NOT_FOUND);
        userInfo = userInfoService.getInfoByUsename(username);
        return new ResponseEntity(userInfo, HttpStatus.OK);
    }



    @PutMapping("/update/{username}")
    public ResponseEntity<?> update(@PathVariable("username") String username, @RequestBody UserInfoDto userInfoDto){
        User user = userService.getByUsername(username).get();
        UserInfo userInfo = userInfoService.getInfoByUsename(username);
        if (userInfo==null)
            userInfo = new UserInfo();
        if (userInfoDto.getAddressLine()!=null||!userInfoDto.getAddressLine().isEmpty())
            userInfo.setAddressLine(userInfoDto.getAddressLine());
        if (userInfoDto.getCity()!=null||!userInfoDto.getCity().isEmpty())
            userInfo.setCity(userInfoDto.getCity());
        if (userInfoDto.getPhone()!=null)
            userInfo.setPhone(userInfoDto.getPhone());
        if (userInfoDto.getState()!=null)
            userInfo.setState(userInfoDto.getState());
        if (userInfoDto.getCountry()!=null||!userInfoDto.getCountry().isEmpty())
            userInfo.setCountry(userInfoDto.getCountry());
        if (userInfoDto.getPostalCode()!=null)
            userInfo.setPostalCode(userInfoDto.getPostalCode());
        if (userInfo.getUser()==null)
            userInfo.setUser(user);
        userInfoService.save(userInfo);
        return new ResponseEntity(new Message("Updated"), HttpStatus.OK);
    }



}
