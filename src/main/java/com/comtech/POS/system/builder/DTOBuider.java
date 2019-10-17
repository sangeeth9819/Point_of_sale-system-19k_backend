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

@Component
public class DTOBuider {


    private MyFormatter myFormatter;
    public CustomerDTO buildCustomerDTO(Customer customer){
        if(customer==null){
            return null;
        }
        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setCid(customer.getCid());
        customerDTO.setCust_Name(customer.getCust_Name());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setTel(customer.getTel());
        customerDTO.setIsEnable(customer.getIsEnable());

        return customerDTO;
    }

    public ItemDTO buildItemDTO(Item item){
        if(item==null){
            return null;
        }
        ItemDTO itemDTO=new ItemDTO();
        itemDTO.setCode(item.getCode());
        itemDTO.setItemName(item.getItemName());
        itemDTO.setQty(item.getQty());
        itemDTO.setUnitPrice(item.getUnitPrice());
        itemDTO.setIsEnable(item.getIsEnable());

        return itemDTO;
    }

    public OrderDTO buildOrderDTO(Orders orders){
        if(orders==null){
            return null;
        }
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setId(orders.getId());
        orderDTO.setDate(orders.getDate());
       // Customer customer=customerRepository.getOne()
        orderDTO.setCustomerDTO(buildCustomerDTO(orders.getCustomer()));
        orderDTO.setCustomerId(orderDTO.getCustomerDTO().getCid());
        orderDTO.setIsEnable(orders.getIsEnable());

        return orderDTO;
    }

    public OrderDetailDTO buildOrderDetailDTO(OrderDetails orderDetail){
//        if(orderDetail==null){
//            return null;
//        }
//        OrderDetailDTO orderDetailDTO= new OrderDetailDTO();
//        orderDetailDTO.setId(orderDetail.getId());
//        orderDetailDTO.setItems(buildItemDTO(orderDetail.getItems()));
//        orderDetailDTO.setOrderDTO(orderDetail.getOrder());
//        orderDetailDTO.setIsEnable(orderDetail.getIsEnable());
//        return orderDetailDTO;
        return null;
    }
}
