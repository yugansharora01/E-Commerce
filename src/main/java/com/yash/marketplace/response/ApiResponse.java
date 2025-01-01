package com.yash.marketplace.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {
    private Boolean success;
    private String message;
    private Object data;
}
