package com.example.android.musicstructureappproject4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create ArrayList
        final ArrayList<Music> musicArrayList = new ArrayList<Music>();

        //Add to ArrayList
        musicArrayList.add(new Music(getString(R.string.artistNas), getString(R.string.songOneLove), R.drawable.albumnas));
        musicArrayList.add(new Music(getString(R.string.artistNas), getString(R.string.songAintHardtoTell), R.drawable.albumnas));
        musicArrayList.add(new Music(getString(R.string.artistMarley), getString(R.string.songTrafficJam), R.drawable.albummarley));
        musicArrayList.add(new Music(getString(R.string.artistMarley), getString(R.string.songHeyBaby), R.drawable.albummarley));
        musicArrayList.add(new Music(getString(R.string.artistBIG), getString(R.string.songWhoShotYa), R.drawable.albumbiggie));
        musicArrayList.add(new Music(getString(R.string.artistBIG), getString(R.string.songUnbelievable), R.drawable.albumbiggie));

        //Bind ListView with MusicAdapter
        MusicAdapterActivity adapter = new MusicAdapterActivity(this, musicArrayList);
        final ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        //Initialize OnClick
        AdapterView.OnItemClickListener adaptListener = new
                AdapterView.OnItemClickListener() {

                    //Set up Intents
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Music music = musicArrayList.get(i);
                        Intent nowPlayingIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                        nowPlayingIntent.putExtra("songName", music.getSongName());
                        nowPlayingIntent.putExtra("artistName", music.getArtistName());
                        nowPlayingIntent.putExtra("albumImage", music.getAlbumImage());
                        startActivity(nowPlayingIntent);
                    }
                };

        //Attach listener to listView
        listView.setOnItemClickListener(adaptListener);
    }
}




