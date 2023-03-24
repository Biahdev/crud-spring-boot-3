package dev.abeatriz.crud.controller;


import dev.abeatriz.crud.service.PersonService;
import dev.abeatriz.crud.vo.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public List<PersonVO> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public PersonVO create(@RequestBody PersonVO person){
        return service.create(person);
    }

    @DeleteMapping("/{id}")
    public PersonVO delete(@PathVariable Long id){
        return service.delete(id);
    }

}
