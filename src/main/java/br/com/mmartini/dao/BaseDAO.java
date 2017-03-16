package br.com.mmartini.dao;

import java.util.List;

public interface BaseDAO<T> {

	public void adiciona(T t);
	public void atualiza(T t);
	public void remove(int id);
	public List<T> getList();
	public T getById(int id);
	
}
