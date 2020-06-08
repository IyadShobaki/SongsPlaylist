package com.shobaki;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    //method to add a song
    public boolean addSong(String title, double duration){
        if(findSong(title) == null){
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }


    private Song findSong(String title){
        for(Song checkedSong : this.songs){ //using enhanced for loop
            if(checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }
    //create playlist method using LinkedList
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber - 1;
        //check if there is a song at the given index and add it to the playlist
        if((index >= 0) && (index <= this.songs.size())){
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }
    //overload the previous method to add a song to the playlist using the title
    public boolean addToPlayList(String title, LinkedList<Song> playlist){
        Song checkedSong = findSong(title);
        if(checkedSong != null){
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }
}
