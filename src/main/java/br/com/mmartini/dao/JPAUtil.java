package br.com.mmartini.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("appPU");
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static void main(String[] args) {
		JPAUtil.getEntityManager();
	}

}
