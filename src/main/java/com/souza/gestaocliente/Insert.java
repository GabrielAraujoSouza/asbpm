package com.souza.gestaocliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.souza.gestaocliente.model.Cliente;
import com.souza.gestaocliente.model.StatusCliente;
import com.souza.gestaocliente.model.TipoCliente;
import com.souza.gestaocliente.repository.Clientes;
import com.souza.gestaocliente.util.JPAUtil;

public class Insert {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction  = manager.getTransaction();
		transaction.begin();
		Cliente c = new Cliente();
		c.setNome("Joao");
		c.setStatus(StatusCliente.ATIVADO);
		c.setTipoCliente(TipoCliente.FISICA);
		
		Clientes c1 = new Clientes(manager);
		c1.inserirCliente(c);
		
		transaction.commit();
		c1.buscaPorNome(c.getNome());
		//manager.close();
		System.out.println(c1.buscaPorId(c.getId()).getStatus().toString()+"  aaa");

		
	}
}
