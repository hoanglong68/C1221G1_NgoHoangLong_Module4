package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;
    @GetMapping(value = "/home")
    public String goHome(Model model){
        model.addAttribute("song",new Song());
        return "home";
    }
    @GetMapping
    public String goList(Model model){
        model.addAttribute("songList",this.iSongService.getSongList());
        return "list";
    }
}
