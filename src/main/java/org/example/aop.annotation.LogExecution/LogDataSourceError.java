package org.example.aop.annotation.LogExecution;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogDataSourceError {
}