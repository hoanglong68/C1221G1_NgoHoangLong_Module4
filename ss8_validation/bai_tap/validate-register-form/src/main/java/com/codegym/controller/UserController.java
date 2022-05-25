package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping(value = "/register")
    public String goRegisterForm(Model model) {
        model.addAttribute("userDto",new UserDto());
        return "view";
    }

    @PostMapping(value = "/register")
    public String registerUser( @Validated UserDto userDto,
                               BindingResult bindingResult,
                               Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "view";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            this.iUserService.save(user);
            model.addAttribute
                    ("message", "register" + user.getFirstName() + " " + user.getLastName() + "successful !");
            return "result";
        }
    }
}
