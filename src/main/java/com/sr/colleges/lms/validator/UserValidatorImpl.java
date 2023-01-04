package com.sr.colleges.lms.validator;

import com.sr.colleges.lms.constants.LmsConstants;
import com.sr.colleges.lms.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserValidatorImpl implements ConstraintValidator<UserValidator, User> {
    public List<String> errors = new ArrayList<>();
    public Boolean isValid = true;
    @Override
    public void initialize(UserValidator constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(User student, ConstraintValidatorContext context) {
        this.verifyUserType(student);

        if (!errors.isEmpty()) {
            isValid= false;
            this.constructVoilations(context);
        }
        return isValid;
    }

    private void verifyUserType(User user){
        if (user.getUserType().isEmpty()|| null == user.getUserType() || !Arrays.asList(LmsConstants.VALID_USER_TYPE).contains(user.getUserType().toUpperCase()))
            errors.add(LmsConstants.USER_TYPE_MISMATCH);
    }

    private void constructVoilations(ConstraintValidatorContext context){
        context.disableDefaultConstraintViolation();
        errors.forEach(error -> context.buildConstraintViolationWithTemplate(error).addConstraintViolation());
    }
}
