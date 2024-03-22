package org.hibernate_test.data.dto;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate_test.data.entities.Address;
import org.hibernate_test.data.entities.User;
import org.hibernate_test.data.storage.HibernateUtil;

import java.util.List;

public class AddressDtoImpl implements AddressDto{
    @Override
    public Address addAddress(Address address) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(address);
            transaction.commit();
            return address;
        }
    }


    @Override
    public Address getById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Address.class, id);
        }
    }

    @Override
    public List<Address> getAllAddresses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Address> query = session.createQuery("from Address ", Address.class);
            return query.list();
            // or return session.createQuery("from User ", User.class).list();
        }
    }

    @Override
    public boolean deleteAddress(Address address) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(address);
            transaction.commit();
            return true;
        }
    }

    @Override
    public Address updateAddress(Address address) { // update by Employer
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.merge(address);
            tx1.commit();
            return address;
        }
    }
}
