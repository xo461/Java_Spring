package com.ninemovies.movie.mapper;

import java.util.List;

import com.ninemovies.movie.dto.MovieDTO;

public interface MovieMapper {

	public List<MovieDTO> list();

	public Integer insert(MovieDTO dto);

	public MovieDTO view(int no);
	
}
