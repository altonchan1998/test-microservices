package com.altonchan.orderservice.validator;

import com.altonchan.orderservice.repository.InstrumentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class CfiCodeValidator implements ConstraintValidator<CfiCode, String> {

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Override
    public boolean isValid(String cfiCode, ConstraintValidatorContext constraintValidatorContext) {
        return instrumentRepository.existsByCfiCode(cfiCode);
    }
}