package br.com.zitrus.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.zitrus.controller.AutorizacaoProcedimentoController;
import br.com.zitrus.controller.ClienteController;
import br.com.zitrus.controller.ProcedimentoController;
import br.com.zitrus.entity.AutorizacaoProcedimento;
import br.com.zitrus.entity.Cliente;
import br.com.zitrus.entity.Procedimento;
import br.com.zitrus.util.Erro;
import br.com.zitrus.util.ValidaProcedimentoUtil;

@WebServlet("/autorizaProcedimento")
public class AutorizarProcedimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClienteController clienteController = new ClienteController();
		ProcedimentoController procedimentoController = new ProcedimentoController();
		AutorizacaoProcedimentoController autorizacaoProcedimentoController = new AutorizacaoProcedimentoController();

		String operacao = request.getParameter("op");

		if (operacao != null && operacao.equalsIgnoreCase("cliente")) {
			listarClientes(request, response, clienteController);
		}

		if (operacao != null && operacao.equalsIgnoreCase("selectCliente")) {
			buscarCliente(request, response, clienteController);
		}

		if (operacao != null && operacao.equalsIgnoreCase("procedimento")) {
			listarProcedimentos(request, response, procedimentoController);
		}

		if (operacao != null && operacao.equalsIgnoreCase("cadastrar")) {
			cadastrarAutorizacaoProcedimentos(request, response, autorizacaoProcedimentoController);
		}

	}

	private void cadastrarAutorizacaoProcedimentos(HttpServletRequest request, HttpServletResponse response,
			AutorizacaoProcedimentoController autorizacaoProcedimentoController) throws IOException {
		Integer idCliente = Integer.valueOf(request.getParameter("idCliente"));
		Integer idProcedimento = Integer.valueOf(request.getParameter("idProcedimento"));
		ClienteController clienteController = new ClienteController();
		ProcedimentoController procedimentoController = new ProcedimentoController();

		Cliente cliente = clienteController.buscarClientePorId(idCliente);
		Procedimento procedimento = procedimentoController.buscarProcedimentoPorId(idProcedimento);
		AutorizacaoProcedimento autorizacaoProcedimento;
		Boolean isValido = ValidaProcedimentoUtil.validateAutorização(cliente, procedimento);

		if (isValido) {
			autorizacaoProcedimento = new AutorizacaoProcedimento();
			autorizacaoProcedimento.setCliente(cliente);
			autorizacaoProcedimento.setProcedimento(procedimento);
			autorizacaoProcedimentoController.cadastrarAutorizacaoProcedimento(autorizacaoProcedimento);
			String json = new Gson().toJson(autorizacaoProcedimento);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);

		} else {
			String json = new Gson().toJson(new Erro("Não foi possível autorizar procedimento"));

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);		
		}

	}

	private void buscarCliente(HttpServletRequest request, HttpServletResponse response,
			ClienteController clienteController) throws IOException {
		String param = request.getParameter("param");
		Cliente cliente = clienteController.buscarClientePorId(Integer.valueOf(param));
		String json = new Gson().toJson(cliente);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	private void listarClientes(HttpServletRequest request, HttpServletResponse response,
			ClienteController clienteController) throws IOException {
		String param = request.getParameter("param");
		List<Cliente> clientes = clienteController.buscarClientesPorParametro(param);
		String json = new Gson().toJson(clientes);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	private void listarProcedimentos(HttpServletRequest request, HttpServletResponse response,
			ProcedimentoController procedimentoController) throws IOException {
		String param = request.getParameter("param");
		List<Procedimento> procedimentos = null;
		if (param != null) {
			procedimentos = procedimentoController.buscarProcedimentosPorParametro(Integer.valueOf(param));
		} else {
			procedimentos = procedimentoController.buscarProcedimentos();
		}

		String json = new Gson().toJson(procedimentos);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

}
