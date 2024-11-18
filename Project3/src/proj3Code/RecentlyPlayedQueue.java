package proj3Code;

import java.util.LinkedList;
import java.util.Queue;

public class RecentlyPlayedQueue {
	private Queue<Song> recentlyPlayed;
	private int maxSize;

	public RecentlyPlayedQueue(int maxSize) {
		this.maxSize = maxSize;
		recentlyPlayed = new LinkedList<>();
	}

	public void addRecentlyPlayed(Song song) {
		// TODO: Add the song to the queue. If the queue exceeds maxSize, remove the
		// oldest song
	}

	public void printRecentlyPlayed() {
		// TODO: Print the songs in the recently played queue in order
	}
}
