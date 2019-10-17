package com.comtech.POS.system.rest;

import com.comtech.POS.system.dto.CustomerDTO;
import com.comtech.POS.system.dto.commen.ResponseDTO;
import com.comtech.POS.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/comtech/test/customer")
public class CustomerController{
    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseDTO addCustomer(@RequestBody CustomerDTO customerDTO){
        Long id=null;
        String message= null;
        int status = 0;

        try {
            id=customerService.add(customerDTO);
            message="Customer Add";
            status=200;
        }catch (NullPointerException e){
            message="Customer Faild";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDTO(id ,status ,message);
    }

    @PutMapping
    public ResponseDTO updateCustomer(@RequestBody CustomerDTO dto){
        Long id=null;
        String message=null;
        int status=0;

        try {
            id=customerService.add(dto);
            message="Customer Update";
            status=0;
        }catch (NullPointerException e){
            message="Customer Not Update";
            status=0;
            e.printStackTrace();
        }
        return new ResponseDTO(id,status,message);
    }

    @GetMapping
    public List<CustomerDTO> searchCustomer(
            @RequestParam(value = "text" , required = true)String text,
            @RequestParam(value = "count" , required = true)Integer count,
            @RequestParam(value = "page" , required = true) Integer page) {
                return customerService.searchLike(text , count ,page);
    }

    @DeleteMapping("/{cid}")
    public Long deleteCustomer(@PathVariable("cid") Long cid){
        return customerService.delete(cid);
    }

}
