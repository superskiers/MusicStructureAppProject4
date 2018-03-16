package com.example.android.musicstructureappproject4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by superskiers on 16/03/18.
 */

public class MusicAdapter extends ArrayAdapter<Music> {

    //private static final String LOG_TAG = MusicAdapter.class.getSimpleName();


    public MusicAdapter(Activity context, ArrayList<Music> musicArrayList) {
        super(context, 0, musicArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if existing view is being reused, otherwise inflate the view
        View layoutView = convertView;
        if (layoutView == null) {
            layoutView = LayoutInflater.from(getContext()).inflate(
                    R.layout.layout, parent, false);
        }

        Music currentSong = getItem(position);
        //Fill the below Views with info from Music and apply to layoutView
        TextView songTextView = layoutView.findViewById(R.id.songNameTV);
        songTextView.setText(currentSong.getSongName());

        TextView artistTextView = layoutView.findViewById(R.id.artistNameTV);
        artistTextView.setText(currentSong.getArtistName());

        ImageView albumImageView = layoutView.findViewById(R.id.albumImageView);
        albumImageView.setImageResource(currentSong.getAlbumImage());

        return layoutView;


    }
}