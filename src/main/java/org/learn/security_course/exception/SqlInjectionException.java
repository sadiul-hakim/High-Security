package org.learn.security_course.exception;

public class SqlInjectionException extends Exception {
    public SqlInjectionException(String msg) {
        super(msg);
    }
}
