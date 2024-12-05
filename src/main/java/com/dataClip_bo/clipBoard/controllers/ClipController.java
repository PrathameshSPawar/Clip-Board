package com.dataClip_bo.clipBoard.controllers;

import com.dataClip_bo.clipBoard.models.Clip;
import com.dataClip_bo.clipBoard.repository.ClipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ClipController {

    @Autowired
    private ClipRepository clipRepository;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/add-clip")
    public String addClip() {
        return "add-clip";
    }

    @PostMapping("/save-clip")
    public String saveClip(@RequestParam String content, @RequestParam String tags) {
        String[] tagArray = tags.split(",");
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        Clip clip = new Clip(content, List.of(tagArray), date);
        clipRepository.save(clip);

        return "redirect:/saved-clips";
    }

    @GetMapping("/saved-clips")
    public String viewSavedClips(Model model) {
        List<Clip> clips = clipRepository.findAll();
        model.addAttribute("clips", clips);
        return "saved-clips";
    }

    @PostMapping("/delete-clip/{id}")
    public String deleteClip(@PathVariable String id) {
        clipRepository.deleteById(id);
        return "redirect:/saved-clips";
    }
}
