package br.com.zitrus.controller.impl;

import br.com.zitrus.service.ClienteService;
import br.com.zitrus.controller.Controller;
import br.com.zitrus.entity.Cliente;
import br.com.zitrus.entity.enums.Sexo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastrarClienteController implements Controller {

    ClienteService clienteService;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        clienteService = new ClienteService();
        try {
            clienteService.cadastrarCliente(convertAndBuild(request));
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "redirect:listarClientes";

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
