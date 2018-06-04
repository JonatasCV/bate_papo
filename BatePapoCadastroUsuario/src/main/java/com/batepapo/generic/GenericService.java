package com.batepapo.generic;

import java.util.List;

public interface GenericService<T extends Object> {

	T save(T entity);
    
    T update(T entity);
  
    Boolean delete(Long id);
  
    List<T> findAll();
}
