/*
 * RetailerDAO.java
 */
package it.unitn.disi.buybuy.dao;

import it.unitn.aa1617.webprogramming.persistence.utils.dao.DAO;
import it.unitn.aa1617.webprogramming.persistence.utils.dao.exceptions.DAOException;
import it.unitn.disi.buybuy.dao.entities.Retailer;
import java.util.List;

/**
 * All concrete DAOs must implement this interface to handle the persistence 
 * system that interact with {@code Retailer}.
 */
public interface RetailerDAO extends DAO<Retailer,Integer>{
    
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
     * Returns the {@link Retailer retailer} with the primary key equals to the one
     * passed as parameter.
     *
     * @param primaryKey the {@code id} of the {@code retailer} to get.
     * @return the {@code retailer} with the id equals to the one passed as
     * parameter or {@code null} if no entities with that id is not present into
     * the storage system.
     * @throws DAOException if an error occurred during the information
     * retrieving.
     */
    @Override
    public Retailer getByPrimaryKey(Integer primaryKey) throws DAOException;

    /**
     * Returns the list of all the valid {@link Retailer retailers} stored by the
     * storage system.
     *
     * @return the list of all the valid {@code retailers}.
     * @throws DAOException if an error occurred during the information
     * retrieving.
     */
    @Override
    public List<Retailer> getAll() throws DAOException;
    
    /**
     * Persists the new {@link Retailer retailers} passed as parameter to the storage
     * system.
     * @param retailer the new {@code retailer} to persist.
     * @return the id of the new persisted record. 
     * @throws DAOException if an error occurred during the persist action.
     */
    public Long insert(Retailer retailer) throws DAOException;
    
    /**
     * Update the retailer passed as parameter and returns it.
     *
     * @param retailer the retailer used to update the persistence system.
     * @return the updated retailer.
     * @throws DAOException if an error occurred during the action.
     */
    @Override
    public Retailer update(Retailer retailer) throws DAOException;

    public Retailer getPositionByItemID(Integer id) throws DAOException;

    
    public Retailer getByShopId(Integer id) throws DAOException;
}
