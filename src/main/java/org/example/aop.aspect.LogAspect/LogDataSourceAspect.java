package org.example.aop.aspect.LogAspect;

import jakarta.persistence.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import org.example.repository.ErrorLogRepository;

import java.time.LocalDateTime;

@Aspect
@Component
public class LogDataSourceAspect {

    private final ErrorLogRepository errorLogRepository;

    public LogDataSourceAspect(ErrorLogRepository errorLogRepository) {
        this.errorLogRepository = errorLogRepository;
    }

    @AfterThrowing(pointcut = "@annotation(org.example.aop.annotation.LogDataSourceError)", throwing = "exception")
    public void logDataSourceError(JoinPoint joinPoint, Throwable exception) {
        DataSourceErrorLog errorLog = new DataSourceErrorLog();
        errorLog.setMethodSignature(joinPoint.getSignature().toShortString());
        errorLog.setErrorMessage(exception.getMessage());
        errorLog.setStackTrace(getStackTraceAsString(exception));
        errorLog.setTimestamp(LocalDateTime.now());

        errorLogRepository.save(errorLog);
    }

    private String getStackTraceAsString(Throwable throwable) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : throwable.getStackTrace()) {
            sb.append(element.toString()).append("\n");
        }
        return sb.toString();
    }

    @Entity
    @Table(name = "data_source_error_log")
    public static class DataSourceErrorLog {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "method_signature", nullable = false)
        private String methodSignature;

        @Column(name = "error_message", nullable = false)
        private String errorMessage;

        @Column(name = "stack_trace", columnDefinition = "TEXT")
        private String stackTrace;

        @Column(name = "timestamp")
        private LocalDateTime timestamp;

        // Getters and Setters

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

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }
    }
}