package com.souza.gestaocliente.servlet;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.souza.gestaocliente.model.Cliente;
import com.souza.gestaocliente.model.StatusCliente;
import com.souza.gestaocliente.model.TipoCliente;
import com.souza.gestaocliente.repository.Clientes;
import com.souza.gestaocliente.util.JPAUtil;

/**
 * Servlet implementation class EditarClienteServlet
 */
public class EditarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Cliente c = null;
		if(id != null){
			EntityManager manager = JPAUtil.getEntityManager();
			Clientes clientes = new Clientes(manager);
			c = clientes.buscaPorId(new Long(id.trim()));
			request.setAttribute("cliente", c);
			manager.close();
		}
		request.setAttribute("tipoCliente", TipoCliente.values());
		request.setAttribute("statusCliente", StatusCliente.values());
		
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

}
