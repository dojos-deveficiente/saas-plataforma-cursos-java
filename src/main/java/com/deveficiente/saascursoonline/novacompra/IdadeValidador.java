package com.deveficiente.saascursoonline.novacompra;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class IdadeValidador implements ConstraintValidator<Idade, LocalDate> {
    private int idade;

    @Override
    public void initialize(Idade constraintAnnotation) {
        this.idade = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null)
            return true;
        return Period.between(value, LocalDate.now()).getYears() >= this.idade;
    }
}
