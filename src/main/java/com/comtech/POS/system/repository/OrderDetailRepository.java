package com.comtech.POS.system.repository;

import com.comtech.POS.system.entity.OrderDetails;
import com.comtech.POS.system.repository.custom.OrderDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails,Long>, OrderDetailRepositoryCustom {
}
