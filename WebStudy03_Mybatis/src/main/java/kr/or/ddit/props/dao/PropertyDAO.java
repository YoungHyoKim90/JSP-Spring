package kr.or.ddit.props.dao;

import java.util.List;

import kr.or.ddit.vo.PropertyVO;

/**
 * Property 관리(CRUD)를 위한 Persistence Layer 
 *
 */
public interface PropertyDAO {
	public int insertProperty(PropertyVO prop);
	public PropertyVO selectProperty(String propertyName);
	public List<PropertyVO> selectProperties();
	public int updateProperty(PropertyVO prop);
	public int deleteProperty(String propertyName);
}

/*
*package br.edu.ufcg.embedded.util;

import java.util.List;

public interface Crud<T> {
    T create(T t);

    List<T> getAll();

    T getById(Long id);

    T update(T t);

    boolean removeById(Long id);

    boolean removeAll();
}
*/