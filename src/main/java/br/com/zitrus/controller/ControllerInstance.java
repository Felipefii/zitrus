package br.com.zitrus.controller;

import br.com.zitrus.controller.impl.*;

public enum ControllerInstance {

    CADASTRO_AUTORIZA_PROCEDIMENTO("CadastraAutProced"){
        @Override
        public Controller getInstance() {
            return new AutorizarProcedimentoController();
        }
    },
    CADASTRO_CLIENTE("CadastraCliente") {
        @Override
        public Controller getInstance() {
            return new CadastrarClienteController();
        }
    },
    CADASTRO_PROCEDIMENTO("CadastraProcedimento") {
        @Override
        public Controller getInstance() {
            return new CadastrarProcedimentoController();
        }
    },
    LISTA_AUTORIZACAO_PROCEDIMENTO("ListaAutProced") {
        @Override
        public Controller getInstance() {
            return new ListarAutorizacaoProcedimentoController();
        }
    },
    LISTA_CLIENTE("ListaCliente") {
        @Override
        public Controller getInstance() {
            return new ListarClientesController();
        }
    },
    LISTA_PROCEDIMENTO("ListaProced") {
        @Override
        public Controller getInstance() {
            return new ListarProcedimentosController();
        }
    };

    private String acao;

    ControllerInstance(String listaAutProced) {
    }

    public String getAcao() {
        return acao;
    }

    public abstract Controller getInstance();

    public static Controller getInstanceByAction(String action) {
        for(ControllerInstance instance : ControllerInstance.values()) {
            if(instance.getAcao().equals(action)) {
                return instance.getInstance();
            }
        }
        return null;
    }
}
