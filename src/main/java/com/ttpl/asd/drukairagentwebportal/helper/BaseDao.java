package com.ttpl.asd.drukairagentwebportal.helper;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Transactional()
public abstract class BaseDao {
    @PersistenceContext
    private EntityManager entityManager;

    protected Session getCurrentSession() {
        return entityManager.unwrap(Session.class);
    }

    protected org.hibernate.Query sqlQuery(String query, Class dtoClazz) {
        return getCurrentSession().createSQLQuery(query).setResultTransformer(new AliasToBeanResultTransformer(dtoClazz));
    }
}




























