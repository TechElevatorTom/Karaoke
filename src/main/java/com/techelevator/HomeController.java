package com.techelevator;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.model.Song;
import com.techelevator.model.SongDAO;

@Controller
public class HomeController {

	@Autowired
	private SongDAO songDAO;
	
	@RequestMapping("/")
	public String helloWorld(ModelMap m) {
				
		List<Song> songsWeKnow = songDAO.getAllSongs();
		List<Song> songsWeWereAskedToLearn = songDAO.getAllRequests();

		m.put("songs", songsWeKnow);
		m.put("song_requests", songsWeWereAskedToLearn);
		
		return "home_page";
	}
	
	@RequestMapping("/requestSongForm")
	public String showRequestForm() {

		return "song_request_form";
	}
	
	@RequestMapping(path = "/submitRequestData", method = RequestMethod.POST)
	public String handleSongRequestRequest(Song incomingSong,  RedirectAttributes f /* HttpSession session*/) {
		
		if(songDAO.saveRequest(incomingSong)) {
			f.addFlashAttribute("give_thanks", incomingSong);			
		} else {
			f.addFlashAttribute("whoops", incomingSong);			
		}		
		
		return "redirect:/";
	}
	
}
