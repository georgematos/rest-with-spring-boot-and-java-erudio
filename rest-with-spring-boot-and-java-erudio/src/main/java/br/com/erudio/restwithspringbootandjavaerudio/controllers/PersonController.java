package br.com.erudio.restwithspringbootandjavaerudio.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.restwithspringbootandjavaerudio.dto.PersonDTO;
import br.com.erudio.restwithspringbootandjavaerudio.models.Person;
import br.com.erudio.restwithspringbootandjavaerudio.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> findAllPersons() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable String id) {
        return personService.simplefiedFindById(UUID.fromString(id));
    }

    @PostMapping
    public PersonDTO savePerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping
    public PersonDTO updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable String id) {
        personService.deletePerson(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}