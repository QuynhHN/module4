package com.example.form.controller;

import com.example.form.dto.UserCreateDTO;
import com.example.form.model.User;
import com.example.form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("userList", iUserService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("userDTO", new UserCreateDTO());
        return "index";
    }

    @PostMapping("/create")
    public String creationForm(@Valid @ModelAttribute ("userDTO")UserCreateDTO userCreateDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "/index";
        }
        User user = new User();
        BeanUtils.copyProperties(userCreateDTO, user);
        iUserService.create(user);
        redirectAttributes.addFlashAttribute("msg", "msg.createSuccess");
        return "redirect:/user";

    }
}
