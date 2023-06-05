package br.com.erudio.restwithspringbootandjavaerudio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.restwithspringbootandjavaerudio.models.Person;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    
}
