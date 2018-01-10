package com.souza.gestaocliente.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souza.gestaocliente.repository.Clientes;
import com.souza.gestaocliente.util.JPAUtil;

/**
 * Servlet implementation class ListarClienteServlet
 */
public class ListarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeProcurado = request.getParameter("pesquisar");
		
		EntityManager manager = JPAUtil.getEntityManager();
		Clientes clientes = new Clientes(manager);
		if(nomeProcurado!=null && !nomeProcurado.trim().equals("")){
			request.setAttribute("clientes", clientes.buscaPorNome(nomeProcurado));
		}else{
			request.setAttribute("clientes", clientes.todos());
		}
		
		manager.close();
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

}
