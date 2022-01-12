package br.com.zitrus.controller;

import java.util.List;

import br.com.zitrus.dao.AutorizacaoDao;
import br.com.zitrus.entity.AutorizacaoProcedimento;
import br.com.zitrus.util.JPAUtil;

public class AutorizacaoProcedimentoController {
	
	AutorizacaoDao autorizacaoDao;

	public AutorizacaoProcedimentoController() {
		this.autorizacaoDao = new AutorizacaoDao(JPAUtil.getEntityManager());
	}
	
	public void cadastrarAutorizacaoProcedimento(AutorizacaoProcedimento autorizacaoProcedimento) {
		autorizacaoDao.cadastrarAutorizacaoProcedimento(autorizacaoProcedimento);
	}

	public List<AutorizacaoProcedimento> listarAutorizacaoProcedimentos() {
		return autorizacaoDao.listarAutorizacaoProcedimentos();
	}
}
