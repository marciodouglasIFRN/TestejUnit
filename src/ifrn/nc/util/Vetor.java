package ifrn.nc.util;

public class Vetor {
	
	private Object[] conteudo;
	private int index;
	
	public Vetor(int tamanho) {
		conteudo = new Object[tamanho];
		index = 0;
	}
	
	public void inserir(Object obj) {
		if(estaCheio()) {
			throw new VetorCheioExceprion("Vetor cheio");
		}
		conteudo[index++] = obj;
	}
	
	public void inserir(Object obj,int index) {
		if(index < 0 || index > conteudo.length-1) {
			throw new IndexForaDoRangeExeprion();
		}
		if(this.index == index) {
			conteudo[index] = obj;
		}else if(this.index < index) {
			conteudo[this.index++] = obj;
		}else {
			reorganizar(index, obj);
		}
	}
	
	public int buscar(Object obj) {
		System.out.println(this);
		for(int i = 0; i < index; i++) {
			if(obj.equals(conteudo[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public Object buscar(int index) {
		return conteudo[index];
	}
	
	public boolean estaCheio() {
		if(conteudo.length == index) return true;
		return false;
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
