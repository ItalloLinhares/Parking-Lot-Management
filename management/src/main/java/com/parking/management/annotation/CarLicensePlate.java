package com.parking.management.annotation;

import com.parking.management.validator.CarLicensePlateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Constraint(validatedBy = CarLicensePlateValidator.class)
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CarLicensePlate {

    String message() default "Invalid Car License Plate";
    Class[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
