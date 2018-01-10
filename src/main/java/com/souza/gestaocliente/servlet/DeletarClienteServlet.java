package com.souza.gestaocliente.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souza.gestaocliente.repository.Clientes;
import com.souza.gestaocliente.util.JPAUtil;

/**
 * Servlet implementation class DeletarClienteServlet
 */
public class DeletarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Clientes clientes = new Clientes(manager);
		
		if(clientes.removerCliente(clientes.buscaPorId(new Long(id)))){
			System.out.println("Cliente removido!");
		}
		transaction.commit();
		manager.close();
		response.sendRedirect("/crud-asbpm/listar");
	}

}
