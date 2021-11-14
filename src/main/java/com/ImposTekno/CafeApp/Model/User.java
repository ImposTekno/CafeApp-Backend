package com.ImposTekno.CafeApp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


@Entity
//@Table(name = "users")
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String password;

    public User(Long _id, String _firstName, String _lastName, String _password)
    {
        this.id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.password = _password; 
    }
    public User()
    {

    }

    public Long getId(){    return this.id; }
    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public boolean checkPassword(String _password)
    {
        if(this.password == _password)
        {
            return true;
        }
        return false;

    }

    public void setFirstName(String _firstName)
    {
        this.firstName=_firstName;
    }
    public void setLastName(String _lastName)
    {
        this.lastName = _lastName;
    }
    public void setPassword(String _password )
    {
        this.password = _password;
        //this.password = "TeknoPass";
    }


    @Override
    public String toString()
    {
        return "User{ " + "id" + id + ", name: " + firstName + ", surname: " + lastName+ " }";
    }


}
