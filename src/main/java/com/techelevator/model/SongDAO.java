package com.techelevator.model;

import java.util.List;

public interface SongDAO {

	List<Song> getAllSongs();
	List<Song> getAllRequests();
	boolean saveRequest(Song request);
}
