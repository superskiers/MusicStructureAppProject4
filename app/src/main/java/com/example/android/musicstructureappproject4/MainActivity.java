package com.example.android.musicstructureappproject4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create ArrayList
        final ArrayList<Music> musicArrayList = new ArrayList<>();

        //Add items to ArrayList
        musicArrayList.add(new Music(getString(R.string.artistNas), getString(R.string.songOneLove), R.drawable.albumnas, R.raw.colliebuddzcomearoundreggae80));
        musicArrayList.add(new Music(getString(R.string.artistBIG), getString(R.string.songWhoShotYa), R.drawable.albumbiggie, R.raw.stephenmarleyheybabyreggae80));
        musicArrayList.add(new Music(getString(R.string.artistJayZ), getString(R.string.songSupaUgly), R.drawable.jayzalbum, R.raw.wayne_smith_under_me_sleng_teng));
        musicArrayList.add(new Music(getString(R.string.artistMarley), getString(R.string.songHeyBaby), R.drawable.albummarley, R.raw.colliebuddzcomearoundreggae80));
        musicArrayList.add(new Music(getString(R.string.artistNas), getString(R.string.songAintHardtoTell), R.drawable.albumnas, R.raw.wayne_smith_under_me_sleng_teng));
        musicArrayList.add(new Music(getString(R.string.artistJayZ), getString(R.string.songTakeOver), R.drawable.jayzalbum, R.raw.stephenmarleyheybabyreggae80));
        musicArrayList.add(new Music(getString(R.string.artistMarley), getString(R.string.songTrafficJam), R.drawable.albummarley, R.raw.colliebuddzcomearoundreggae80));
        musicArrayList.add(new Music(getString(R.string.artistBIG), getString(R.string.songUnbelievable), R.drawable.albumbiggie, R.raw.stephenmarleyheybabyreggae80));

        //Bind ListView with MusicAdapter
        MusicAdapter adapter = new MusicAdapter(this, musicArrayList);
        //Find the view ID with list_view
        final ListView listView = findViewById(R.id.list_view);
        //Attach adapter to the view
        listView.setAdapter(adapter);

        //Initialize OnClick so when a row is clicked on it goes to that selection
        AdapterView.OnItemClickListener adaptListener = new
                AdapterView.OnItemClickListener() {

                    //Set up Intents
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        //Get the current selection
                        Music music = musicArrayList.get(position);
                        Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                        nowPlayingIntent.putExtra("songName", music.getSongName());
                        nowPlayingIntent.putExtra("artistName", music.getArtistName());
                        nowPlayingIntent.putExtra("albumImage", music.getAlbumImage());
                        nowPlayingIntent.putExtra("songPlaying", music.getmAudioResourceId());

                        startActivity(nowPlayingIntent);
                    }
                };

        //Attach listener to listView
        listView.setOnItemClickListener(adaptListener);
        //ImageView for featured album cover/artist
        ImageView albumImageView = findViewById(R.id.image_view_album_cover);
        albumImageView.setImageResource(R.drawable.albumbiggie);
        //Create onClick for featured album
        albumImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get the current selection
                Music music = musicArrayList.get(1);
                Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                nowPlayingIntent.putExtra("songName", music.getSongName());
                nowPlayingIntent.putExtra("artistName", music.getArtistName());
                nowPlayingIntent.putExtra("albumImage", music.getAlbumImage());
                nowPlayingIntent.putExtra("songPlaying", music.getmAudioResourceId());

                startActivity(nowPlayingIntent);
            }
        });
    }
}




