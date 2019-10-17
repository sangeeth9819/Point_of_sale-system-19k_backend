package com.comtech.POS.system.builder;

import com.comtech.POS.system.dto.CustomerDTO;
import com.comtech.POS.system.dto.ItemDTO;
import com.comtech.POS.system.dto.OrderDTO;
import com.comtech.POS.system.dto.OrderDetailDTO;
import com.comtech.POS.system.entity.Customer;
import com.comtech.POS.system.entity.Item;
import com.comtech.POS.system.entity.OrderDetails;
import com.comtech.POS.system.entity.Orders;
import com.comtech.POS.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class EntityBuilder {
    @Autowired
    CustomerRepository customerRepository;

    private MyFormatter myFormatter;
    public Customer buildCustomerEntity(Customer customer, CustomerDTO customerDTO){
        if(customerDTO==null){
            return null;
        }
        customer.setCid(customerDTO.getCid());
        customer.setCust_Name(customerDTO.getCust_Name());
        customer.setAddress(customerDTO.getAddress());
        customer.setTel(customerDTO.getTel());
        customer.setIsEnable(1);
        return customer;
    }

    public Item buildItemEntity(Item item, ItemDTO itemDTO){
        if(itemDTO==null){
            return null;
        }
        item.setCode(itemDTO.getCode());
        item.setItemName(itemDTO.getItemName());
        item.setQty(itemDTO.getQty());
        item.setUnitPrice(itemDTO.getUnitPrice());
        item.setIsEnable(1);
        return item;
    }

    public Orders buildOrderEntity(Orders orders, OrderDTO orderDTO){
//        System.out.println("test 0" + orderDTO.getDate());
//        try{
//            if(orderDTO==null){
//                System.out.println("null");
//                return null;
//            }
//            System.out.println("test 1");
//            orders.setId(orderDTO.getId());
//            orders.setDate(myFormatter.getDateFromStr(orderDTO.getDate()));
//            System.out.println("test 2");
//            Customer customer=customerRepository.getOne(orderDTO.getCustomerId());
//            orders.setCustomer(customer);
//            System.out.println("test 3");
//            orders.setIsEnable(orderDTO.getIsEnable());
//            return orders;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
        return null;
    }

    public OrderDetails buildOrderDetail(OrderDetails orderDetails, OrderDetailDTO orderDetailDTO){
//        if(orderDetailDTO==null){
//            return null;
//        }
//        List<Item> itemList=new ArrayList<>();
//        for (ItemDTO dto: orderDetailDTO.getItems()){
//            itemList.add(buildItemEntity(new Item(), dto));
//        }
//        orderDetails.setId(orderDetailDTO.getId());
//        orderDetails.setIsEnable(1);
//        orderDetails.setItems(itemList);
//        orderDetails.setOrder(buildOrderEntity(new Orders(),orderDetailDTO.getOrderDTO()));
//        return orderDetails;
        return null;
    }
}
