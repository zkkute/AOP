package org.example.aop.annotation.LogExecution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания, что вызов метода должен логироваться.
 */
@Target(ElementType.METHOD) // Применяется к методам
@Retention(RetentionPolicy.RUNTIME) // Доступна во время выполнения
public @interface LogExecution {
}