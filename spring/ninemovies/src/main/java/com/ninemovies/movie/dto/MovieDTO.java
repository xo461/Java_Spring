package com.ninemovies.movie.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MovieDTO {
	private int no;
	private String title, content, writer;
	private Date writeDate;
	private int hit;
}
