package ru.kpfu.itis.utils.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Марат on 11.04.2017.
 */
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = DateMatchValidator.class)
@Documented
public @interface DateMatch {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String date();
}
