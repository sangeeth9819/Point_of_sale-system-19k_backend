package com.comtech.POS.system.rest;

import com.comtech.POS.system.dto.OrderDetailDTO;
import com.comtech.POS.system.dto.commen.ResponseDTO;
import com.comtech.POS.system.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/comtech/test/order")
public class OrderDetailsController {
    @Autowired
    OrderDetailService orderDetailService;
    @PostMapping
    public ResponseDTO addOrder(@RequestBody OrderDetailDTO orderDetailDTO){
        Long id=null;
        String message=null;
        int status= 0;

        try {
            id=orderDetailService.add(orderDetailDTO);
            message="order ADD";
            status= 200;

        }catch (NullPointerException e){
            message="Order Faild To ADD";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDTO(id , status ,message);
    }
}
