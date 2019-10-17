package com.comtech.POS.system.service.impl;

import com.comtech.POS.system.builder.DTOBuider;
import com.comtech.POS.system.builder.EntityBuilder;
import com.comtech.POS.system.builder.MyFormatter;
import com.comtech.POS.system.dto.OrderDetailDTO;
import com.comtech.POS.system.entity.Item;
import com.comtech.POS.system.entity.OrderDetails;
import com.comtech.POS.system.entity.Orders;
import com.comtech.POS.system.repository.CustomerRepository;
import com.comtech.POS.system.repository.ItemRepository;
import com.comtech.POS.system.repository.OrderDetailRepository;
import com.comtech.POS.system.repository.OrdersRepository;
import com.comtech.POS.system.service.OrderDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    OrdersRepository ordersRepository;

    private DTOBuider dtoBuider;
    private EntityBuilder entityBuilder;
    private MyFormatter myFormatter;
    @Autowired
    CustomerRepository customerRepository;


    @Override
    public Long add(OrderDetailDTO orderDetailDTO) {

        OrderDetails orderDetailsSave = new OrderDetails();
        List<Item> itemList = new ArrayList<>();
        Orders orders = new Orders();
        try {
            orders.setId(orderDetailDTO.getOrderDTO().getId());
            orders.setDate(orderDetailDTO.getOrderDTO().getDate());
            orders.setCustomer(customerRepository.getOne(orderDetailDTO.getOrderDTO().getCustomerId()));
            orders.setIsEnable(1);
            Orders orderSave = ordersRepository.save(orders);

            for (int i = 0; i < orderDetailDTO.getItemsList().size(); i++) {
                Item item = itemRepository.getOne(orderDetailDTO.getItemsList().get(i));
                itemList.add(item);
                item.setQty(item.getQty() - orderDetailDTO.getQty());
                itemRepository.save(item);
            }

            orderDetailsSave.setId(orderDetailDTO.getId());
            orderDetailsSave.setIsEnable(1);
            orderDetailsSave.setItems(itemList);
            orderDetailsSave.setQty(orderDetailDTO.getQty());
            orderDetailsSave.setOrder(orderSave);

            orderDetailRepository.save(orderDetailsSave);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderDetailsSave.getId();
    }

    @Override
    public Long update(OrderDetailDTO orderDetailDTO) {
        return null;
    }

    @Override
    public List<OrderDetailDTO> searchLike(String searchText, Integer count, Integer page) {
        return null;
    }

    @Override
    public OrderDetailDTO get(Long cid) {
        return null;
    }

    @Override
    public Long delete(Long cid) {
        return null;
    }
}
