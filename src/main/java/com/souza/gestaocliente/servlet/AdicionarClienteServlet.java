package com.souza.gestaocliente.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souza.gestaocliente.model.Cliente;
import com.souza.gestaocliente.model.StatusCliente;
import com.souza.gestaocliente.model.TipoCliente;
import com.souza.gestaocliente.repository.Clientes;
import com.souza.gestaocliente.util.JPAUtil;

public class AdicionarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		String nome = request.getParameter("nome");
		String tipo = request.getParameter("tipo");
		String status = request.getParameter("status");
		status = status != null ? status : "ATIVADO";

		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Clientes clientes = new Clientes(manager);
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setTipoCliente(TipoCliente.valueOf(tipo));
		cliente.setStatus(StatusCliente.valueOf(status));
		
		if(id != null && (!id.trim().equals(""))){
			System.out.println("print id: " + id);
			Cliente aux = clientes.buscaPorId(new Long(id.trim()));
			aux = cliente;
			aux.setId(new Long(id));
			clientes.alterarCliente(aux);
		}else{
			clientes.inserirCliente(cliente);
		}
			
		transaction.commit();
		manager.close();
		response.sendRedirect("/crud-asbpm/listar");
	}

}
