package com.exercise.creditscore.service;

import com.exercise.creditscore.exception.UserNotFoundException;
import com.exercise.creditscore.model.UserInfo;
import com.exercise.creditscore.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository repository;

    @Override
    @Transactional
    public String createUser(UserInfo userInfo) {
        Optional<UserInfo> savedUserInfo = repository.findByFirstNameAndLastName(userInfo.getFirstName(), userInfo.getLastName());
        if (savedUserInfo.isPresent()) {
            return savedUserInfo.get().getId();
        }
        int creditScore = calculateCreditScore(userInfo);
        userInfo.setCreditScore(creditScore);
        return repository.save(userInfo).getId();
    }

    @Override
    public Integer getCreditScore(String userId) {
        Optional<UserInfo> userInfo = repository.findById(userId);
        return userInfo.map(UserInfo::getCreditScore).orElseThrow(() ->
                new UserNotFoundException(userId));
    }

    private int calculateCreditScore(UserInfo userInfo) {
        return (Integer.parseInt(userInfo.getAnnualIncome()) + userInfo.getAge()) % 999;
    }
}
