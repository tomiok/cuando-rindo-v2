package com.cuandorindov2.main.errorhandling;

/**
 * Created by tomaslingotti on 7/2/17.
 */
public class BaseException extends RuntimeException {

    private String message;
    private int status;

    public static class BaseExceptionBuilder {
        private String _message;
        private int _status;

        public BaseExceptionBuilder(final String message) {
            this._message = message;
        }

        public BaseExceptionBuilder status(int status) {
            this._status = status;
            return this;
        }

        public BaseException build() {
           return new BaseException(this);
        }
    }

    private BaseException(BaseExceptionBuilder b) {
        this.message = b._message;
        this.status = b._status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}
