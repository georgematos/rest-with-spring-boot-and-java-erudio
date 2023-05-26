package br.com.erudio.restwithspringbootandjavaerudio.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.restwithspringbootandjavaerudio.models.Person;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());
    private List<Person> persons = new ArrayList<>();

    public List<Person> findAll() {
        logger.info("Finding all persons!");
        persons.addAll(mockPersons());
        return persons;
    }

    public Person getById(UUID id) {
        logger.info("Finding one person!");
        return persons.stream().filter((x) -> x.getId().equals(id)).findFirst().get();
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
