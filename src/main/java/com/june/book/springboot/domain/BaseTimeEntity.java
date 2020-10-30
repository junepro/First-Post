package com.june.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //jpa entity클래스들이 이클래스를 상속할경우 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate //엔티티 생성되어 저장될떄 시간 자동저장
    private LocalDateTime creadDate;

    @LastModifiedDate //조회한 엔티디 변경할때 시간 자동저장
    private LocalDateTime modifiedDate;

}
