package Practico2;

public class NodoArbol {
	Integer value;
	NodoArbol izq;
	NodoArbol der;
	
	public NodoArbol(Integer v) {
		value = v;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public NodoArbol getIzq() {
		return izq;
	}

	public void setIzq(NodoArbol izq) {
		this.izq = izq;
	}

	public NodoArbol getDer() {
		return der;
	}

	public void setDer(NodoArbol der) {
		this.der = der;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return value.toString();
	}
}
