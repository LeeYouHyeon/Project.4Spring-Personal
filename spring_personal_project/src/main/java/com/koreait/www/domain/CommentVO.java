package com.koreait.www.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentVO {
	private long cno;
	private long bno;
	private String writer;
	private String name;
	private String pwd;
	private String content;
	private String regDate;
}
