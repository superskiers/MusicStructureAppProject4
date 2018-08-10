package com.example.android.musicstructureappproject4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {

    private TextView mButtonPlay, mButtonPause, mButtonReplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //Initialize Buttons for Toast msg
        mButtonPlay = findViewById(R.id.button_play);
        mButtonPause = findViewById(R.id.button_pause);
        mButtonReplay = findViewById(R.id.button_replay);

        //Navigation back to home screen
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //View components
        ImageView setAlbumCover = findViewById(R.id.image_view_album_cover);
        TextView setSongTitle = findViewById(R.id.text_view_song_name);
        TextView setArtistName = findViewById(R.id.text_view_artist_name);

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

        //Buttons display Toast msg currently but can be updated to be fully functional
        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NowPlayingActivity.this, R.string.toast_msg_play_btn, Toast.LENGTH_SHORT).show();
            }
        });
        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NowPlayingActivity.this, R.string.toast_msg_pause_btn, Toast.LENGTH_SHORT).show();
            }
        });
        mButtonReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NowPlayingActivity.this, R.string.toast_msg_replay_btn, Toast.LENGTH_SHORT).show();
            }
        });
    }

}

