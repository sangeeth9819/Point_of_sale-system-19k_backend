package com.comtech.POS.system.rest;

import com.comtech.POS.system.dto.ItemDTO;
import com.comtech.POS.system.dto.commen.ResponseDTO;
import com.comtech.POS.system.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/comtech/test/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @PostMapping
    public ResponseDTO addItem(@RequestBody ItemDTO itemDTO){
        Long id=null;
        String message=null;
        int status= 0;

        try {
            id=itemService.add(itemDTO);
            message="Item ADD";
            status= 200;

        }catch (NullPointerException e){
            message="Item Faild To ADD";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDTO(id , status ,message);
    }
    @PutMapping
    public ResponseDTO updateItem(@RequestBody ItemDTO itemDTO){
        Long id=null;
        String message =null;
        int status=0;

        try {
            id=itemService.update(itemDTO);
            message="Item Updated";
            status=200;
        }catch (NullPointerException e){
            message="Item Faild to Update";
            status=400;
            e.printStackTrace();
        }
        return new ResponseDTO(id ,status ,message);
    }
    @GetMapping
    public List<ItemDTO>searchItem(
            @RequestParam(value = "text", required = true)String text,
            @RequestParam(value = "count" , required = true)Integer count,
            @RequestParam(value = "page" , required = true)Integer page
    ){
        return itemService.searchLike(text,count,page);
    }
    @DeleteMapping("/{code}")
    public Long deleteItem(@PathVariable("code") Long code){
        return itemService.delete(code);
    }
}
