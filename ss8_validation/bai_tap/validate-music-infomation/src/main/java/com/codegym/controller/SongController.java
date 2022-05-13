package com.codegym.controller;

import com.codegym.dto.SongDto;
import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SongController {
    @Autowired
    private ISongService iSongService;

    @GetMapping(value = {"/", "/view"})
    public String goView(Model model,
                         Pageable pageable) {
        model.addAttribute("songList", this.iSongService.findAll(pageable));
        return "view";
    }

    @GetMapping(value = "/create")
    public String goCreateForm(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping(value = "/create")
    public String createNewSong(
            @Validated SongDto songDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            this.iSongService.save(song);
            redirectAttributes.addFlashAttribute("message", "create successful !");
            return "redirect:/view";
        }
    }

    @GetMapping(value = "/edit")
    public String goEditForm(Model model,
                             @RequestParam String id) {
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(this.iSongService.findById(id), songDto);
        model.addAttribute("songDto", songDto);
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editExistSong(@Validated SongDto songDto,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        new SongDto().validate(songDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/edit";
        } else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto, song);
            this.iSongService.save(song);
            redirectAttributes.addFlashAttribute("message", "edit successful !");
            return "redirect:/view";
        }
    }
}
