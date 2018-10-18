package com.sprobe.iaoy.hris.person.baspersonrepository;

import com.sprobe.iaoy.hris.person.Person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Karl Joseph C. Kangleon
 * @since 1.0.0
 */
@RepositoryRestResource
public interface BasePersonRepository extends JpaRepository<Person, Long> {
    Page<Person> findAll(final Pageable pageable);

    @Query("SELECT person FROM Person person " +
            "WHERE LOWER(person.emailAddress) = LOWER(:emailAddress)")
    Person findByEmailAddress(
            @Param("emailAddress")
            final String emailAddress);
}
