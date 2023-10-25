package br.com.paulo.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.paulo.cm.excecao.ExplosaoException;

class CampoTeste {
	
	private Campo campo = new Campo(3, 3);


	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Direita() {
		
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Emcima() {
		Campo vizinho = new Campo(2,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoRealDistancia1Embaixo() {
		Campo vizinho = new Campo(4,2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}
	
	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasVezes() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoNaoMarcado() {
		campo.abrirCampo();
		assertTrue(campo.isAberto());
	}
	
	@Test
	void testeAbrirCampoNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrirCampo());
	}
	
	@Test
	void testeAbrirCampoMinadoMarcado() {
		campo.minarCampo();
		campo.alternarMarcacao();
		assertFalse(campo.abrirCampo());
	}
	
	@Test
	void testeAbrirCampoMinadoNaoMarcado() {
		campo.minarCampo();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrirCampo();
		});
	}
	
	@Test
	void testeCampoMinado() {
		campo.isMinado();
		assertFalse(campo.isMinado());
	}
	
	@Test
	void testeAbrirCampoComVizinhos() {
		
		Campo vizinhoDoVizinho1 = new Campo(1, 1);
		
		Campo vizinho1 = new Campo(2, 2);
		vizinho1.adicionarVizinho(vizinhoDoVizinho1);
		
		campo.adicionarVizinho(vizinho1);
		
		campo.abrirCampo();
		
		assertTrue(vizinho1.isAberto() && vizinhoDoVizinho1.isAberto());
		
		
	}

}
