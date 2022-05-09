package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping(value = "/list")
    public String goListMusic(Model model) {
        model.addAttribute("musicList", this.iMusicService.getAllSong());
        return "list";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createMusic(Music music,
                              RedirectAttributes redirectAttributes) {
        this.iMusicService.createMusic(music);
        redirectAttributes.addFlashAttribute("message", "create successful !");
        return "redirect:/list";
    }

    @GetMapping(value = "/edit")
    public String goEditForm(Model model,
                             @RequestParam String id) {
        model.addAttribute("music", this.iMusicService.findSongById(id));
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editMusic(Music music,
                            RedirectAttributes redirectAttributes) {
        System.out.println(music);
        this.iMusicService.save(music);
        redirectAttributes.addFlashAttribute("message", "edit successful !");
        return "redirect:/list";
    }

    @PostMapping(value = "delete")
    public String deleteMusic(@RequestParam String id,
                              RedirectAttributes redirectAttributes) {
        this.iMusicService.remove(this.iMusicService.findSongById(id));
        redirectAttributes.addFlashAttribute("message", "delete successful !");
        return "redirect:/list";
    }
}
