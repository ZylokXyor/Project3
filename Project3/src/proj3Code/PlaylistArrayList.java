package proj3Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class PlaylistArrayList {
	private ArrayList<Song> playlist;

	public PlaylistArrayList() {
		playlist = new ArrayList<>();
	}

	public void addSong(Song song) {
		playlist.add(song);
		// TODO: Add a song to the end of the playlist
	}

	public void insertSong(int index, Song song) {
		playlist.add(index, song);
		// TODO: Insert a song at the specified index in the playlist
	}

	public void removeSong(int index) {
		playlist.remove(index);
		// TODO: Remove the song at the specified index from the playlist
	}

	public Song getSong(int index) {
		return playlist.get(index);
		// TODO: Return the song at the specified index, or null if the index is invalid
	}

	public void shuffle() {
		// TODO: Shuffle the playlist
		Random shuffle = new Random();
		
		for  (@SuppressWarnings("unused") Song song: playlist) {
			int randomsong = shuffle.nextInt(playlist.size());
			int shuffleid = shuffle.nextInt(playlist.size());
			Song placeholder = playlist.get(randomsong);
			playlist.remove(randomsong);
			playlist.add(shuffleid, placeholder);
			
		}
		
	}

	public void sortByTitle() {
		// TODO: Sort the playlist by song title
		Collections.sort(playlist, Comparator.comparing(Song::getTitle, Comparator.naturalOrder()));
	}

	public void sortByArtist() {
		// TODO: Sort the playlist by artist name
		Collections.sort(playlist, Comparator.comparing(Song::getArtist, Comparator.naturalOrder()));
    }

	public void sortByDuration() {
		// TODO: Sort the playlist by duration
		Collections.sort(playlist, Comparator.comparing(Song::getDuration, Comparator.naturalOrder()));
	}

	public int searchByTitle(String title) {
		// TODO: Search for a song by title and return its index, or -1 if not found
		for (int i = 0; i < playlist.size(); i++) {
			if (playlist.get(i).getTitle().equalsIgnoreCase(title)) {
				return i;
			}
		}
		return -1;
	}

	public int searchByArtist(String artist) {
		// TODO: Search for a song by artist and return its index, or -1 if not found
		for (int i = 0; i < playlist.size(); i++) {
			if (playlist.get(i).getArtist().equalsIgnoreCase(artist)) {
				return i;
			}
		}
		return -1;
	}

	public void printPlaylist() {
		// TODO: Print all songs in the playlist
		for (Song song : playlist) {
			System.out.println(song);
		}
	}
}
