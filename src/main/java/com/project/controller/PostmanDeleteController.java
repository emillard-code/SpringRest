package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PostmanDeleteController {

    @Autowired
    CoderRepository repository;

    @DeleteMapping("/deleteCoder1/{id}")
    public Coder deleteCoderById1(@PathVariable("id") int id) {

        Optional<Coder> coder = repository.findById(id);
        repository.deleteById(id);

        return new Coder();

    }

    @DeleteMapping("/deleteCoder2/{id}")
    public Coder deleteCoderById2(@PathVariable("id") int id) {

        // Main differences between .findById() and .getOne() is that
        // the former is eagerly loaded while the latter is lazily loaded.
        // Technically speaking .getOne() does not even hit the database, just a proxy value.
        Coder coder = repository.getOne(id);
        repository.delete(coder);

        return new Coder();

    }

}
