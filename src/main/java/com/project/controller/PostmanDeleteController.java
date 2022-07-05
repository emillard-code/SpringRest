package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostmanDeleteController {

    @Autowired
    CoderRepository repository;

    @DeleteMapping("/coder/{id}")
    public Coder deleteCoderById(@PathVariable("id") int id) {

        Coder coder = repository.getOne(id);
        repository.delete(coder);

        return new Coder();

    }

}
