package com.sprobe.iaoy.hris.person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Karl Joseph C. Kangleon
 * @since 1.0.0
 */

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "person")
public class Person {

    //region > id (property)
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    //endregion

    //region > firstName (property)
    @Column(nullable = false)
    @Getter
    @Setter
    private String firstName;
    //endregion

    //region > lastName (property)
    @Column(nullable = false)
    @Getter
    @Setter
    private String lastName;
    //endregion

    //region > emailAddress (property)
    @Column(nullable = false)
    @Getter
    @Setter
    private String emailAddress;
    //endregion
}
