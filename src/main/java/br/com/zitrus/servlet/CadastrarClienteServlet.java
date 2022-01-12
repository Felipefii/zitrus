package br.com.zitrus.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zitrus.controller.ClienteController;
import br.com.zitrus.entity.Cliente;
import br.com.zitrus.entity.enums.Sexo;

@WebServlet("/cadastrarCliente")
public class CadastrarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ClienteController clienteController;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clienteController = new ClienteController();
		clienteController.cadastrarCliente(convertAndBuild(request));
		
		response.sendRedirect("listarClientes");
	}

	private Cliente convertAndBuild(HttpServletRequest request) throws ServletException {
		String nome = request.getParameter("nome");
		String sexo = request.getParameter("sexo");
		String nascimento = request.getParameter("nascimento");

		Date data = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			data = sdf.parse(nascimento);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		Cliente pessoa = new Cliente();
		pessoa.setNascimento(data);
		pessoa.setNome(nome);
		pessoa.setSexo(Sexo.buscarSexoPorNome(sexo));
		return pessoa;

	}	
}
