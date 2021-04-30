package com.ttpl.asd.drukairagentwebportal.auth.dao;

import com.ttpl.asd.drukairagentwebportal.auth.model.User;
import com.ttpl.asd.drukairagentwebportal.dto.UserRegistrationDto;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and
 * configure the DAO wihtout any XML configuration and also provide the Spring
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public void delete(User user) {
        if (entityManager.contains(user))
            entityManager.remove(user);
        else
            entityManager.remove(entityManager.merge(user));
        return;
    }

    public List<UserRegistrationDto> getAll() {
        String sql = "select  username as username, agentname as agentName, status as statusId from da_user";
        List<UserRegistrationDto> userRegistrationDtoList =
                entityManager.createNativeQuery(sql)
                        .unwrap(SQLQuery.class).
        setResultTransformer(Transformers.aliasToBean(UserRegistrationDto.class)).getResultList();

        return userRegistrationDtoList;
    }

    public User getUser(String username) {

        try {
            return (User) entityManager.createQuery("from User where username=:username")
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;

        }

    }

    public User getByEmail(String email) {
        return (User) entityManager.createQuery("from User where email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    /**
     * Return the user having the passed id.
     */
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * Update the passed user in the database.
     */
    public void update(User user) {
        entityManager.merge(user);
        return;
    }

    public User getUserById(Integer userId) {
        return (User) entityManager.createQuery("from User where id=:userId")
                .setParameter("userId", userId)
                .getSingleResult();
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.


} // class UserDao
