package br.com.erudio.restwithspringbootandjavaerudio.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.restwithspringbootandjavaerudio.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    
}
