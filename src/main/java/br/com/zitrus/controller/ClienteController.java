package br.com.zitrus.controller;

import java.util.List;

import br.com.zitrus.dao.ClienteDao;
import br.com.zitrus.entity.Cliente;
import br.com.zitrus.util.JPAUtil;

public class ClienteController {
	
	private ClienteDao clienteDao;
	
	public ClienteController() {
		this.clienteDao = new ClienteDao(JPAUtil.getEntityManager());
	}
	
	public void cadastrarCliente(Cliente cliente) {
		clienteDao.cadastrarCliente(cliente);
	}
	
	public List<Cliente> buscarClientes(){
		return this.clienteDao.buscarClientes();
	}

	public Cliente buscarClientePorId(Integer id) {
		return this.clienteDao.buscarClientePorId(id);
		
	}

	public List<Cliente> buscarClientesPorParametro(String param) {		
		return this.clienteDao.buscarClientesPorParametro(param);
	}
	

}
