package br.com.erudio.restwithspringbootandjavaerudio.services;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.restwithspringbootandjavaerudio.dto.PersonDTO;
import br.com.erudio.restwithspringbootandjavaerudio.exceptions.ResourceNotFoundException;
import br.com.erudio.restwithspringbootandjavaerudio.models.Person;
import br.com.erudio.restwithspringbootandjavaerudio.repository.PersonRepository;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public PersonService() {
    }

    public List<Person> findAll() {
        logger.info("Finding all persons!");
        return personRepository.findAll();
    }

    public Person simplefiedFindById(UUID id) {
        logger.info("Finding one person!");
        return findById(id);
    }

    public PersonDTO createPerson(Person person) {
        logger.info("Creating one person!");
        Person savedEntity = personRepository.save(person);
        return new PersonDTO(savedEntity.getId(), savedEntity.getFirstName());

    }

    private Person findById(UUID id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public PersonDTO updatePerson(Person person) {
        logger.info("Editing one person!");
        Person entity = simplefiedFindById(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        personRepository.save(entity);
        return new PersonDTO(entity.getId(), entity.getFirstName());
    }

    public void deletePerson(UUID id) {
        logger.info("Deleting one person!");
        Person entity = simplefiedFindById(id);
        personRepository.deleteById(entity.getId());
    }

}
