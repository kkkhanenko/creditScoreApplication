package com.exercise.creditscore.repository;

import com.exercise.creditscore.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    Optional<UserInfo> findByFirstNameAndLastName(String firstName, String lastName);

}
