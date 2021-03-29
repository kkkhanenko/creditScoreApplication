package com.exercise.creditscore.service;

import com.exercise.creditscore.model.UserInfo;


public interface UserInfoService {

    String createUser(UserInfo userInfo);

    Integer getCreditScore(String userId);
}
