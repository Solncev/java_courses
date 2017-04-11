package ru.kpfu.itis.utils.validation;

import org.apache.commons.beanutils.BeanUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by Марат on 11.04.2017.
 */
public class DateMatchValidator implements ConstraintValidator<DateMatch, Object> {
    private String annotationDate;

    @Override
    public void initialize(DateMatch dateMatch) {
        this.annotationDate = dateMatch.date();
    }

    @Override
    public boolean isValid(Object date, ConstraintValidatorContext constraintValidatorContext) {
        try {
            final Object firstObj = BeanUtils.getProperty(date, annotationDate);
            Date newDate = (Date) firstObj;
            return newDate.after(new Date());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return false;
    }
}
