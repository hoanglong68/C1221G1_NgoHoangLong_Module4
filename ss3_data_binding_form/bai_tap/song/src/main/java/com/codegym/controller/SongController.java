package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    ISongService iSongService;

    @GetMapping(value = "/home")
    public String goHome(Model model) {
        model.addAttribute("song", new Song());
        return "home";
    }

    @GetMapping(value = "/list")
    public String goList(Model model) {
        model.addAttribute("songList", this.iSongService.getSongList());
        return "list";
    }

    @PostMapping(value = "/home")
    public String saveSong(@ModelAttribute Song song,
                           RedirectAttributes redirectAttributes) {
        this.iSongService.save(song);
        redirectAttributes.addFlashAttribute("message", "updated successful !");
        return "redirect:/home";
    }
}
