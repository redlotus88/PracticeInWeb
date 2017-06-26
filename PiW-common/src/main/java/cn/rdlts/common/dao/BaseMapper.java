package cn.rdlts.common.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseMapper <T, PK extends Serializable> {
	
	T getById(PK pk);
	
	List<T> findAll();
	
	Integer save(T entity);
	
	int delete(T entity);
	
	int update(T entity);
}
