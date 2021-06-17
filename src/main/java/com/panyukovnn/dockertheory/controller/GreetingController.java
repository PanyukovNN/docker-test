package com.panyukovnn.dockertheory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String getIndex(Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm dd.MM.yyyy");
        model.addAttribute("dateTime", formatter.format(LocalDateTime.now()));//

        return "index";
    }
}
