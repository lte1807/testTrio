package com.cos.blog.model;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="boards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(
			name = "USER_SEQ_GENERATOR2"
			, sequenceName = "USER_SEQ2"
			, initialValue = 1
			, allocationSize = 1
		)

public class Boards {
	@Id//기본키
	  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ_GENERATOR2")
	private int id;
	@Column(nullable=false, length=100)
	private String title;
	@Lob
	//대용량 데이터
	private String content;
	
	private int count;//조회수
	
	@ManyToOne(fetch = FetchType.EAGER)
	//Many = Board, User = One 한명이 여러개의 게시글을 쓸 수 있다.
	@JoinColumn(name="userId")
	private Users users;
	
	@OneToMany (mappedBy = "boards", fetch = FetchType.EAGER)
	
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
