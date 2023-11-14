package com.mo.planner.global.entity.core;

import java.time.LocalDateTime;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

/**
 * packageName    : com.mo.planner.global.entity.core
 * fileName       : BaseEntity
 * author         : Jang Hyun Suk
 * date           : 11/14/23
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 11/14/23       Jang Hyun Suk       최초 생성
 */
@Getter
@MappedSuperclass
public abstract class BaseEntity {

	@Column(updatable = false)
	@Comment("생성일자")
	private LocalDateTime createAt;

	@Column(updatable = false)
	@Comment("수정일자")
	private LocalDateTime updateAt;

	@PrePersist
	protected void onCreate() {
		createAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updateAt = LocalDateTime.now();
	}
}
