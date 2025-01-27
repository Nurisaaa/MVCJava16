package peaksoft.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entities.User;
import peaksoft.service.UserService;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String get(Model model){
        model.addAttribute("users", userService.findAll());
        return "/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/create")
    public String create(Model model){
            model.addAttribute("user", new User());
        return "/create";
    }
    @PostMapping
    public String save(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute User user , @PathVariable("id") Long id){
        userService.update(user, id);
        return "redirect:/users";
    }

}
