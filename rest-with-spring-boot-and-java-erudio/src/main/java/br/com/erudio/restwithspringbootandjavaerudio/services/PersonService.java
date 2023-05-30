package br.com.erudio.restwithspringbootandjavaerudio.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.restwithspringbootandjavaerudio.dto.PersonDTO;
import br.com.erudio.restwithspringbootandjavaerudio.models.Person;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());
    private List<Person> persons = new ArrayList<>();

    public PersonService() {
        persons.addAll(mockPersons());
    }

    public List<Person> findAll() {
        logger.info("Finding all persons!");
        return persons;
    }

    public Person getById(UUID id) {
        logger.info("Finding one person!");
        return persons.stream().filter((x) -> x.getId().equals(id)).findFirst().get();
    }

    public PersonDTO createPerson(Person person) {
        logger.info("Creating one person!");
        person.setId(UUID.randomUUID());
        persons.add(person);
        return new PersonDTO(person.getId(), person.getFirstName());
    }
    
    public PersonDTO updatePerson(Person person) {
        logger.info("Editing one person!");
        for (Person p : persons) {
            if (p.getId().equals(person.getId())) {
                if (person.getFirstName() != null) p.setFirstName(person.getFirstName());
                if (person.getLastName() != null) p.setLastName(person.getLastName());
                if (person.getAddress() != null) p.setAddress(person.getAddress());
                if (person.getGender() != null) p.setGender(person.getGender());
                return new PersonDTO(p.getId(), p.getFirstName());
            }
        }
        return null;
    }

    public void deletePerson(UUID id) {
        logger.info("Deleting one person!");
        persons.removeIf(x -> x.getId().equals(id));
    }

    private List<Person> mockPersons() {
        Person person1 = new Person.Builder()
                .withFirstName("George")
                .withLastName("Matos")
                .withAddress("Rua Oriente, 121, Piratininga")
                .withGender("Male").build();
        Person person2 = new Person.Builder()
                .withFirstName("Thaiane")
                .withLastName("Matos")
                .withAddress("Rua Oriente, 121, Piratininga")
                .withGender("Female").build();
        Person person3 = new Person.Builder()
                .withFirstName("Moana")
                .withLastName("Matos")
                .withAddress("Rua Oriente, 121, Piratininga")
                .withGender("Dog").build();

        return Arrays.asList(person1, person2, person3);
    }
}
