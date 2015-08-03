package br.com.haz.impostos;

import br.com.haz.entidades.Item;
import br.com.haz.entidades.Orcamento;
import br.com.haz.templates.TemplateDeImposto;

public class ISS extends TemplateDeImposto {

	@Override
	public double calcularTaxacaoMinima(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}

	@Override
	public double calcularTaxacaoMaxima(Orcamento orcamento) {
		return orcamento.getValor() * 0.10;
	}

	@Override
	public boolean isTaxacaoMaxima(Orcamento orcamento) {
		return orcamento.getValor() > 500 && temItemMaiorQueCemReais(orcamento);
	}

	private boolean temItemMaiorQueCemReais(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if(item.getValor() > 100) {
				return true;
			}
		}
		return false;
	}

}
