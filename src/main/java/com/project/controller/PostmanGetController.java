package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PostmanGetController {

    @Autowired
    CoderRepository repository;

    // This automatically returns the object in JSON format.
    @GetMapping("/coder/{id}")
    public Optional<Coder> coderById(@PathVariable("id") int id) {

        return repository.findById(id);

    }

    // This automatically returns the list of objects in JSON format.
    @GetMapping("/getCoders")
    public List<Coder> getCoders() {

        return repository.findAll();

    }

    // produces = "application/xml" ensures that this endpoint can only return xml format.
    @GetMapping(path = "/getCodersXML", produces = "application/xml")
    public List<Coder> getCodersXML() {

        return repository.findAll();

    }

}
