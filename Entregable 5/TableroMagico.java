public class TableroMagico {
	int n;
	int k;
	int suma;
	boolean usados[];
	int tablero[][] = new int[n][n];

	public TableroMagico(int n, int k, int suma) {
		this.n = n;
		this.k = k;
		this.suma = suma;
		tablero = new int[n][n];
		usados = new boolean[k];

	}

	private boolean solucion(int[] sumaParcialFilas, int[] sumaParcialCols, int n2, int suma2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n2; i++) {
			if (sumaParcialFilas[i] != suma2 || sumaParcialCols[i] != suma2) {
				return false;
			}
		}
		return true;
	}

	private boolean poda(int sumaParcialFilas[], int sumaParcialCols[], boolean usados[], int num, int f, int c) {
		// TODO Auto-generated method stub
		if (sumaParcialFilas[f] + num > suma || sumaParcialCols[c] + num > suma) { // si las sumas parciales de filas y cols mas el numero a insertar
																					// es mayor a suma--> podo
			return true;
		}
		return false;
	}

	private void imprimirTablero() {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(tablero[i][j]);
				System.out.print(" ");
			}
			System.out.println(" ");

		}
		System.out.println(" ");
	}

	public boolean tableroMagico(int k, int suma, int fila, int col, int sumaFilas[], int sumaCols[]) {
		if (fila >= n) { // si llego al final de la filaque estoy recorriendo
			if (solucion(sumaFilas, sumaCols, n, suma)) {
				imprimirTablero();
				return true;
			} else {
				return false;
			}
		}
		boolean sol = false;
		boolean poda = false;
		int num = 1; // numro q voy a insertar al tablero
		while (!sol && !poda && num <= k) {
			if (!usados[num]) { // si no use ese numero, chequeo si es poda
				if (poda(sumaFilas, sumaCols, usados, num, fila, col)) {
					poda = true;
				} else { //sino seteo la fila y col correspondiente controlando que no supere 'n'
					int proxFila, proxCol;
					if (col == n - 1) {  //si es la ultima  columna
						proxFila = fila + 1;
					} else {
						proxFila = fila;
					}
					if (col == n - 1) {
						proxCol = 0;
					} else {
						proxCol = col + 1;
					}
					usados[num] = true;  // pongo en true el numero que estoy insertando al tablero, asi no se repite
					tablero[fila][col] = num; //inserto el num en el tblero
					sumaFilas[fila] += num;
					sumaCols[col] += num;
					sol = tableroMagico(k, suma, proxFila, proxCol, sumaFilas, sumaCols);  //llamada back
					usados[num] = false;
					tablero[fila][col] = 0;
					sumaFilas[fila] -= num;
					sumaCols[col] -= num;
					//dejo seteado todo en 0
				}
			}
			num++;
		}
		return sol;
	}

	public static void main(String[] args) {
		int n = 3;
		int sumaFilas[] = new int[n];
		int sumaCols[] = new int[n];
		TableroMagico tablero = new TableroMagico(n, 30, 15);
		tablero.tableroMagico(20, 15, 0, 0, sumaFilas, sumaCols);
	}

}
