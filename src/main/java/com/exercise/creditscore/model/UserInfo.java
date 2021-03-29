package com.exercise.creditscore.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(unique = true, nullable = false)
    private String id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private Integer age;

    @Column(name = "date_birth")
    private LocalDate dateBirth;

    @Column(name = "annual_income")
    private String annualIncome;
    @Column(name = "credit_score")
    private Integer creditScore;
}
