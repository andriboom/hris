package com.sprobe.iaoy.hris.person;

import com.sprobe.iaoy.hris.person.baspersonrepository.BasePersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Karl Joseph C. Kangleon
 * @since 1.0.0
 */
@Service
public class PersonRepositoryService {

    //region > createPerson
    public Person createPerson(final Person personRequest) {
        final Person person = new Person();
        person.setFirstName(personRequest.getFirstName());
        person.setLastName(personRequest.getLastName());
        person.setEmailAddress(personRequest.getEmailAddress());
        basePersonRepository.save(person);

        return person;
    }
    //endregion

    //region > findByEmailAddress
    public Person findByEmailAddress(final String emailAddress) {
        return basePersonRepository.findByEmailAddress(emailAddress);
    }
    //endregion

    //region > findById
    public Person findById(final Long id) {
        return basePersonRepository.findById(id)
                .orElse(null);
    }
    //endregion

    //region > findAll
    public Page<Person> findAll(final Pageable pageable) {
        return basePersonRepository.findAll(pageable);
    }
    //endregion

    //region > injected dependencies
    @Autowired
    private BasePersonRepository basePersonRepository;
    //endregion
}
