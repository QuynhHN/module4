package com.example.song.controller;

import com.example.song.dto.SongDTO;
import com.example.song.model.Song;
import com.example.song.server.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songList", iSongService.listAll());
        return "/list";
    }
    @GetMapping("/create-form")
    public String createForm(Model model){
        model.addAttribute("songDTO", new SongDTO());
        return "/create";
    }
    @PostMapping("/create")
    public String create(@Validated @ModelAttribute SongDTO songDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDTO, song);
        return "redirect:/song";
    }
}
