package com.sr.colleges.lms.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sr.colleges.lms.validator.UserValidator;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@UserValidator
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int userId;
    String userName;
    String userDepartment;
    String mobile;
    String userType;
}
