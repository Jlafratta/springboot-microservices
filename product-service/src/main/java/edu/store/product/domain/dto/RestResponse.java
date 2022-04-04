package edu.store.product.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class RestResponse {

    private Object data;

    @Builder.Default
    private List<CustomError> errors = new ArrayList<>();

    public RestResponse() {
        this.errors = new ArrayList<>();
    }

    public RestResponse(Object data) {
        this();
        this.data = data;
    }

    public void addError(CustomError error) {
        getErrors().add(error);
    }

    public void addErrors(List<CustomError> errors) {
        getErrors().addAll(errors);
    }
}
