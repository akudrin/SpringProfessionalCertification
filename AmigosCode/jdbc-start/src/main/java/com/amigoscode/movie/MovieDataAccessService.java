package com.amigoscode.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDataAccessService implements MovieDao {
	public final JdbcTemplate jdbcTemplate;

	public MovieDataAccessService(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Movie> selectMovies() {
		return jdbcTemplate.query("SELECT id, name, release_date FROM movie LIMIT 100;", new MovieRowMapper());
	}

	@Override
	public int insertMovie(Movie movie) {
		return jdbcTemplate.update("INSERT INTO movie(name, release_date) VALUES (?, ?)", movie.getName(),
				movie.getReleaseDate());
	}

	@Override
	public int deleteMovie(int id) {
		return jdbcTemplate.update("DELETE FROM movie WHERE id=?", id);

	}

	@Override
	public Optional<Movie> selectMovieById(int id) {
		return jdbcTemplate.query("SELECT id, name, release_date FROM movie WHERE id = ?", new MovieRowMapper(), id)
				.stream().findFirst();
	}

}
