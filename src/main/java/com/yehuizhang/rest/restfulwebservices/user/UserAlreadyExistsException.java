package com.yehuizhang.rest.restfulwebservices.user;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("Cannot create user");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
