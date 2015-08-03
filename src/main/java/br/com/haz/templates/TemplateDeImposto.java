package br.com.haz.templates;

import br.com.haz.entidades.Orcamento;
import br.com.haz.interfaces.Imposto;

public abstract class TemplateDeImposto implements Imposto {

	public final double calcular(Orcamento orcamento) {
		if (isTaxacaoMaxima(orcamento)) {
			return calcularTaxacaoMaxima(orcamento);
		} else {
			return calcularTaxacaoMinima(orcamento);
		}
	}

	protected abstract double calcularTaxacaoMinima(Orcamento orcamento);

	protected abstract double calcularTaxacaoMaxima(Orcamento orcamento);

	protected abstract boolean isTaxacaoMaxima(Orcamento orcamento);

}
