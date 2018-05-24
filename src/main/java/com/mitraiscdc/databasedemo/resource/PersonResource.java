package com.mitraiscdc.databasedemo.resource;

import com.mitraiscdc.databasedemo.model.Person;
import com.mitraiscdc.databasedemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * REST API using JAX-RS
 */

@Path("api/v1/persons")
@Validated
public class PersonResource {

    private PersonService personService;

    @Autowired
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPeople() {
        return personService.getPeople();
    }

    @GET
    @Path("{personid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("personid") int personid) {
        Person personById = personService.getPersonById(personid);
        return personById;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPerson(@RequestBody @Valid Person person) {
        int insertResult = personService.insertPerson(person);

        return getResponse(insertResult);
    }

    @PUT
    public Response updatePerson(@RequestBody @Valid Person person) {
        int updateResult = personService.updatePerson(person);

        return getResponse(updateResult);
    }

    @DELETE
    @Path("{personid}")
    public Response deletePerson(@PathParam("personid") int id) {
        int deleteResult = personService.deletePerson(id);

        return getResponse(deleteResult);
    }

    private Response getResponse(int insertResult) {
        return insertResult == 1 ? Response.ok().build() : Response.status(Response.Status.BAD_REQUEST).build();
    }
}
