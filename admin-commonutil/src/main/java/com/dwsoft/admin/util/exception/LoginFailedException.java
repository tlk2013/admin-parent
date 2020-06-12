package com.dwsoft.admin.util.exception;

/**
 * @author tlk
 * @date 2020/5/18-14:57
 */
public class LoginFailedException  extends RuntimeException{

    private static final long serialVersionUID = 7471479144414463041L;

    public LoginFailedException() {
        super();
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    protected LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
