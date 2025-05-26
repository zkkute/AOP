package org.example.repository;

import org.example.aop.aspect.LogAspect.LogDataSourceAspect;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ErrorLogRepository extends JpaRepository<LogDataSourceAspect.DataSourceErrorLog, Long> {}