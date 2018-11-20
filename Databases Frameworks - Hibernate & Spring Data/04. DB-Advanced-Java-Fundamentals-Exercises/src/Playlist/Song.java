package Playlist;

import Playlist.Exception.*;

public class Song {
    private String artist;
    private String name;
    private int seconds;
    private int minutes;

    public Song(String artist, String name, String seconds, String minutes) {
        this.setArtist(artist);
        this.setName(name);
        this.checkLength(minutes, seconds);
        this.setSeconds(Integer.parseInt(seconds));
        this.setMinutes(Integer.parseInt(minutes));
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        if (artist.length() < 3 || artist.length() > 20){
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3 || name.length() > 30){
            throw new InvalidSongException("Song name should be between 3 and 30 symbols.");
        }
        this.name = name;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59){
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14){
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minutes = minutes;
    }

    private void checkLength(String minutes, String seconds){
        try{
            int currentMinutes = Integer.parseInt(minutes);
            int currentSeconds = Integer.parseInt(seconds);
        }catch (NumberFormatException ex){
            throw new InvalidSongLengthException("Invalid song length.");
        }
    }
}
