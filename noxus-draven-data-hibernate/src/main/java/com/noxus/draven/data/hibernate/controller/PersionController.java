package com.noxus.draven.data.hibernate.controller;

import com.noxus.draven.data.hibernate.entity.Person;
import com.noxus.draven.data.hibernate.respository.PersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PersionController {

    @Autowired
    private PersionRepository persionRepository;


    @GetMapping(value = "/findAll")
    public List<Person> getAll() {
        return persionRepository.findAll();
    }

    /**
     * Hibernate: select person0_.id as id1_0_0_, person0_.address as address2_0_0_, person0_.firstname as firstnam3_0_0_, person0_.lastname as lastname4_0_0_ from person person0_ where person0_.id=?
     * <p>
     * Hibernate: select person0_.id as id1_0_0_, person0_.address as address2_0_0_, person0_.firstname as firstnam3_0_0_, person0_.lastname as lastname4_0_0_ from person person0_ where person0_.id=?
     * Hibernate: select next_val as id_val from hibernate_sequence for update
     * Hibernate: update hibernate_sequence set next_val= ? where next_val=?
     * Hibernate: insert into person (address, firstname, lastname, id) values (?, ?, ?, ?)
     *
     * @param id
     * @return
     */
    @RequestMapping("/save/{id}")
    public Person save(@PathVariable("id") String id) {
        Person person = new Person(id, "firstname", "lastname", "address");
        Person save = persionRepository.save(person);
        return save;
    }

    @RequestMapping("/saves/{id}")
    public Person saves(@PathVariable("id") String id) {
        //Person person = new Person(id, "firstname", "lastname", "address");
        Optional<Person> persons = persionRepository.findById(id);
        Boolean present = persons.isPresent();
        Person person = persons.get();
        person.setFirstname("wahaha");
        Person save = persionRepository.save(person);
        return save;

    }

    @PostMapping(value = "/stream/save")
    public @Valid Person save(@Valid @RequestBody Person user) {
        user.setId(null);
        return persionRepository.save(user);
    }
}

/**
 * Error:(19, 46) java: constructor Person in class noxus.draven.data.hibernate.entity.Person cannot be applied to given types;
 * required: no arguments
 * found: int,java.lang.String,java.lang.String,java.lang.String
 * reason: actual and formal argument lists differ in length
 */