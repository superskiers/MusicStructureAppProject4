package com.example.android.musicstructureappproject4;

/**
 * Created by superskiers on 16/03/18.
 */
public class Music {

    private String artistName;
    private String songName;
    private int albumImage;

    //New Music object with 3 parameters
    public Music(String artistName, String songName, int albumImage) {
        this.artistName = artistName;
        this.songName = songName;
        this.albumImage = albumImage;

    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongName() {
        return songName;
    }

    public int getAlbumImage() {
        return albumImage;
    }
}


