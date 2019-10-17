package com.comtech.POS.system.repository;

import com.comtech.POS.system.entity.Customer;
import com.comtech.POS.system.repository.custom.CustomerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer ,Long>, CustomerRepositoryCustom {
}
