package io.devzonecodez.mt.repo.impl;

import io.devzonecodez.mt.model.User;
import io.devzonecodez.mt.repo.UserRepoCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepoCustomImpl implements UserRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
        Query sql = entityManager.createNamedQuery("User.findAll");
        List<User> users = sql.getResultList();
        return users;
    }
}
