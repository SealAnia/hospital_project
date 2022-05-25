package com.example.hospital.datasource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;

public class DataSource {
	
	private static DataSource instance = new DataSource();
	private static EntityManagerFactory entityManagerFactory;
	private DataSource() {
		entityManagerFactory = 
				Persistence.createEntityManagerFactory("airport");
	}
	
	public static DataSource getInstance() {
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
	
	public Session getSession() {
		return getEntityManager().unwrap(Session.class);
	}

}
