package br.com.zitrus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.zitrus.controller.AutorizacaoProcedimentoController;
import br.com.zitrus.entity.AutorizacaoProcedimento;

@WebServlet("/listarAutorizacaoProced")
public class ListarAutorizacaoProcedimentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AutorizacaoProcedimentoController autorizacaoProcedimentoController;

	public ListarAutorizacaoProcedimentosServlet() {
		this.autorizacaoProcedimentoController = new AutorizacaoProcedimentoController();
	}



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AutorizacaoProcedimento> autorizacaoProcedimentos = autorizacaoProcedimentoController.listarAutorizacaoProcedimentos();
		String json = new Gson().toJson(autorizacaoProcedimentos);
		System.out.println(json);		
		request.setAttribute("autorizacaoProcedimentos", autorizacaoProcedimentos);
		request.getRequestDispatcher("/listaAutorizacaoProcedimento.jsp").forward(request, response);
	}

}
