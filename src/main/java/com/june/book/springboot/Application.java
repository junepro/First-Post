package com.june.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing //jpa auditing 활성화 사용하기위해서는 적어도 @Entity 클래스 필요
//test에서 webmvctest에서도 스캔되어 오류발생 그래서 떼어내야됨
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
