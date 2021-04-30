package com.ttpl.asd.drukairagentwebportal.auth.model;

import javax.persistence.*;

import java.math.BigInteger;
import java.util.Set;

@Entity
@Table(name = "da_role")
public class Role {
    private BigInteger id;
    private String name;
    private Set < User > users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set < User > getUsers() {
        return users;
    }

    public void setUsers(Set < User > users) {
        this.users = users;
    }
}
