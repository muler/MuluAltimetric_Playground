package com.mulu.artist.altimetric.toptrackservice.service;


import com.mulu.artist.altimetric.toptrackservice.model.Track;
import org.json.JSONException;

public interface TrackService {
    Track getTopTrack(String country) throws JSONException;
    String getTopTrackName(String country);
}
