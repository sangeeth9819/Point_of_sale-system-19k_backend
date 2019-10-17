package com.comtech.POS.system.repository;

import com.comtech.POS.system.entity.Item;
import com.comtech.POS.system.repository.custom.ItemRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item ,Long > ,ItemRepositoryCustom{
}
