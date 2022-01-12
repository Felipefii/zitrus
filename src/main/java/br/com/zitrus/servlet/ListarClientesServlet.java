package br.com.zitrus.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zitrus.entity.Cliente;

@WebServlet("/listarClientes")
public class ListarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("zitrus");
		EntityManager em = factory.createEntityManager();
		
		Query query = em.createQuery("select c from Cliente c");
		List<Cliente> clientes = (List<Cliente>) query.getResultList();
		
		request.setAttribute("clientes", clientes);
		RequestDispatcher rd = request.getRequestDispatcher("/listarCliente.jsp");
		rd.forward(request, response);
				
	}

}
