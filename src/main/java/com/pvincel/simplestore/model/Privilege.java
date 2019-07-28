package com.pvincel.simplestore.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Privilege {

    private String id;
    private PrivilegeName privilegeName;

    @ManyToMany
    @JoinTable(name = "role_privilege", joinColumns = {
            @JoinColumn(name = "privilege_id")},
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private List<Role> roles;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PrivilegeName getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(PrivilegeName privilegeName) {
        this.privilegeName = privilegeName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
