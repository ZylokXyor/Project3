package proj3Code;

import java.util.LinkedList;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;


public class PlaylistLinkedList {
	private LinkedList<Song> playlist;

	public PlaylistLinkedList() {
		playlist = new LinkedList<>();
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
		// TODO: Return the song at the specified index, or null if the index is invalid
		return playlist.get(index);
	}

	public void shuffle() {
		Random shuffle = new Random();
		for (int i = 0; i < playlist.size(); i++) {
			int randomsong = shuffle.nextInt(playlist.size());
			int shuffleid = shuffle.nextInt(playlist.size());
			Song placeholder = playlist.get(randomsong);
			playlist.remove(randomsong);
			playlist.add(shuffleid, placeholder);
		}
	
		
		// TODO: Shuffle the playlist
	}

	public void sortByTitle() {
		// TODO: Sort the playlist by song title
	}

	public void sortByArtist() {
		// TODO: Sort the playlist by artist name
	}

	public void sortByDuration() {
		// TODO: Sort the playlist by duration
	}

	public int searchByTitle(String title) {
		// TODO: Search for a song by title and return its index, or -1 if not found
		return -1;
	}

	public int searchByArtist(String artist) {
		// TODO: Search for a song by artist and return its index, or -1 if not found
		return -1;
	}

	public void printPlaylist() {
		for (int i = 0; i < playlist.size(); i++) {
			System.out.println(playlist.get(i));
		}
		// TODO: Print all songs in the playlist
	}
}
