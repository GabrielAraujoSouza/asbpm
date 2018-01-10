package com.souza.gestaocliente.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory;
	
	static{
		factory = Persistence.createEntityManagerFactory("crud-asbpm");
	}
	
	public static EntityManager getEntityManager(){
		return factory.createEntityManager();
	}
	
}
