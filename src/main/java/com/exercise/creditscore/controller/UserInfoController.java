package com.exercise.creditscore.controller;

import com.exercise.creditscore.model.CreateUserInfoRequest;
import com.exercise.creditscore.model.UserInfo;
import com.exercise.creditscore.service.UserInfoService;
import com.exercise.creditscore.utils.RestPayloadValidationUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> createUser(@RequestBody CreateUserInfoRequest userInfoRequest) {
        RestPayloadValidationUtils.validate(userInfoRequest);
        UserInfo userInfo = objectMapper.convertValue(userInfoRequest, UserInfo.class);
        String response = userInfoService.createUser(userInfo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{userId}/creditScore")
    public ResponseEntity<?> getCreditScore(@PathVariable String userId) {
        Integer creditInfo = userInfoService.getCreditScore(userId);
        return new ResponseEntity<>(creditInfo, HttpStatus.OK);
    }


}
