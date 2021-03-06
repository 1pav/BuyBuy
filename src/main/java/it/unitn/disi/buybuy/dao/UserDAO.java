/*
 * UserDAO.java
 */
package it.unitn.disi.buybuy.dao;

import it.unitn.aa1617.webprogramming.persistence.utils.dao.DAO;
import it.unitn.aa1617.webprogramming.persistence.utils.dao.exceptions.DAOException;
import it.unitn.disi.buybuy.dao.entities.User;
import java.util.List;

/**
 * All concrete DAOs must implement this interface to handle the persistence 
 * system that interact with {@code User}.
 */
public interface UserDAO extends DAO<User,Integer>{
    /**
     * Returns the number of {@link Retailer retailers} stored on the persistence system
     * of the application.
     *
     * @return the number of records present into the storage system.
     * @throws DAOException if an error occurred during the information
     * retrieving.
     */
    @Override
    public Long getCount() throws DAOException;

    /**
     * Returns the {@link User user} with the primary key equals to the one
     * passed as parameter.
     *
     * @param primaryKey the {@code id} of the {@code user} to get.
     * @return the {@code user} with the id equals to the one passed as
     * parameter or {@code null} if no entities with that id is not present into
     * the storage system.
     * @throws DAOException if an error occurred during the information
     * retrieving.
     */
    @Override
    public User getByPrimaryKey(Integer primaryKey) throws DAOException;
    
    /**
     * Returns the {@link User user} with the email and hashed password equals
     * to the ones passed as parameters
     *
     * @param email email of the user
     * @param hashedPassword hashed password of the user
     * @return the {@code user} with the id equals to the one passed as
     * parameter or {@code null} if no entities with that id is not present into
     * the storage system.
     * @throws DAOException if an error occurred during the information
     * retrieving.
     */
    public User getByEmailAndPassword(String email, String hashedPassword) throws DAOException;

    /**
     * Returns the list of all the valid {@link User users} stored by the
     * storage system.
     *
     * @return the list of all the valid {@code users}.
     * @throws DAOException if an error occurred during the information
     * retrieving.
     */
    @Override
    public List<User> getAll() throws DAOException;
    
    /**
     * Update the user passed as parameter and returns it.
     * @param user the user used to update the persistence system.
     * @return the updated user.
     * @throws DAOException if an error occurred during the action.
     */
    @Override
    public User update(User user) throws DAOException;
    
    /**
     * Persists the new {@link User user} passed as parameter to the storage
     * system.
     * @param user the new {@code user} to persist.
     * @return the id of the new persisted record. 
     * @throws DAOException if an error occurred during the persist action.
     */
    public Long insert(User user) throws DAOException;
    
    /**
     * Gets salt and hashed password by email
     * @param email string
     * @return Array of size two. At 0 there's salt and at 1 there's hashed password
     * @throws DAOException if an error occurred during the persist action.
     */
    public String[] getSaltAndHashByEmail(String email) throws DAOException;
    
    public User getByEmail(String email) throws DAOException;
    
    public User getByUsername(String username) throws DAOException;
    
    public User getByConfirmationID(String confirmationID) throws DAOException;
    
    public User updateProfile(User user) throws DAOException;
     
}
