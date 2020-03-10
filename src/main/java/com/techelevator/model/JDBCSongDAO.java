package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSongDAO implements SongDAO {

	private JdbcTemplate j;
	
	@Autowired
	public JDBCSongDAO(DataSource dataSource) {
		j = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Song> getAllSongs() {
		List<Song> output = new ArrayList<Song>();
		
		String sql = "SELECT * FROM songs";
		
		SqlRowSet result = j.queryForRowSet(sql);
		
		while(result.next()) {
			Long id = result.getLong(1);
			String artist = result.getString(2);
			String title = result.getString(3);
			String album = result.getString(4);
			
			Song thisSong = new Song(id, artist, title, album);
			output.add(thisSong);
		}
		
		return output;
	}

	@Override
	public boolean saveRequest(Song request) {
		String sql = "INSERT INTO song_requests VALUES (DEFAULT, ?, ?, ?)";
		
		int rowsAffected = 0;
		try {
			rowsAffected = j.update(sql, request.getArtist(), request.getTitle(), request.getAlbum());
		} catch (DuplicateKeyException e) {
			
		}
		
		return rowsAffected == 1;
	}

	@Override
	public List<Song> getAllRequests() {
		List<Song> output = new ArrayList<Song>();
		
		String sql = "SELECT * FROM song_requests";
		
		SqlRowSet result = j.queryForRowSet(sql);
		
		while(result.next()) {
			Long id = result.getLong(1);
			String artist = result.getString(2);
			String title = result.getString(3);
			String album = result.getString(4);
			
			Song thisSong = new Song(id, artist, title, album);
			output.add(thisSong);
		}
		
		return output;
	}
	
	
	
}
