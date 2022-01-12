import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

import br.com.zitrus.entity.Cliente;
import br.com.zitrus.entity.Procedimento;
import br.com.zitrus.entity.enums.Sexo;
import br.com.zitrus.util.ValidaProcedimentoUtil;

class ValidaProcedimentoTest {
	
	@Test
	void shouldReturnTrueWhenIsPermitido() {
		Boolean validar = ValidaProcedimentoUtil.validateAutorização(getCliente(), getProcedimentoPermitido());
		assertEquals(validar, Boolean.TRUE);
	}
	
	@Test
	void shouldReturnFalseWhenIsNotPermitido() {
		Boolean validar = ValidaProcedimentoUtil.validateAutorização(getCliente(), getProcedimentoNaoPermitido());
		assertEquals(validar, Boolean.FALSE);
	}
	
	@Test
	void shouldReturnFalseWhenSexoNotPermitido() {
		Boolean validar = ValidaProcedimentoUtil.validateAutorização(getCliente(), getProcedimentoSexoNaoPermitido());
		assertEquals(validar, Boolean.FALSE);
	}

	public static Cliente getCliente() {
		Cliente cliente = new Cliente();
		cliente.setSexo(Sexo.MASCULINO);
		cliente.setNascimento(new Date(1641942009L));
		return cliente;
	}
	
	public static Procedimento getProcedimentoPermitido() {
		Procedimento procedimento = new Procedimento();
		procedimento.setSexoPermito(Sexo.MASCULINO);
		procedimento.setIdadeMinima(0);
		procedimento.setIsPermitido(Boolean.TRUE);
		return procedimento;
	}
	
	public static Procedimento getProcedimentoNaoPermitido() {
		Procedimento procedimento = new Procedimento();
		procedimento.setSexoPermito(Sexo.MASCULINO);
		procedimento.setIdadeMinima(0);
		procedimento.setIsPermitido(Boolean.FALSE);
		return procedimento;
	}
	
	public static Procedimento getProcedimentoSexoNaoPermitido() {
		Procedimento procedimento = new Procedimento();
		procedimento.setSexoPermito(Sexo.FEMININO);
		procedimento.setIdadeMinima(0);
		procedimento.setIsPermitido(Boolean.TRUE);
		return procedimento;
	}
}
