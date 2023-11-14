package com.mo.planner.global.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicUpdate;

import com.mo.planner.api.board.dto.req.BoardReq;
import com.mo.planner.global.entity.core.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * packageName    : com.mo.planner.global.entity.core
 * fileName       : Board
 * author         : Jang Hyun Suk
 * date           : 11/14/23
 * description    : 
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 11/14/23       Jang Hyun Suk       최초 생성
 */
@Getter
@Entity
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
public class Board extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 20)
	private String title;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	@Column
	private LocalDateTime conferenceStartAt;

	@Column
	private LocalDateTime conferenceEndAt;

	@Builder
	public Board(String title, String content, LocalDateTime conferenceStartAt, LocalDateTime conferenceEndAt) {
		this.title = title;
		this.content = content;
		this.conferenceStartAt = conferenceStartAt;
		this.conferenceEndAt = conferenceEndAt;
	}

	public static Board saveBoard(BoardReq req) {
		return Board.builder()
			.title(req.getTitle())
			.content(req.getContent())
			.conferenceStartAt(req.getConferenceStartAt())
			.conferenceEndAt(req.getConferenceEndAt())
			.build();
	}
}