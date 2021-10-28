package com.example.controller;

import com.example.domain.dto.UserDto;
import com.example.domain.entity.User;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping({"/", "/users"})
    public ModelAndView findUsers() {
        var users = userService.findUsers().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", users);

        return modelAndView;
    }

    @GetMapping("/search")
    public String findUsers(@ModelAttribute(name = "user") UserDto dto) {
        return "search";
    }

    @GetMapping("/users/search")
    public ModelAndView findUsers(@RequestParam(value = "login") String login,
                                  @RequestParam(value = "email") String email,
                                  @RequestParam(value = "age") int age) {
        var users = userService.findUsers(login, email, age);
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("users");
        modelAndView.addObject("users", users);

        return modelAndView;
    }

    @PostMapping("/users")
    public String createUser(@Valid @ModelAttribute(name = "user") UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "sign-up";
        }
        var user = new User(userDto);
        userService.createUser(user);

        return "redirect:users";
    }

    @GetMapping("/sign-up")
    public String signUp(@ModelAttribute(name = "user") UserDto userDto) {
        return "sign-up";
    }

    @GetMapping("/clean")
    public String clean() {
        userService.clean();
        return "redirect:users";
    }
}
