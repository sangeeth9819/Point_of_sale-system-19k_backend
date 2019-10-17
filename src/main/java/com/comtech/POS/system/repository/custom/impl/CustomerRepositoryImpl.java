package com.comtech.POS.system.repository.custom.impl;

import com.comtech.POS.system.entity.Customer;
import com.comtech.POS.system.repository.custom.CustomerRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


public class CustomerRepositoryImpl implements CustomerRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Customer> search(String searchText, Integer count, Integer page) {
        Query q =  entityManager.createNativeQuery("select c.* from customer c where (c.cust_Name like :searchText )and c.is_enable=1 ",Customer.class);
        q.setParameter("searchText" ,"%" + searchText + "%");
        q.setFirstResult(page* count);
        q.setMaxResults(count);

        return q.getResultList();
    }
}
