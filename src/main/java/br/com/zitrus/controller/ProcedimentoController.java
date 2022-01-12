package br.com.zitrus.controller;

import java.util.List;

import br.com.zitrus.dao.ProcedimentoDao;
import br.com.zitrus.entity.Procedimento;
import br.com.zitrus.util.JPAUtil;

public class ProcedimentoController {

	private ProcedimentoDao procedimentoDao;
	
	public ProcedimentoController() {
		this.procedimentoDao = new ProcedimentoDao(JPAUtil.getEntityManager());;
	}

	public List<Procedimento> buscarProcedimentos() {
		return procedimentoDao.buscarProcedimentos();
	}

	public void cadastrarProcedimento(Procedimento procedimento) {
		procedimentoDao.cadastrarProcedimento(procedimento);
		
	}

	public List<Procedimento> buscarProcedimentosPorParametro(Integer param) {
		return procedimentoDao.buscarProcedimentosPorParametro(param);
	}
	
	public Procedimento buscarProcedimentoPorId(Integer param) {
		return procedimentoDao.buscarProcedimentosPorId(param);
	}
}
