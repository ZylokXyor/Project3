package proj3Code;

import java.util.Scanner;

public class PlaylistManager {
	// Declaration of the playlists and recently played queue
	private PlaylistArrayList arrayListPlaylist = new PlaylistArrayList();
	private PlaylistLinkedList linkedListPlaylist = new PlaylistLinkedList();
	private RecentlyPlayedQueue recentlyPlayedQueue = new RecentlyPlayedQueue(5);
	private boolean useArrayList = true; // Switch to toggle between ArrayList and LinkedList-based playlists

	public void start() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\nPlaylist Manager Menu:");
			System.out.println("1. Add Song");
			System.out.println("2. Insert Song at Position");
			System.out.println("3. Remove Song");
			System.out.println("4. View Song");
			System.out.println("5. Shuffle Playlist");
			System.out.println("6. Print Playlist");
			System.out.println("7. Sort Playlist");
			System.out.println("8. Search for Song");
			System.out.println("9. View Recently Played Songs");
			System.out.println("10. Switch Playlist Type");
			System.out.println("11. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				addSong(scanner);
				break;
			case 2:
				insertSong(scanner);
				break;
			case 3:
				removeSong(scanner);
				break;
			case 4:
				viewSong(scanner);
				break;
			case 5:
				shufflePlaylist();
				break;
			case 6:
				printPlaylist();
				break;
			case 7:
				sortPlaylist(scanner);
				break;
			case 8:
				searchSong(scanner);
				break;
			case 9:
				recentlyPlayedQueue.printRecentlyPlayed();
				break;
			case 10:
				switchPlaylistType();
				break;
			case 11:
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	/**
	 * Prompts the user to enter song details, then adds the song to the current
	 * playlist.
	 */
	private void addSong(Scanner scanner) {
		// TODO: Prompt for song details, create a new Song object, and add it to the
		// playlist
		// Use arrayListPlaylist or linkedListPlaylist based on `useArrayList`
	}

	/**
	 * Inserts a song at a specified index in the playlist.
	 */
	private void insertSong(Scanner scanner) {
		// TODO: Prompt for song details and index, create a new Song object, and insert
		// it at the index
		// Use arrayListPlaylist or linkedListPlaylist based on `useArrayList`
	}

	/**
	 * Removes a song from a specified position in the playlist.
	 */
	private void removeSong(Scanner scanner) {
		// TODO: Prompt for the index to remove, then remove the song at that index from
		// the playlist
	}

	/**
	 * Displays a song at a specified position and adds it to the recently played
	 * queue.
	 */
	private void viewSong(Scanner scanner) {
		// TODO: Prompt for the index, display the song, and add it to the recently
		// played queue
	}

	/**
	 * Shuffles the playlist.
	 */
	private void shufflePlaylist() {
		// TODO: Shuffle the current playlist (ArrayList or LinkedList)
	}

	/**
	 * Prints all songs in the current playlist.
	 */
	private void printPlaylist() {
		// TODO: Print all songs in the playlist in the current order
	}

	/**
	 * Sorts the playlist by title, artist, or duration based on user input.
	 */
	private void sortPlaylist(Scanner scanner) {
		System.out.println("Choose sort type: 1. Title 2. Artist 3. Duration");
		int sortChoice = scanner.nextInt();
		scanner.nextLine();

		// TODO: Sort the playlist by title, artist, or duration depending on user input
		// Use the corresponding sort method for arrayListPlaylist or linkedListPlaylist
	}

	/**
	 * Searches for a song by title or artist and displays the result.
	 */
	private void searchSong(Scanner scanner) {
		System.out.println("Search by: 1. Title 2. Artist");
		int searchChoice = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Enter search term: ");
		String term = scanner.nextLine();

		// TODO: Search for the song by title or artist in the current playlist and
		// print the result
	}

	/**
	 * Switches between ArrayList-based and LinkedList-based playlist management.
	 */
	private void switchPlaylistType() {
		useArrayList = !useArrayList;
		System.out.println("Switched to " + (useArrayList ? "ArrayList" : "LinkedList") + " playlist.");
	}

	/**
	 * Prompts the user to enter details for a new song.
	 */
	private Song createSong(Scanner scanner) {
		System.out.print("Enter song title: ");
		String title = scanner.nextLine();
		System.out.print("Enter artist name: ");
		String artist = scanner.nextLine();
		System.out.print("Enter duration in seconds: ");
		int duration = scanner.nextInt();
		scanner.nextLine();

		return new Song(title, artist, duration);
	}
}
