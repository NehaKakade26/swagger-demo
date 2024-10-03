package co.reldyn.baas.idv.onfido.exceptions;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -7951403220230986812L;
    private final String code;
    private final String context;
    private final String message;

    public BusinessException(String code, String message, String context) {
        super(message);
        this.code = code;
        this.message = message;
        this.context = context;
    }
}
