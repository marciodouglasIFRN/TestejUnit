package ifrn.nc.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteRemover {
	int tamanho = 5;
	Vetor testador = new Vetor(tamanho);
	@Test
	void removerElemento_ElementoRemovido() {
		for(int i = 0; i<tamanho;i++) {
			testador.inserir(i);
		}
		testador.remover((Object)2);
		assertThrows(ElementoNaoEncontradoException.class, ()->testador.buscar((Object)2));
		
	}
	@Test
	void removerElementoPorIndex_ElementoRemovido() {
		for(int i = 0; i<tamanho;i++) {
			testador.inserir(i);
		}
		testador.remover(1);
		assertThrows(ElementoNaoEncontradoException.class, ()->testador.buscar((Object)1));
		
	}
	
	@Test
	void removerElementoInexistente_Excecao() {
		for(int i = 0; i<tamanho;i++) {
			testador.inserir(i);
		}
		assertThrows(ElementoNaoEncontradoException.class, ()->testador.remover((Object)84));
		
	}
	
	@Test
	void removerElementoForaDoRange_Excecao() {
		
		assertThrows(IndexForaDoRangeExeprion.class, ()->testador.remover(84));
		
	}

}
