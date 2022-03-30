package edu.store.product.domain.dto;

import edu.store.product.domain.enumeration.ErrorTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomError {

    private String message;
    private String description;
    private ErrorTypeEnum errorType;

    public CustomError() {
        setErrorType(ErrorTypeEnum.SERVER);
    }

    public CustomError(String message, ErrorTypeEnum errorType) {
        setMessage(message);
        setErrorType(errorType);
    }

    public CustomError(String message, String description) {
        this();
        setMessage(message);
        setDescription(description);
    }
}
