package com.stefanini.appointmentapp.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Department is an entity that represents departments in clinic.
 *
 * @author cvigulea
 */

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id Long
     */

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return String
     */

    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name String
     */

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
