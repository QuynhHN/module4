package com.example.song.controller;

import com.example.song.dto.SongDTO;
import com.example.song.model.Song;
import com.example.song.server.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    private ISongService iSongService;
    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songList", iSongService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("songDTO", new SongDTO());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute SongDTO songDTO,
                         BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("songDTO",songDTO);
            return "/create";
        }
        else {
            iSongService.create(songDTO);
            redirectAttributes.addAttribute("msg","thêm mới thành công");
            return "redirect:/song";
        }
    }
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("songDTO",iSongService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String update(@Validated @ModelAttribute SongDTO songDTO,
                         BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("songDTO",songDTO);
            return "update";
        }else {
            iSongService.update(songDTO);
            redirectAttributes.addFlashAttribute("msg","update thành công");
            return "redirect:/song";
        }

    }
}
