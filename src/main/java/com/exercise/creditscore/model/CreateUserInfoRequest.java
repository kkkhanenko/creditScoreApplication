package com.exercise.creditscore.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CreateUserInfoRequest {
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotNull
    @Min(value = 18, message = "You should have at least 18 years.")
    @Max(value = 100, message = "Invalid age.")
    private Integer age;

    @Past(message = "Invalid date birth")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateBirth;

    @NotBlank(message = "Annual income name is required")
    @Size(min = 4, message = "Invalid annual income")
    private String annualIncome;

}
