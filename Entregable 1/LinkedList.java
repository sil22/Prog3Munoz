package Practico1;


public class LinkedList {
	private Node first;
	private int size = 0;
	
	public LinkedList() {
		first = null;
	}
	
	public void add(Object n){
		Node temp = new Node(n,null);
		temp.setNext(first);
		first = temp;
		size++;
	}
	

	public void insertLast(Object o) {
		
		if(isEmpty()){
			add(o);
		}
		else {
		Node n = first;
		while(n.getNext() != null){
			n = n.getNext();	
		}
		Node nuevo = new Node(o, null);
		n.setNext(nuevo);
		size++;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	private boolean contains(Object obj) {
		// TODO Auto-generated method stub
		if(!isEmpty()) {
			int count = 0;
			Node aux = first;
			while(count < size()){
				if(aux.getValue().equals(obj)){
					return true;
				}
				aux = aux.getNext();
				count++;
			}
		}
		
		return false;
	}
	
	public Object getElement(int p) {
		int cont = 0;
		if(p >= 0 && p <= size) {
			Node elem = first;
			
			while ( p != cont ) {
				elem = elem.getNext();
				cont++;
			}
			return elem.getValue();
		}
		return null;
	}
	
	
	public static LinkedList compareAndCreateNewList(LinkedList first, LinkedList second ) {
		
		LinkedList resultList = new LinkedList();
		LinkedList resultListOrd = new LinkedList();

		for (int i = 0; i < first.size(); i++) {
			Object obj = first.getElement(i);
			if(second.contains(obj)) {
				resultList.insertLast(obj);
			}
		}
		resultListOrd = sort(resultList);
		return resultListOrd;
		
	}
	

	public Object getMin(){
		
		if(size() == 1){
			return first.getValue();
		}
		Node aux = first;
		Object min = first.getValue();
		Object current = null;
		
		int pos = 0;
		
		while(pos < size){
			current = aux.getValue();
			if((int)min > (int)current){
				min = current;
			}
			aux = aux.getNext();
			pos++;
		}
		return min;
	}
	
	public boolean removeElement(Object o){

		if(!isEmpty()){
			if (first.getValue().equals(o)) {
				Node temp = first;
				first = first.getNext();	
				temp.setNext(null);
				size--;
				return true;
			}
			else{
				Node aux = first;
				while(aux.getNext() != null){
					if(aux.getNext().getValue().equals(o)){
						Node temp = aux.getNext().getNext();
						aux.getNext().setNext(null);
						aux.setNext(temp);
						size--;
						return true;
					}
					aux = aux.getNext();
				}			
				if(aux.getValue().equals(o)){
					if(size() <= 1){
						Node temp = first;
						first = first.getNext();	
						temp.setNext(null);
						size--;
					}
					else{
						Node temp = first;
						int count = 0;
						while(count < size()-2){
							temp = temp.getNext();
							count++;
						}
						temp.setNext(null);
						size--;
					}
					return true;
				}
			}	
		}
		return false;
	}

	
	
	public static LinkedList sort(LinkedList list) {

		LinkedList newList = new LinkedList();
		while(!list.isEmpty()){
			Object max = list.getMin();
			list.removeElement(max);
			newList.insertLast(max);
		}
		return  newList;
	}
	
	public String toString(){

		String result = "";
		Node aux = first;
		while(aux != null){
			result += aux.getValue() + " ";
			aux = aux.getNext();
		}

		return result;
	}
	
	public static void main(String[] args) {
		
//		LISTAS DESORDENADAS 
		LinkedList listOne = new LinkedList();
		listOne.insertLast(2);
		listOne.insertLast(1);
		listOne.insertLast(6);
		listOne.insertLast(4);
		listOne.insertLast(8);
				
		LinkedList listTwo = new LinkedList();
		listTwo.insertLast(3);
		listTwo.insertLast(4);
		listTwo.insertLast(2);
		listTwo.insertLast(1);
		listTwo.insertLast(9);

		System.out.println("Listas desordenadas:");
		System.out.println("* " + listOne.toString());

		System.out.println("* " + listTwo.toString());
		
		LinkedList listThree = new LinkedList();
		listThree = compareAndCreateNewList(listOne, listTwo);
		System.out.println("Lista Resultado: " + listThree.toString() + "\n");

//		LISTAS ORDENADAS
		LinkedList list1 = new LinkedList();
		list1.insertLast(1);
		list1.insertLast(2);
		list1.insertLast(3);
		list1.insertLast(4);
		list1.insertLast(5);
				
		LinkedList list2 = new LinkedList();
		list2.insertLast(1);
		list2.insertLast(4);
		list2.insertLast(5);
		list2.insertLast(9);
		list2.insertLast(10);

		System.out.println("Listas Ordenadas:");
		System.out.println("* " + list1.toString());
		System.out.println("* " + list2.toString());
		
		LinkedList list3 = new LinkedList();
		list3 = compareAndCreateNewList(list1, list2);
		System.out.println("Lista Resultado: " +list3.toString());

		
		}	

}
