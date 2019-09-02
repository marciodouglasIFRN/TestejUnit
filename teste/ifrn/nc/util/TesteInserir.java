package ifrn.nc.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteInserir {
	int tamanho = 5;
	Vetor testador = new ConcretoVetor(tamanho);
	
	@Test
	void inserirElemento_ElementoInserido() {
		testador.inserir(4);
		assertEquals(0, testador.buscar((Object)4));
	}
	
	@Test
	void inserirElementoPorIndex_ElementoInserido() {
		testador.inserir(4);
		testador.inserir(6,tamanho-1);
		assertEquals(1, testador.buscar((Object)6));
	}
	
	@Test
	void inserirElementoVetorCheio_Excecao() {
		for(int i = 0; i<tamanho;i++) {
			testador.inserir(i+2);
		}
		assertThrows(VetorCheioExceprion.class, ()->testador.inserir(1));
	}
	@Test
	void inserirElementoPorIndexVetorCheio_Excecao() {
		for(int i = 0; i<tamanho;i++) {
			testador.inserir(i+2);
		}
		assertThrows(VetorCheioExceprion.class, ()->testador.inserir(1,tamanho-1));
	}
	@Test
	void inserirForaDoRager_Excecao() {
		assertThrows(IndexForaDoRangeExeprion.class, ()->testador.inserir(4,-4));
	}

}
