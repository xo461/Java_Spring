package com.ninemovies.movie.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ninemovies.movie.dto.MovieDTO;
import com.ninemovies.movie.mapper.MovieMapper;

@Service
public class MovieService {

	@Inject
	private MovieMapper mapper;
	
	public List<MovieDTO> list(){
		return mapper.list();
	}

	public Integer insert(MovieDTO dto) {
		return mapper.insert(dto);
	}

	public MovieDTO view(int no) {
		return mapper.view(no);
	}
	
}
