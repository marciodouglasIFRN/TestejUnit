package ifrn.nc.util;

public interface Vetor {
	
	public void inserir(Object obj);
	public void inserir(Object obj,int index);
	public int buscar(Object obj);
	public Object buscar(int index);
	public void remover(Object obj);
	public void remover(int index);

}
