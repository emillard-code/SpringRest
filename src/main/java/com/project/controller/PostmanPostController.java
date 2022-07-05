package com.project.controller;

import com.project.model.Coder;
import com.project.repository.CoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostmanPostController {

    @Autowired
    CoderRepository repository;

    // You can test this endpoint through Postman.
    // Use "form-data" tab with the necessary variable names as keys.
    @PostMapping("/addCoderForm")
    public Coder addCoderForm(Coder coder) {

        repository.save(coder);
        return coder;

    }

    // You can test this endpoint through Postman.
    // Use "raw" tab with the necessary data in a JSON format.
    @PostMapping("/addCoderDefault")
    public Coder addCoderDefault(@RequestBody Coder coder) {

        repository.save(coder);
        return coder;

    }

    // You can test this endpoint through Postman.
    // Use "raw" tab with the necessary data in a JSON format.
    @PostMapping(path = "/addCoderJSON", consumes = "application/json")
    public Coder addCoderJson(@RequestBody Coder coder) {

        repository.save(coder);
        return coder;

    }

    // You can test this endpoint through Postman.
    // Use "raw" tab with the necessary data in an XML format.
    @PostMapping(path = "/addCoderXML", consumes = "application/xml")
    public Coder addCoderXml(@RequestBody Coder coder) {

        repository.save(coder);
        return coder;

    }

}
