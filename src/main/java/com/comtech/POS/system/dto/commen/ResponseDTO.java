package com.comtech.POS.system.dto.commen;

public class ResponseDTO {
    private final Long id;
    private final int status;
    private final String message;

    public ResponseDTO(Long id, int status, String message) {
        this.id = id;
        this.status = status;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
