package ifrn.nc.util;

public class ConcretoVetor implements Vetor{
	
	private Object[] conteudo;
	private int index;
	
	public ConcretoVetor(int tamanho) {
		conteudo = new Object[tamanho];
		index = 0;
	}
	@Override
	public void inserir(Object obj) {
		if(estaCheio()) {
			throw new VetorCheioExceprion("Vetor cheio");
		}
		conteudo[index++] = obj;
	}
	
	@Override
	public void inserir(Object obj,int index) {
		range(index);
		if(estaCheio()) {
			throw new VetorCheioExceprion("Vetor cheio");
		}
		if(this.index == index) {
			conteudo[index] = obj;
		}else if(this.index < index) {
			conteudo[this.index++] = obj;
		}else {
			reorganizar(index, obj);
		}
	}
	
	private void range(int index) {
		if(index < 0 || index > conteudo.length-1) {
			throw new IndexForaDoRangeExeprion();
		}
	}
	@Override
	public int buscar(Object obj) {
		System.out.println(this);
		boolean encontrou = false;
		int index = -1;
		for(int i = 0; i < this.index; i++) {
			if(obj.equals(conteudo[i])) {
				index = i;
				encontrou = true;
				break;
			}
		}
		if(!encontrou) throw new ElementoNaoEncontradoException();
		return index;
	}
	@Override
	public Object buscar(int index) {
		range(index);
		return conteudo[index];
	}
	
	public boolean estaCheio() {
		if(conteudo.length == index) return true;
		return false;
	}
	@Override
	public void remover(Object obj) {
		for(int i = buscar(obj); i<index-1;i++) {
			conteudo[i] = conteudo[i+1];
		}
		conteudo[--index]=null;
		
	}
	@Override
	public void remover(int index) {
		range(index);
		for(int i = index; i<this.index-1;i++) {
			conteudo[i] = conteudo[i+1];
		}
		conteudo[--this.index]=null;
		
	}
	
	private void reorganizar(int index,Object obj) {
		for(int i = index;i <= this.index; i++) {
			conteudo[i+1]=conteudo[i];
		}
		conteudo[index] = obj;
		this.index++;
	}
	@Override
	public String toString() {
		String str = "[";
		for(Object obj:conteudo) {
			str+=obj+",";
		}
		str = str.substring(0,str.length()-1);
		return str+"]";
	}

}
