/*
 * IssueDAO.java
 */
package it.unitn.disi.buybuy.dao;

import it.unitn.aa1617.webprogramming.persistence.utils.dao.DAO;
import it.unitn.aa1617.webprogramming.persistence.utils.dao.exceptions.DAOException;
import it.unitn.disi.buybuy.dao.entities.Issue;
import java.util.List;

/**
 * All concrete DAOs must implement this interface to handle the persistence 
 * system that interact with {@code Issue}.
 */
public interface IssueDAO extends DAO<Issue,Integer>{
    
    /**
     * Returns the number of {@link Issue issue} stored on the persistence system
     * of the application.
     *
     * @return the number of records present into the storage system.
     * @throws DAOException if an error occurred during the information
     * retrieving.
     */
    @Override
    public Long getCount() throws DAOException;

    /**
     * Returns the {@link Issue issue} with the primary key equals to the one
     * passed as parameter.
     *
     * @param primaryKey the {@code id} of the {@code issue} to get.
     * @return the {@code issue} with the id equals to the one passed as
     * parameter or {@code null} if no entities with that id is not present into
     * the storage system.
     * @throws DAOException if an error occurred during the information
     * retrieving.
     */
    @Override
    public Issue getByPrimaryKey(Integer primaryKey) throws DAOException;

    /**
     * Returns the list of all the valid {@link Issue issue} stored by the
     * storage system.
     *
     * @return the list of all the valid {@code issue}.
     * @throws DAOException if an error occurred during the information
     * retrieving.
     */
    @Override
    public List<Issue> getAll() throws DAOException;
    
    /**
     * Persists the new {@link Issue issue} passed as parameter to the storage
     * system.
     * @param issue the new {@code issue} to persist.
     * @return the id of the new persisted record. 
     * @throws DAOException if an error occurred during the persist action.
     */
    public Long insert(Issue issue) throws DAOException;
    
    /**
     * Update the issue passed as parameter and returns it.
     *
     * @param issue the issue used to update the persistence system.
     * @return the updated issue.
     * @throws DAOException if an error occurred during the action.
     */
    @Override
    public Issue update(Issue issue) throws DAOException;
    
    public Integer getCountNotReadBySellerId(Integer seller_id) throws DAOException;
    
    public Integer getCountNotReadForAdmin() throws DAOException;
    
    public List<Issue> getBySellerId(Integer seller_id) throws DAOException;
    
    public List<Issue> getNotReadedBySellerId(Integer seller_id) throws DAOException;
    
    public List<Issue> getAllOpened() throws DAOException;
    
    public Issue setSellerRead(Issue issue) throws DAOException;
    
    public Issue setAdminRead(Issue issue) throws DAOException;
    
    public Issue setAdminChoice(Issue issue) throws DAOException;
}
