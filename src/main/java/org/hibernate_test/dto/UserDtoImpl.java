package org.hibernate_test.dto;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate_test.data.HibernateUtil;
import org.hibernate_test.data.entities.User;

import java.util.Date;
import java.util.List;

import static org.hibernate_test.data.utils.Utils.getRandomApdeiter;
import static org.hibernate_test.data.utils.Utils.getRandomName;

public class UserDtoImpl implements UserDto {

    @Override
    public User addUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            return user;
        }
    }

    @Override
    public List<User> getAllUsers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<User> query = session.createQuery("from User ", User.class);
            return query.list();
            // or return session.createQuery("from User ", User.class).list();
        }
    }

    @Override
    public void printUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Override
    public void createSomeUsers(int count) {
        for (int i = 0; i < count; i++) {
            addUser(new User(getRandomName(), getRandomName(), new Date(1L), new Date(),
                    getRandomApdeiter(), new Date(), getRandomApdeiter()));
        }
    }

    @Override
    public User getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(User.class, id);
        }
    }


}
