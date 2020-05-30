package com.zenor.testing.testing.dto;

public class Response<ENTITY_TYPE> {
    private final StatusCode status;
    private final ENTITY_TYPE data;

    public Response(ENTITY_TYPE data) {
        this.status = data != null ? StatusCode.OK : StatusCode.KO;
        this.data = data;
    }

    public StatusCode getStatus() {
        return status;
    }

    public ENTITY_TYPE getData() {
        return data;
    }
}
