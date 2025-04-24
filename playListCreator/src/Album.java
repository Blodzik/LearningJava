import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    record Song(String title, double duration) {

        @Override
        public String toString() {
            return String.format("%s: %.2f", title, duration);
        }
    }

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public List<Song> getSongs() {
        return songs;
    }

    public Song findSong(String title) {
        for (Song song : songs) {
            if(title.equalsIgnoreCase(song.title())) {
                return song;
            }
        }
        return null;
    }

    public boolean findSongInPlaylist(String title, LinkedList<Song> playlist) {
        for (Song song : playlist) {
            if(title.equalsIgnoreCase(song.title())) {
                return true;
            }
        }
        return false;
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) != null) {
           System.out.println("Song already exists");
           return false;
        } else {
            System.out.println("Song added");
            songs.add(new Song(title, duration));
            return true;
        }
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        if(findSong(title) == null) {
            System.out.println("Song does not exist");
            return false;
        } else {
            if(!findSongInPlaylist(title, playlist)) {
                System.out.println("Song was added to playlist");
                Song song1 = findSong(title);
                playlist.add(new Song(title, song1.duration()));
                return true;
            } else {
                System.out.println("Song is already in the playlist");
                return false;
            }
        }
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if (index >= 0 && index < songs.size()) {
            Song song = songs.get(index);
            if (!playlist.contains(song)) {
                playlist.add(song);
                System.out.println("Song added to playlist: " + song);
                return true;
            } else {
                System.out.println("Song already in playlist");
                return false;
            }
        } else {
            System.out.println("Invalid track number: " + trackNumber);
            return false;
        }
    }

}
