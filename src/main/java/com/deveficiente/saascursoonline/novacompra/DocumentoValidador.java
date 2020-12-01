package com.deveficiente.saascursoonline.novacompra;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentoValidador implements ConstraintValidator<Documento, String> {

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.hasLength(documento)) {
            CPFValidator cpf = new CPFValidator();
            cpf.initialize(null);

            CNPJValidator cnpj = new CNPJValidator();
            cnpj.initialize(null);

            return cpf.isValid(documento, constraintValidatorContext)
                    || cnpj.isValid(documento, constraintValidatorContext);
        }
        return false;
    }
}
