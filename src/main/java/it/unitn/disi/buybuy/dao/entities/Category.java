/*
 * Category.java
 */
package it.unitn.disi.buybuy.dao.entities;

import java.io.Serializable;

/**
 * The bean that map a {@code category} entity.
 */
public class Category implements Serializable{
    
    private Integer id;
    private String name;
    
    /**
     * Returns the primary key of this category entity.
     * @return the id of the category entity.
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the new primary key of this category entity.
     * @param id the new id of this category entity.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Returns the name of this category entity.
     * @return the name of this category entity.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the new name of this category entity.
     * @param name the new name of this category entity.
     */
    public void setName(String name) {
        this.name = name;
    }
}
