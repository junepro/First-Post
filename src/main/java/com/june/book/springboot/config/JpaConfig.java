package com.june.book.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //환경설정
@EnableJpaAuditing
public class JpaConfig {
}
