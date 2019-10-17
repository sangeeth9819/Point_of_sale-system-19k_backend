package com.comtech.POS.system.service.impl;

import com.comtech.POS.system.dto.OrderDTO;
import com.comtech.POS.system.repository.OrdersRepository;
import com.comtech.POS.system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdersRepository ordersRepository;


    @Override
    public Long add(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Long update(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public List<OrderDTO> searchLike(String searchText, Integer count, Integer page) {
        return null;
    }

    @Override
    public OrderDTO get(Long cid) {
        return null;
    }

    @Override
    public Long delete(Long cid) {
        return null;
    }
}
