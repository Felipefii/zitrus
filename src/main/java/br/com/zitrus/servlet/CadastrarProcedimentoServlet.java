package br.com.zitrus.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.zitrus.controller.ProcedimentoController;
import br.com.zitrus.entity.Procedimento;
import br.com.zitrus.entity.enums.Sexo;

@WebServlet("/CadastraProcedimento")
public class CadastrarProcedimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProcedimentoController procedimentoController;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		procedimentoController = new ProcedimentoController();
		Procedimento procedimento = convertAndBuild(request);
		
		procedimentoController.cadastrarProcedimento(procedimento);
		response.sendRedirect("listarProcedimentos");
	}
	
	public Procedimento convertAndBuild(HttpServletRequest request) {
		String idade = request.getParameter("idadeMinima");
		String sexo = request.getParameter("sexo");
		String isPermitido = request.getParameter("permitido");
		
		Procedimento procedimento = new Procedimento();
		procedimento.setIdadeMinima(Integer.valueOf(idade));
		procedimento.setIsPermitido(isPermitido.equalsIgnoreCase("Sim"));
		procedimento.setSexoPermito(Sexo.buscarSexoPorNome(sexo));
		return procedimento;
	}	

}
