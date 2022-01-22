package com.example.pp_spring_boot_first.dao;

import com.example.pp_spring_boot_first.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT us FROM User us", User.class).getResultList();
    }

    @Override
    public User findById(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public void update(long id, User user) {
        user.setId(id);
        em.merge(user);
    }

    @Override
    public void delete(long id) {
        em.createQuery("DELETE FROM User WHERE id=:id").setParameter("id", id).executeUpdate();
    }

}
