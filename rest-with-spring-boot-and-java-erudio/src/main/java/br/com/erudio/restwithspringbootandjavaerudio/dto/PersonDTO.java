package br.com.erudio.restwithspringbootandjavaerudio.dto;

import java.util.UUID;

public class PersonDTO {
    private UUID id;
    private String firstName;

    public PersonDTO() {

    }

    public PersonDTO(UUID id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
