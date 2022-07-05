package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class CoderController {

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

    // You can test this endpoint through Postman.
    // Use "form-data" tab with the necessary variable names as keys.
    @PostMapping("/addCoderForm")
    public Coder addCoderForm(Coder coder) {

        repository.save(coder);
        return coder;

    }

    // You can test this endpoint through Postman.
    // Use "raw" tab with the necessary data in a Json format.
    @PostMapping("/addCoderJson")
    public Coder addCoderJson(@RequestBody Coder coder) {

        repository.save(coder);
        return coder;

    }

    // This endpoint is mainly called by the form in main.jsp.
    @GetMapping("/getCoder")
    public ModelAndView getCoder(@RequestParam int id) {

        ModelAndView mv = new ModelAndView("getCoder.jsp");
        Coder coder = repository.findById(id).orElse(new Coder());
        mv.addObject(coder);

        return mv;

    }

    // @ResponseBody annotation causes the String to be printed directly as text.
    // (Rather than be treated as a file name)
    @GetMapping("/getCoders")
    @ResponseBody
    public List<Coder> getCoders() {

        return repository.findAll();

    }

    // @ResponseBody annotation causes the String to be printed directly as text.
    // (Rather than be treated as a file name)
    // produces = "application/xml" ensures that this endpoint can only return xml format.
    @GetMapping(path = "/getCodersXML", produces = "application/xml")
    @ResponseBody
    public List<Coder> getCodersXML() {

        return repository.findAll();

    }

    // @ResponseBody annotation causes the String to be printed directly as text.
    // (Rather than be treated as a file name)
    @GetMapping("/coder/{id}")
    @ResponseBody
    public Optional<Coder> coderById(@PathVariable("id") int id) {

        return repository.findById(id);

    }

}
