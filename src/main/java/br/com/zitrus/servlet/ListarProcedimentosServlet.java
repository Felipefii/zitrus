package br.com.zitrus.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zitrus.controller.ProcedimentoController;
import br.com.zitrus.entity.Procedimento;
import br.com.zitrus.entity.dto.ProcedimentoDto;

@WebServlet("/listarProcedimentos")
public class ListarProcedimentosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProcedimentoController procedimentoController;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procedimentoController = new ProcedimentoController();
		List<ProcedimentoDto> procedimentos = null;
		List<Procedimento> procedimentosList = procedimentoController.buscarProcedimentos();		
		
		if (!procedimentosList.isEmpty()) {
			procedimentos = ProcedimentoDto.criarListaProcedimentosDto(procedimentosList);
		}
		
		
		request.setAttribute("procedimentos", procedimentos);
		RequestDispatcher rd = request.getRequestDispatcher("/listaProcedimentos.jsp");
		rd.forward(request, response);
	}

}
