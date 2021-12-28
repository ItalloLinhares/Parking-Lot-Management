package com.parking.management.validator;

import com.parking.management.annotation.CarLicensePlate;
import com.parking.management.model.Car;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarLicensePlateValidator implements ConstraintValidator<CarLicensePlate, String> {
    private Pattern pattern = Pattern.compile("^[a-zA-Z]{3}\\-\\d{4}$");


    @Override
    public void initialize(CarLicensePlate constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (value == null || "".equals(value)) {
            return true;
        }

        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
