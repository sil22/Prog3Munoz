package Practico2;

public class Arbol {
	NodoArbol root;
	int size;
	
	public Arbol(Integer r) {
		root = new NodoArbol(r);
		size = 0;
	}
	
	public boolean isEmpty() {
		return root != null;
	}
	
	private void insert(NodoArbol n, NodoArbol root1) {
		if(root1 == null) {
			root1 = n;
			size++;
		}
		else if(root1.getValue() >= n.getValue()) {
			if(root1.getIzq() == null){
				root1.setIzq(n);
			}
			else {
				insert(n, root1.getIzq());
				size++;
			}	
		}
		else if(root1.getValue() <= n.getValue()) {
			if(root1.getDer() == null){
				root1.setDer(n);
			}
			else {
				insert(n, root1.getDer());
				size++;
			}	
		}
	}
	
	public void insert(NodoArbol n) {
		insert(n, root);
	}
	
	public NodoArbol getRoot() {
		return root;
	}

	public void setRoot(NodoArbol root) {
		this.root = root;
	}
	
	public boolean hasElement(Integer elem) {
		return hasElement(elem, root);
	}

	private boolean hasElement(Integer elem, NodoArbol root2) {
		// TODO Auto-generated method stub
		if(root2.getValue().equals(elem)){
			return true;
		}
		else if(elem < root.getValue()){
			if(root2.getIzq() != null){
				return hasElement(elem, root2.getIzq());				
			}
		}
		else if(root2.getIzq() != null){
			return hasElement(elem, root2.getDer());
		}
		return false;
	}
	
	public void imprimirEnOrden() {
		imprimirEnOrden(root);
		
	}
	
	private void imprimirEnOrden(NodoArbol root2) {
		// TODO Auto-generated method stub
		if(root2.getIzq() != null){
			imprimirEnOrden(root2.getIzq());
		}
		System.out.println(root2.toString());
		
		if(root2.getDer() != null){
			imprimirEnOrden(root2.getDer());
		}
	}
	
	public boolean delete(Integer elem) {
		
		return false;
		
	}

	public static void main(String[] args) {
		NodoArbol n1 = new NodoArbol(2);
		NodoArbol n2 = new NodoArbol(3);
		NodoArbol n3 = new NodoArbol(7);
		NodoArbol n4 = new NodoArbol(10);
		NodoArbol n5 = new NodoArbol(1);
		NodoArbol n6 = new NodoArbol(4);
		NodoArbol n7 = new NodoArbol(9);

		
		Arbol arbol = new Arbol(n1.getValue());
		arbol.insert(n2);
		arbol.insert(n3);
		arbol.insert(n4);
		arbol.insert(n5);
		arbol.insert(n6);
		arbol.insert(n7);

		
		arbol.imprimirEnOrden();
		
		System.out.println(arbol.hasElement(5));
		
//		Metodos:
//			- insert(NodoArbol n, NodoArbol root) y hasElem(Integer elem, NodoArbol root2)
//			La complejidad temporal de este metodo es O log2(n), ya que es similar a una busqueda binaria,
//			y lo que hace es ir descartando la mitad de los nodos a medida que va recorriendo para insertar o buscar 
//			si existe el elemento pasado por parametro. 
//			Si esta completo y/o balanceado, en cada iteracion dividimoms por dos, es por eso que la complejidad es log2(n) 


	}
}
