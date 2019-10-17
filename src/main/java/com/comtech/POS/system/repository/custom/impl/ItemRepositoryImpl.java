package com.comtech.POS.system.repository.custom.impl;

import com.comtech.POS.system.entity.Item;
import com.comtech.POS.system.repository.custom.ItemRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class ItemRepositoryImpl implements ItemRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Item> search(String searchText, Integer count, Integer page) {
        Query q =  entityManager.createNativeQuery("select c.* from item c where (c.item_name like :searchText )and c.is_enable=1 ", Item.class);
        q.setParameter("searchText" ,"%" + searchText + "%");
        q.setFirstResult(page* count);
        q.setMaxResults(count);
        return q.getResultList();
    }
}
