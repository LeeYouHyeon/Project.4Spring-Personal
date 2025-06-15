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
public class BoardVO {
	private long bno;
	private String title;
	private String id;
	private String name;
	private String content;
	private String isDel;
	private String regDate;
	private int readCount;
	private int cmtCount;
	private int fileCount;
	private long likes;
}
