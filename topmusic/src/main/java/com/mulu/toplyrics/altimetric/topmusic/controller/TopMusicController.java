package com.mulu.toplyrics.altimetric.topmusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopMusicController {

    @GetMapping("/")
    public String getTopTrack(){
        System.out.println("is this working?");
        return "index";
    }
}
