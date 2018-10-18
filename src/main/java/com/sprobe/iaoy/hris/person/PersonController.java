package com.sprobe.iaoy.hris.person;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Karl Joseph C. Kangleon
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "person")
public class PersonController {

    //region > createPerson
    @PostMapping(value = "create")
    @ResponseBody
    public Person createPerson(
            @Valid
            @RequestBody final Person person) throws ValidationException {
        if (isEmailAlreadyExists(person.getEmailAddress())) {
            throw new ValidationException("Email address already exists.");
        }

        return personRepositoryService.createPerson(person);
    }
    //endregion

    //region > deletePerson
    @PostMapping(value="delete/{id}")
    public void deletePerson (
            @PathVariable(value = "id")
            final Long id,
            @RequestBody
            final Person person) { }
    //endregion

    //region > findAll
    @GetMapping(value = "/")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public Page<Person> findAll(final Pageable pageable) {
        return personRepositoryService.findAll(pageable);
    }
    //endregion

    //region > isEmailAlreadyExists
    private boolean isEmailAlreadyExists(final String emailAddress) {
        final Person existing = personRepositoryService.findByEmailAddress(emailAddress);

        return existing != null;
    }
    //endregion

    //region > updatePerson
    @PostMapping(value = "update/{id}")
    public Person updatePerson(
            @PathVariable(value = "id") final Long id,
            @Valid
            @RequestBody final Person person) throws ValidationException {
        if (isEmailAlreadyExists(person.getEmailAddress())) {
            throw new ValidationException("Email address already exists.");
        }

        return personRepositoryService.updatePerson(id, person);
    }
    //endregion

    //region > injected dependencies
    @Autowired
    private PersonRepositoryService personRepositoryService;
    //endregion
}
