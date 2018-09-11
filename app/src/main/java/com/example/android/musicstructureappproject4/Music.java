package com.example.android.musicstructureappproject4;

/**
 * Created by superskiers on 16/03/18.
 */

//Music class to store music info
public class Music {
    //Variables for Music
    private String mArtistName;
    private String mSongName;
    private int mAlbumImage;
    private int mAudioResourceId;

    //New Music object with 3 parameters; Name of the Artist, Name of the Song, and a picture of the Album
    public Music(String artistName, String songName, int albumImage, int audioResourceId) {
        mArtistName = artistName;
        mSongName = songName;
        mAlbumImage = albumImage;
        mAudioResourceId = audioResourceId;
    }
    //Getter for the artist
    public String getArtistName() {
        return mArtistName;
    }
    //Getter for the song
    public String getSongName() {
        return mSongName;
    }
    //Getter for the album cover
    public int getAlbumImage() {
        return mAlbumImage;
    }
    //Getter for the audio file
    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}


