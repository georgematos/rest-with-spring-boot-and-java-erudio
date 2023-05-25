package br.com.erudio.restwithspringbootandjavaerudio.models;

import java.util.Objects;
import java.util.UUID;

public class Person {

    private UUID id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;

    public Person(Builder builder) {
        this.setId(builder.id);
        this.setFirstName(builder.firstName);
        this.setLastName(builder.lastName);
        this.address(builder.address);
        this.gender(builder.gender);
    }

    public static class Builder {
        private UUID id;
        private String firstName;
        private String lastName;
        private String address;
        private String gender;

        public Builder() {
            this.id = UUID.randomUUID();
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
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

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Person id(UUID id) {
        setId(id);
        return this;
    }

    public Person firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Person lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Person address(String address) {
        setAddress(address);
        return this;
    }

    public Person gender(String gender) {
        setGender(gender);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person)) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", firstName='" + getFirstName() + "'" +
                ", lastName='" + getLastName() + "'" +
                ", address='" + getAddress() + "'" +
                ", gender='" + getGender() + "'" +
                "}";
    }

}
