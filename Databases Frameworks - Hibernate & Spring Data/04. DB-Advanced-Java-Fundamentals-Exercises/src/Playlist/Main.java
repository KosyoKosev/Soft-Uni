package Playlist;

import Playlist.Exception.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Playlist playlist = new Playlist();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(";");
            String artist = input[0];
            String name = input[1];
            String[] time = input[2].split(":");

            String minutes = time[0];
            String seconds = time[1];

            try {
                Song song = new Song(artist, name, seconds, minutes);
                playlist.addSong(song);
                System.out.println("Song added.");
            }catch (InvalidSongException e){
                System.out.println(e.getMessage());
            }
        }

        System.out.printf("Songs added: %d\n", playlist.getSongsCount());
        System.out.println(playlist.getTotalPlaylistLength());
    }
}
