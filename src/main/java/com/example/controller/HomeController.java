package com.example.controller;

import com.example.domain.dto.UserDto;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/users")
    public ModelAndView users(@RequestParam(name = "id", required = false) String id) {
        var userDto = UserDto.builder().id(id).login("kek").build();
        var newUserDto = userService.doSomeLogicWithThisUser(userDto);
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("user", newUserDto);
        return modelAndView;
    }
}
