package br.com.zitrus.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import br.com.zitrus.entity.Cliente;
import br.com.zitrus.entity.Procedimento;

public class ValidaProcedimentoUtil {
	
	public static Boolean validateAutorizacao(Cliente cliente, Procedimento procedimento) {
	
		if (cliente.getSexo() == procedimento.getSexoPermito() &&
				anosIdade(cliente.getNascimento()) >= procedimento.getIdadeMinima() && 		
				procedimento.getIsPermitido()) {
			return Boolean.TRUE;
		}
		
		return Boolean.FALSE;
	}
	
	public static int anosIdade(Date nascimento) {
		LocalDateTime date = convertToLocalDateTimeViaInstant(nascimento);		
		return (int) date.until(LocalDateTime.now(), ChronoUnit.YEARS);
	}
	
	public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDateTime();
	}
}
