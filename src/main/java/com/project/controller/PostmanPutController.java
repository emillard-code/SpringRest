package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostmanPutController {

    @Autowired
    CoderRepository repository;

    @PutMapping("/updateCoder")
    public Coder updateCoder(@RequestBody Coder coder) {

        repository.save(coder);
        return coder;

    }

}
