package com.cloudskol.restskol.resources;

import com.cloudskol.restskol.data.PersonDataStore;
import com.cloudskol.restskol.model.Person;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @author tham
 *
 * Person resource with CRUD operation
 */

public class PersonResource implements IPersonResource {

    @Override
    public Response all() {
        final PersonDataStore dataStore = PersonDataStore.getInstance();
        return Response.ok(dataStore.getPersons()).build();
    }

    @Override
    public Response get(String fName) {
        final PersonDataStore dataStore = PersonDataStore.getInstance();
        return Response.ok(dataStore.getPerson(fName)).build();
    }

    @Override
    public Response create(Person person) {
        final PersonDataStore dataStore = PersonDataStore.getInstance();
        dataStore.addPerson(person);

        return Response.created(
                UriBuilder.fromPath("/persons/" + person.getfName())
                        .build())
                .entity("/persons/" + person.getfName()).build();
    }

    @Override
    public void update(String fName, Person person) {
        final PersonDataStore dataStore = PersonDataStore.getInstance();
        dataStore.update(fName, person);
    }

    @Override
    public void delete(String fName) {
        final PersonDataStore dataStore = PersonDataStore.getInstance();
        dataStore.delete(fName);
    }
}
