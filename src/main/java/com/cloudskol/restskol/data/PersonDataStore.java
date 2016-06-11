package com.cloudskol.restskol.data;

import com.cloudskol.restskol.model.Book;
import com.cloudskol.restskol.model.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author tham (zarub2k@gmail.com)
 * Dummay data store class for providing book related information
 */
public class PersonDataStore {
    private static final PersonDataStore personDataStore = new PersonDataStore();
    private List<Person> availablePersons = new ArrayList<>();

    public static final synchronized PersonDataStore getInstance() {
        return personDataStore;
    }

    public List<Person> getPersons() {
        if (availablePersons.isEmpty()) {
            initialize();
        }

        return availablePersons;
    }

    public Person getPerson(String fName) {
        if (availablePersons.isEmpty()) {
            initialize();
        }

        for (Person person : availablePersons) {
            if (person.getfName().equals(fName)) {
                return person;
            }
        }

        return null;
    }

    public void initialize() {
        availablePersons.add(newPerson("Roger", "Federer"));
        availablePersons.add(newPerson("Rafel", "Nadal"));
        availablePersons.add(newPerson("Novak", "Djokovic"));
    }

    public Person newPerson(String fName, String lName) {
        return new Person(fName, lName);
    }

    public void addPerson(Person person) {
        if (availablePersons.isEmpty()) {
            initialize();
        }

        availablePersons.add(person);
    }

    public void delete(String fName) {
        if (availablePersons == null || availablePersons.isEmpty()) {
            return;
        }

        final Iterator<Person> iterator = availablePersons.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getfName().equals(fName)) {
                iterator.remove();
                break;
            }
        }
    }

    public void update(String fName, Person person) {
        delete(fName);

        addPerson(person);
    }
}
