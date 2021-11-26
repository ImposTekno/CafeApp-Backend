package com.ImposTekno.CafeApp.Model;

import javax.naming.StringRefAddr;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class CafeShop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long Id;

    @Column(nullable = false)
    private String cafeName;
    private String cafeAddress;
    @Column(nullable = false)
    private int maxTables;

    @Column(nullable = false)
    private String cuisine;


    public CafeShop(String _cafeName, String _cafeAddress, String _cuisine ,int _maxTables)
    {
        this.cafeName = _cafeName;
        this.cafeAddress = _cafeAddress;
        this.cuisine = _cuisine;
        this.maxTables = _maxTables;
    }
    public CafeShop()
    {

    }


    // Setter methods
    public void setCafeName(String _cafeName)
    {
        this.cafeName = _cafeName;
    }
    public void setCafeAddress(String _cafeAddress)
    {
        this.cafeAddress = _cafeAddress;
    }
    public void setMaxTables(int _maxTables)
    {
        this.maxTables = _maxTables;
    }
    public void setCuisine(String inCuisine)
    {
        this.cuisine = inCuisine;
    }

    // Getter methods

    public Long getId()
    {
        return this.Id;
    }
    public String getCafeName()
    {
        return this.cafeName;
    }
    public String getCafeAddress()
    {
        return this.cafeAddress;
    }
    public int getMaxTables()
    {
        return this.maxTables;
    }
    public String getCuisineType()
    {
        return this.cuisine;
    }

}
