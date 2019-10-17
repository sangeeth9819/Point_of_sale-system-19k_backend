package com.comtech.POS.system.repository.custom;

import com.comtech.POS.system.entity.Item;

import java.util.List;

public interface ItemRepositoryCustom {
    List<Item>search(String searchText ,Integer count ,Integer page);
}
