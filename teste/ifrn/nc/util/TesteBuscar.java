package ifrn.nc.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteBuscar {
	int tamanho = 5;
	Vetor testador = new Vetor(tamanho);
	@Test
	void buscarElemento_Index() {
		for(int i = 0 ; i < tamanho ; i++ ) {
			testador.inserir(i*3);
		}
		assertEquals(1, testador.buscar((Object)3));
	}
	@Test
	void buscarElementoPorIndex_Elemento() {
		for(int i = 0 ; i < tamanho ; i++ ) {
			testador.inserir(i*3);
		}
		assertEquals(3, testador.buscar(1));
	}
	@Test
	void buscarElementoPorIndexForaDoRange_Excecao() {
		assertThrows(IndexForaDoRangeExeprion.class, ()->testador.buscar(-1));
	}
	@Test
	void buscarElementoInexistente_Excecao() {
		assertThrows(ElementoNaoEncontradoException.class, ()->testador.buscar((Object)111));
	}

}
