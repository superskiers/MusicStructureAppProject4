package com.example.android.musicstructureappproject4;

/**
 * Created by superskiers on 16/03/18.
 */

//Music class to store music info
public class Music {
    //Variables for Music
    private String artistName;
    private String songName;
    private int albumImage;

    //New Music object with 3 parameters; Name of the Artist, Name of the Song, and a picture of the Album
    public Music(String artistName, String songName, int albumImage) {
        this.artistName = artistName;
        this.songName = songName;
        this.albumImage = albumImage;
    }
    //Getter for the artist
    public String getArtistName() {
        return artistName;
    }
    //Getter for the song
    public String getSongName() {
        return songName;
    }
    //Getter for the album cover
    public int getAlbumImage() {
        return albumImage;
    }
}


