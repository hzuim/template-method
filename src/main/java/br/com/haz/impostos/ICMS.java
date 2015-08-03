package br.com.haz.impostos;

import br.com.haz.entidades.Orcamento;
import br.com.haz.templates.TemplateDeImposto;

public class ICMS extends TemplateDeImposto {

	@Override
	public double calcularTaxacaoMinima(Orcamento orcamento) {
		return orcamento.getValor() * 0.05;
	}

	@Override
	public double calcularTaxacaoMaxima(Orcamento orcamento) {
		return orcamento.getValor() * 0.07;
	}

	@Override
	public boolean isTaxacaoMaxima(Orcamento orcamento) {
		return orcamento.getValor() > 500;
	}

}
