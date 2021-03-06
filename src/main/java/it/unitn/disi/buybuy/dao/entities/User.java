/*
 * User.java
 */
package it.unitn.disi.buybuy.dao.entities;

import java.io.Serializable;

/**
 * The bean that map a {@code user} entity.
 */
public class User implements Serializable{
    
    public enum Type {REGISTERED, SELLER, ADMINISTRATOR, REGISTRATION_PENDING};
    
    private Integer id;
    private String name;
    private String lastname;
    private String username;
    private String email;
    private String hashPassword;
    private String hashSalt;
    private String confirmationID;
    private Type type;

    /**
     * Returns the primary key of this user entity.
     * @return the id of the user entity.
     */
    public Integer getId() {
        return id;
    }
    
    /**
     * Sets the new primary key of this user entity.
     * @param id the new id of this user entity.
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * Returns the name of this user entity.
     * @return the name of this user entity.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the new name of this user entity.
     * @param name the new name of this user entity.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the lastname of this user entity.
     * @return the lastname of this user entity.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets the new lastname of this user entity.
     * @param lastname the new lastname of this user entity.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    /**
     * Returns the username of this user entity.
     * @return the username of this user entity.
     */    
    public String getUsername() {
        return username;
    }

    /**
     * Sets the new username of this user entity.
     * @param username the new username of this user entity.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the email of this user entity.
     * @return the email of this user entity.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the new email of this user entity.
     * @param email the new email of this user entity.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the hash password of this user entity.
     * @return the hash password of this user entity.
     */
    public String getHashPassword() {
        return hashPassword;
    }
    
    /**
     * Returns the hash salt of this user entity.
     * 
     * @return the hash salt of this user entity.
     */
    public String getHashSalt() {
        return hashSalt;
    }

    /**
     * Sets the new hash password of this user entity.
     * @param hashPassword the new hash password of this user entity.
     */
    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }
    
    /**
     * Sets the new hash password of this user entity.
     * 
     * @param hashSalt the new hash password of this user entity.
     */
    public void setHashSalt(String hashSalt) {
        this.hashSalt = hashSalt;
    }
    
    /**
     * Returns confirmation ID of this user entity.
     * 
     * @return the confirmation ID of this user.
     */
    public String getConfirmationID() {
        return confirmationID;
    }
    
    /**
     * Sets the confirmation ID of this user entity.
     * 
     * @param id confirmation ID of this user.
     */
    public void setConfirmationID(String id) {
        this.confirmationID = id;
    }

    /**
     * Returns the type of this user entity.
     * @return the type of this user entity.
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets the new type of this user entity.
     * @param type the new type of this user entity.
     */
    public void setType(Type type) {
        this.type = type;
    }
    
}
