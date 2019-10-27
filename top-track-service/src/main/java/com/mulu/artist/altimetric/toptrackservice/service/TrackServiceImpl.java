package com.mulu.artist.altimetric.toptrackservice.service;

import com.mulu.artist.altimetric.toptrackservice.model.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    APIKey apiKey;

    @Autowired
    URI uri;

    @Override
    public Track getTopTrack(String country) throws JSONException {

        JSONObject obj=new JSONObject(restTemplate.getForObject(uri.getTopTrack()+"&country="+country+"&api_key="+apiKey.getLastfm(), String.class));
        JSONArray trackarray = obj.getJSONObject("tracks").getJSONArray("track");
        if(trackarray.length()==0) return null;
        obj=trackarray.getJSONObject(0);
        trackarray=null; //realeasing Memory
        Track track = new Track();
        track.setName(obj.getString("name"));
        track.setListeners(obj.getString("listeners"));
        track.setArtist(getArtistInfo(obj.getJSONObject("artist").getString("name")));
        track.setLyrics(getLyrics(track.getName(),track.getArtist().getName()));
        track.setSimilarTracks(getSimilar(track.getName(),track.getArtist().getName()));


        return track;
    }

    @Override
    public String getTopTrackName(String country) {
        JSONObject obj=new JSONObject(restTemplate.getForObject(uri.getTopTrack()+"&country="+country+"&api_key="+apiKey.getLastfm(), String.class));
        JSONArray trackarray = obj.getJSONObject("tracks").getJSONArray("track");
        if(trackarray.length()==0) return null;
        obj=trackarray.getJSONObject(0);
        trackarray=null; //realeasing Memory
        Track track = new Track();
        return obj.getString("name");

    }

    public Artist getArtistInfo(String name) {

        JSONObject obj=new JSONObject(restTemplate.getForObject(uri.getArtist()+"&artist="+name+"&api_key="+apiKey.getLastfm(), String.class));
        Artist artist = new Artist();
        artist.setName(obj.getJSONObject("artist").getString("name"));
        artist.setOntour(obj.getJSONObject("artist").getString("ontour").equals("1")?"Yes":"No");
        artist.setBio(obj.getJSONObject("artist").getJSONObject("bio").getString("content"));

        return artist;
    }
    public String getLyrics(String track, String artist) {
        JSONObject obj = new JSONObject(restTemplate.getForObject(uri.getLyrics()+"q_track="+track+"&q_artist="+artist+"&apikey="+apiKey.getMusixmatch(), String.class));
        return obj.getJSONObject("message").getJSONObject("body").getJSONObject("lyrics").getString("lyrics_body");
    }
    public List<SimilarTracks> getSimilar(String track, String artist) {

        JSONObject obj = new JSONObject(restTemplate.getForObject(uri.getSimilarTrack()+"&artist="+artist+"&track="+track+"&api_key="+apiKey.getLastfm(),String.class));
        JSONArray similarTracks = obj.getJSONObject("similartracks").getJSONArray("track");
        List<SimilarTracks> tracks=null;
        if(similarTracks.length()>0) tracks=new ArrayList<>();
        for(int i=0;i<similarTracks.length();i++) {
            if(i==3) break;;
            tracks.add(new SimilarTracks(similarTracks.getJSONObject(i).getString("name"),similarTracks.getJSONObject(i).getLong("playcount"),
                    similarTracks.getJSONObject(i).getString("url"), getArtistInfo(similarTracks.getJSONObject(i).getJSONObject("artist").getString("name"))));
        }
        return tracks;
    }


}
