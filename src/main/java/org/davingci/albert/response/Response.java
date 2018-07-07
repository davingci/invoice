package org.davingci.albert.response;



public class Response {

    private Integer code;

    private String message;

    private Object data;

    private Response(Builder builder) {
        setCode(builder.code);
        setMessage(builder.message);
        data = builder.data;
    }

    public static Builder builder() {
        return new Builder();
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static final class Builder {
        private Integer code;
        private String message;
        private Object data;

        private Builder() {
        }

        public Builder code(Integer val) {
            code = val;
            return this;
        }

        public Builder message(String val) {
            message = val;
            return this;
        }

        public Builder data(Object val) {
            data = val;
            return this;
        }

        public Response build() {
            return new Response(this);
        }
    }
}

