package com.stefanini.appointmentapp.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Speciality is an entity that represents a speciality from a department.
 *
 * @author cvigulea
 */

@Entity
@Table(name = "speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Error: Speciality name must not be blank!")
    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    /**
     * Gets id.
     *
     * @return Long
     */

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

    /**
     * Gets department.
     *
     * @return Department
     */

    public Department getDepartment() {
        return department;
    }

    /**
     * Sets department.
     *
     * @param department Department
     */

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
