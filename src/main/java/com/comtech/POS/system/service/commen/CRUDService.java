package com.comtech.POS.system.service.commen;

import java.util.List;

public interface CRUDService<T> {
    public Long add(T t);

    public Long update(T t);

    public List<T> searchLike(String searchText , Integer count , Integer page);

    public T get(Long cid);

    public Long delete(Long cid);
}
