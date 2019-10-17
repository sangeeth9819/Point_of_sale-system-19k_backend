package com.comtech.POS.system.service.impl;


import com.comtech.POS.system.builder.DTOBuider;
import com.comtech.POS.system.builder.EntityBuilder;
import com.comtech.POS.system.dto.CustomerDTO;
import com.comtech.POS.system.entity.Customer;
import com.comtech.POS.system.repository.CustomerRepository;
import com.comtech.POS.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
    public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EntityBuilder entityBuilder;
    @Autowired
    DTOBuider dtoBuider;


    @Override
    public Long add(CustomerDTO customerDTO) {
        Customer saved=customerRepository.save(entityBuilder.buildCustomerEntity(new Customer(), customerDTO));
        return null != saved ? saved.getCid(): null;
    }

    @Override
    public Long update(CustomerDTO customerDTO) {
        Customer saved= customerRepository.save(entityBuilder.buildCustomerEntity(new Customer(), customerDTO));
        return null != saved ? saved.getCid(): null;
    }

    @Override
    public List<CustomerDTO> searchLike(String searchText, Integer count, Integer page) {
        List<CustomerDTO> list = new ArrayList<>();

        for (Customer entity : customerRepository.search(searchText, count, page)) {
            list.add(dtoBuider.buildCustomerDTO(entity));
        }

        return list;
    }

    @Override
    public CustomerDTO get(Long cid) {
        return dtoBuider.buildCustomerDTO(customerRepository.getOne(cid));
    }

    @Override
    public Long delete(Long cid) {
        Customer customer = customerRepository.getOne(cid);
        customer.setIsEnable(0);
        Customer saved = customerRepository.save(customer);
        return null != saved ? saved.getCid(): null;
    }
}
