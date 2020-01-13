package com.noxus.draven.data.hibernate.respository;

import com.noxus.draven.data.hibernate.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersionRepository extends JpaRepository<Person, String> {


}
