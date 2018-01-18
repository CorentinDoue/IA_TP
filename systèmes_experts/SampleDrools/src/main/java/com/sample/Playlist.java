/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Playlist POJO to simulate Playlist in the sample application
 * @author vivek
 */
public class Playlist {
    private String name;
    private List<Song> songs;
    

    public Playlist() {
        this.songs = new ArrayList<Song>();
    }

    public Playlist(String name) {
        this();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public boolean addSong(Song song) {
        return songs.add(song);
    }

    @Override
    public String toString() {

        String result =  "Playlist {name= '"+this.getName()+"', songs= [";
        String separator = "";

        for(int i = 0; i < this.songs.size(); i++){
            result += separator+this.songs.get(i);

            if (i==0){
                separator = ", ";
            }

        }

        return result+"]}";

    }
    
    

}
