package com.example.android.musicstructureappproject4;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class NowPlayingActivity extends MainActivity {

    private static final String TAG = "NowPlayingActivity";

    //Declare TextViews
    private TextView mButtonPlay, mButtonPause, mButtonReset, mSampleTextView;
    //Media player object
    private MediaPlayer mMediaPlayer;
    //Handles audio focus while playing sound file
    private AudioManager mAudioManager;

    //MediaPlayer support
    private double startTime = 0;
    private double finalTime = 0;
    private int totalTime;

    private Handler myHandler = new Handler();
    private SeekBar mSeekbar;
    private static int oneTimeOnly = 0;
    private boolean isUserSeeking;
    private Runnable mRunnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        //Initialize Buttons
        mButtonPlay = findViewById(R.id.button_play);
        mButtonPause = findViewById(R.id.button_pause);
        mButtonReset = findViewById(R.id.button_replay);
        mSampleTextView = findViewById(R.id.sample_text_view);
        mSeekbar = findViewById(R.id.seekBar);

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
        int currentSong = extras.getInt("songPlaying", 0);
        //Initialize mediaPlayer and indicate which song
        mMediaPlayer = MediaPlayer.create(NowPlayingActivity.this, currentSong);

        //Set elements; artist, song and album cover image
        setArtistName.setText(artist);
        setSongTitle.setText(song);
        setAlbumCover.setImageResource(coverImage);

        //Buttons display Toast msg currently but can be updated to be fully functional
        mButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NowPlayingActivity.this, R.string.toast_msg_play_btn, Toast.LENGTH_SHORT).show();
                mMediaPlayer.start();
                //mSeekbar.setProgress((int) startTime);
                finalTime = mMediaPlayer.getDuration();
                startTime = mMediaPlayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    mSeekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
//                    updateSongTime();
                }
                mSeekbar.setProgress((int) startTime);
                myHandler.postDelayed(UpdateSongTime, 100);
                timeForSampleTextView();
            }
        });

        mButtonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NowPlayingActivity.this, R.string.toast_msg_pause_btn, Toast.LENGTH_SHORT).show();
                mMediaPlayer.pause();
            }
        });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NowPlayingActivity.this, R.string.toast_msg_replay_btn, Toast.LENGTH_SHORT).show();
                mMediaPlayer.reset();
                mMediaPlayer.start();
            }
        });
        //Set up mSeekBar
        mSeekbar.setMax(mMediaPlayer.getDuration());
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mMediaPlayer.seekTo(progress);
                    mSeekbar.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    //Set up TextView to display current time in song
        public void timeForSampleTextView() {
        mSampleTextView.setText(String.format(Locale.getDefault(), "%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                toMinutes((long) startTime))));
    }

    //Empty public constructor
    public NowPlayingActivity() {
    }

    //Release audio resource when activity is stopped
    @Override
    public void onStop() {
        super.onStop();
        mMediaPlayer.pause();
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mMediaPlayer.getCurrentPosition();
            mSeekbar.setProgress((int)startTime);
            mSampleTextView.setText(String.format(Locale.getDefault(), "%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            mSeekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };


//    private void updateSongTime() {
//       // startTime = mMediaPlayer.getCurrentPosition();
//        mSeekbar.setProgress(mMediaPlayer.getCurrentPosition());
//        // mSeekbar.setMax(mMediaPlayer.getDuration());
////        timeForSampleTextView();
//        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                if (fromUser) {
//                    mMediaPlayer.seekTo(progress * 1000);
//                   ///THIS IS THE SPOT TO ADD THE TEXTVIEW UPDATE
//                }
//                mSeekbar.setProgress((int) startTime);
                //myHandler.postDelayed(this, 100);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                seekBar.getMax();
//            }
//        });
//    }
//    private void changeSeekBar() {
//        mSeekbar.setProgress(mMediaPlayer.getCurrentPosition());
//        if(mMediaPlayer.isPlaying()){
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    changeSeekBar();
//                }
//            };
//            myHandler.postDelayed(runnable, 1000);
//        }
    }

