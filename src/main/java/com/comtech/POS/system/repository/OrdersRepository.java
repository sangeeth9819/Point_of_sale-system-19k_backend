package com.comtech.POS.system.repository;

import com.comtech.POS.system.entity.Orders;
import com.comtech.POS.system.repository.custom.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Long>, OrderRepositoryCustom {
}
