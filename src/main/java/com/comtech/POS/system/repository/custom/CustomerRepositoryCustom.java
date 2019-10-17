package com.comtech.POS.system.repository.custom;

import com.comtech.POS.system.entity.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    List<Customer> search(String searchText , Integer count , Integer page);
}
