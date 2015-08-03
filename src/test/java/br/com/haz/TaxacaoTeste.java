package br.com.haz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.haz.entidades.Item;
import br.com.haz.entidades.Orcamento;
import br.com.haz.impostos.ICMS;
import br.com.haz.impostos.ISS;
import br.com.haz.templates.TemplateDeImposto;

public class TaxacaoTeste {
	TemplateDeImposto iss;
	TemplateDeImposto icms;

	@Before
	public void setUp() throws Exception {
		iss = new ISS();
		icms = new ICMS();
	}

	@Test
	public void issTaxacaoMaxima() {
		Orcamento orcamento = new Orcamento(600);
		orcamento.adicionaItem(new Item("CANETA", 50.00));
		orcamento.adicionaItem(new Item("LAPIS", 50.00));
		orcamento.adicionaItem(new Item("ESTOJO", 500.00));

		double imposto = iss.calcular(orcamento);

		Assert.assertEquals(60.00, imposto, Double.MAX_VALUE);
	}

	@Test
	public void issTaxacaoMinima() {
		Orcamento orcamento = new Orcamento(200);
		orcamento.adicionaItem(new Item("CANETA", 50.00));
		orcamento.adicionaItem(new Item("LAPIS", 150.00));

		double imposto = iss.calcular(orcamento);

		Assert.assertEquals(12.00, imposto, Double.MAX_VALUE);
	}

	@Test
	public void icmsTaxacaoMaxima() {
		Orcamento orcamento = new Orcamento(600);
		orcamento.adicionaItem(new Item("CANETA", 150.00));
		orcamento.adicionaItem(new Item("LAPIS", 150.00));
		orcamento.adicionaItem(new Item("ESTOJO", 150.00));
		orcamento.adicionaItem(new Item("BORRACHA", 150.00));

		double imposto = icms.calcular(orcamento);

		Assert.assertEquals(42.00, imposto, Double.MAX_VALUE);
	}

	@Test
	public void icmsTaxacaoMinima() {
		Orcamento orcamento = new Orcamento(200);
		orcamento.adicionaItem(new Item("CANETA", 50.00));
		orcamento.adicionaItem(new Item("LAPIS", 50.00));
		orcamento.adicionaItem(new Item("ESTOJO", 50.00));
		orcamento.adicionaItem(new Item("BORRACHA", 50.00));

		double imposto = icms.calcular(orcamento);

		Assert.assertEquals(10.00, imposto, Double.MAX_VALUE);
	}

}
