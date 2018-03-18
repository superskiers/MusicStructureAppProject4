package com.example.android.musicstructureappproject4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //Navigation back to home screen
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //View components
        ImageView setAlbumCover = findViewById(R.id.albumImageView);
        TextView setSongTitle = findViewById(R.id.songNameTV);
        TextView setArtistName = findViewById(R.id.artistNameTV);

        //Get Intent and populate layout
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        String artist = intent.getStringExtra("artistName");
        String song = intent.getStringExtra("songName");
        int coverImage = extras.getInt("albumImage");

        //Set elements; artist, song and album cover image
        setArtistName.setText(artist);
        setSongTitle.setText(song);
        setAlbumCover.setImageResource(coverImage);
    }

}

