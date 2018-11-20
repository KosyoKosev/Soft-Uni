package Playlist;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song){
        this.songs.add(song);
    }

    public int getSongsCount(){
        return this.songs.size();
    }

    public String getTotalPlaylistLength(){
        int minutes = 0;
        int seconds = 0;
        for (Song song : songs) {
            minutes += song.getMinutes();
            seconds += song.getSeconds();
        }

        int totalLength = (minutes * 60) + seconds;
        int hour = totalLength / 3600;
        int totalMinutes = (totalLength / 60) - (hour * 60);
        int totalSeconds = totalLength % 60;

        return String.format("Playlist length: %dh %dm %ds", hour, totalMinutes, totalSeconds);
    }
}
