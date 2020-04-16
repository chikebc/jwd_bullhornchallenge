package com.bullhornchallenge.jwd_bullhornchallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    MessagesRepository messageRepository;

    @RequestMapping("/")
    public String listMessages(Model model) {
        model.addAttribute("messages", messageRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String messageForm(Model model) {
        model.addAttribute("messages", new Messages());
        return "messageform";
    }

    @PostMapping("/process")
    public String processForm(@Valid Messages message, BindingResult result) {
        if (result.hasErrors()) {
            return "messageform";
        }
        messageRepository.save(message);
        return "redirect:/";

    }
    @RequestMapping("/detail/{id}")
    public String showMsg(@PathVariable("id") long id, Model model) {
        model.addAttribute("message", messageRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateMessage(@PathVariable("id") long id, Model model) {
        model.addAttribute("message", messageRepository.findById(id).get());
        return "messageform";
    }
    @RequestMapping("/delete/{id}")
    public String delMessage(@PathVariable("id") long id) {
        messageRepository.deleteById(id);
        return "redirect:/";
    }


}
