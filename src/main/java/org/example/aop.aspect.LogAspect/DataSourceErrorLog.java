package org.example.aop.aspect.LogAspect;

import jakarta.persistence.*;

@Entity
@Table(name = "error_logs")
public class DataSourceErrorLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "method_signature", nullable = false)
    private String methodSignature;

    @Column(name = "error_message", nullable = false)
    private String errorMessage;

    @Column(name = "stack_trace", columnDefinition = "TEXT", nullable = false)
    private String stackTrace;

    // Constructors, Getters and Setters

    public DataSourceErrorLog() {}

    public DataSourceErrorLog(String methodSignature, String errorMessage, String stackTrace) {
        this.methodSignature = methodSignature;
        this.errorMessage = errorMessage;
        this.stackTrace = stackTrace;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodSignature() {
        return methodSignature;
    }

    public void setMethodSignature(String methodSignature) {
        this.methodSignature = methodSignature;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}