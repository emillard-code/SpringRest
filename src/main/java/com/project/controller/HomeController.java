package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    @Autowired
    CoderRepository repository;

    @GetMapping("/")
    public String home() {

        return "main.jsp";

    }

    // This endpoint is mainly called by the form in main.jsp.
    @GetMapping("/addCoder")
    public String addCoder(Coder coder) {

        repository.save(coder);
        return "main.jsp";

    }

    // This endpoint is mainly called by the form in main.jsp.
    @GetMapping("/getCoder")
    public ModelAndView getCoder(@RequestParam int id) {

        ModelAndView mv = new ModelAndView("getCoder.jsp");
        Coder coder = repository.findById(id).orElse(new Coder());
        mv.addObject(coder);

        return mv;

    }

}
