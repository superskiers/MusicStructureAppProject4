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


    //Custom constructor used to inflate the layout
    public MusicAdapter(Activity context, ArrayList<Music> musicArrayList) {
        super(context, 0, musicArrayList);
    }

    //View for the position in the AdapterView
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if existing view is being reused, otherwise inflate the view
        View layoutView = convertView;
        //If View is null, inflate it using layout
        if (layoutView == null) {
            layoutView = LayoutInflater.from(getContext()).inflate(
                    R.layout.layout, parent, false);
        }
        //Get the current song (object) located at this position in the list
        Music currentSong = getItem(position);
        //Set the song title to the view
        TextView songTextView = layoutView.findViewById(R.id.text_view_song_name);
        songTextView.setText(currentSong.getSongName());
        //Set the artist name to the view
        TextView artistTextView = layoutView.findViewById(R.id.text_view_artist_name);
        artistTextView.setText(currentSong.getArtistName());
        //Set the album image to the view
        ImageView albumImageView = layoutView.findViewById(R.id.image_view_album_cover);
        albumImageView.setImageResource(currentSong.getAlbumImage());


        //Return above info in layoutView
        return layoutView;
    }
}