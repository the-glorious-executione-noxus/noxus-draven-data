package com.noxus.draven.data.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;


@Entity
@Table
@Data
@AllArgsConstructor
public class Person {

    private static final Map GENERATORS = new HashMap<>();

    static {

        GENERATORS.put("uuid", UUIDHexGenerator.class);

        //GENERATORS.put("hilo", TableHiLoGenerator.class);

        GENERATORS.put("assigned", Assigned.class);

        GENERATORS.put("identity", IdentityGenerator.class);

        GENERATORS.put("select", SelectGenerator.class);

        GENERATORS.put("sequence", SequenceGenerator.class);

        GENERATORS.put("seqhilo", SequenceHiLoGenerator.class);

        GENERATORS.put("increment", IncrementGenerator.class);

        GENERATORS.put("foreign", ForeignGenerator.class);

        GENERATORS.put("guid", GUIDGenerator.class);

        GENERATORS.put("uuid.hex", UUIDHexGenerator.class); //uuid.hex is deprecated

        GENERATORS.put("sequence-identity", SequenceIdentityGenerator.class);

    }


    //@GeneratedValue(strategy = GenerationType.AUTO)
    //适应数据库自增长
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence")
    //@SequenceGenerator(name = "id_sequence", initialValue = 1, allocationSize = 1, sequenceName = "ID_SEQUENCE")

    //@GeneratedValue(generator = "paymentableGenerator")
    //@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

    @Id
    @GeneratedValue(generator = "UUIDHexGenerator")
    @GenericGenerator(name = "UUIDHexGenerator", strategy = "uuid.hex")
    private String id;

    private String firstname;

    private String lastname;

    private String address;

    public Person() {
    }
}
