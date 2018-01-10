package com.souza.gestaocliente.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.souza.gestaocliente.model.Cliente;

public class Clientes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	public Clientes(EntityManager manager){
		this.manager = manager;
	}
	
	public void inserirCliente(Cliente cliente){
		manager.persist(cliente);
	}
	
	public Cliente buscaPorId(Long id){
		return manager.find(Cliente.class, id);
	}
	
	public List<Cliente> todos(){
		TypedQuery<Cliente> query = manager.createQuery("from Cliente", Cliente.class);
		return query.getResultList();
	}
	
	public List<Cliente> buscaPorNome(String nome){
		TypedQuery<Cliente> query = manager.createQuery("from Cliente c where c.nome like :nome", Cliente.class);
		query.setParameter("nome", "%"+nome+"%");
		return query.getResultList();
	}
	
	public void alterarCliente(Cliente cliente){
		manager.merge(cliente);
	}
	
	public boolean removerCliente(Cliente cliente){
		manager.remove(cliente);
		return manager.contains(cliente);
	}
}
