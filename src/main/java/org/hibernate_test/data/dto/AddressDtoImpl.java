package org.hibernate_test.data.dto;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate_test.data.entities.Address;
import org.hibernate_test.data.entities.User;
import org.hibernate_test.data.storage.HibernateUtil;

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
}
