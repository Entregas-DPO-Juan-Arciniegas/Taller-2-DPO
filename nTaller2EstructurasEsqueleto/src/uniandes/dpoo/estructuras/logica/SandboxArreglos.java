package uniandes.dpoo.estructuras.logica;

import java.awt.TextArea;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre
 * arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y
 * arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas
 * como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos {
	/**
	 * Un arreglo de enteros para realizar varias de las siguientes operaciones.
	 * 
	 * Ninguna posición del arreglo puede estar vacía en ningún momento.
	 */
	private int[] arregloEnteros;

	/**
	 * Un arreglo de cadenas para realizar varias de las siguientes operaciones
	 * 
	 * Ninguna posición del arreglo puede estar vacía en ningún momento.
	 */
	private String[] arregloCadenas;

	/**
	 * Crea una nueva instancia de la clase con los dos arreglos inicializados pero
	 * vacíos (tamaño 0)
	 */
	public SandboxArreglos() {
		arregloEnteros = new int[] {};
		arregloCadenas = new String[] {};
	}

	/**
	 * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo
	 * tamaño que contiene copias de los valores del arreglo original
	 * 
	 * @return Una copia del arreglo de enteros
	 */
	public int[] getCopiaEnteros() {
		return Arrays.copyOf(this.arregloEnteros, getCantidadEnteros());
	}

	/**
	 * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo
	 * tamaño que contiene copias de los valores del arreglo original
	 * 
	 * @return Una copia del arreglo de cadenas
	 */
	public String[] getCopiaCadenas() {
		return Arrays.copyOf(this.arregloCadenas, getCantidadCadenas());
	}

	/**
	 * Retorna la cantidad de valores en el arreglo de enteros
	 * 
	 * @return
	 */
	public int getCantidadEnteros() {
		return this.arregloEnteros.length;
	}

	/**
	 * Retorna la cantidad de valores en el arreglo de cadenas
	 * 
	 * @return
	 */
	public int getCantidadCadenas() {
		return this.arregloCadenas.length;
	}

	/**
	 * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre
	 * debería aumentar en 1 la capacidad del arreglo.
	 * 
	 * @param entero El valor que se va a agregar.
	 */
	public void agregarEntero(int entero) {
		int tamaño = getCantidadEnteros();
		this.arregloEnteros = Arrays.copyOf(this.arregloEnteros, tamaño + 1);
		this.arregloEnteros[tamaño] = entero;
	}

	/**
	 * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre
	 * debería aumentar en 1 la capacidad del arreglo.
	 * 
	 * @param cadena La cadena que se va a agregar.
	 */
	public void agregarCadena(String cadena) {
		int tamaño = getCantidadCadenas();
		this.arregloCadenas = Arrays.copyOf(this.arregloCadenas, tamaño + 1);
		this.arregloCadenas[tamaño] = cadena;
	}

	/**
	 * Elimina todas las apariciones de un determinado valor dentro del arreglo de
	 * enteros
	 * 
	 * @param valor El valor que se va eliminar
	 */
	public void eliminarEntero(int valor) {
		int tamaño = getCantidadEnteros();
		int conteo = 0;

		for (int numero : this.arregloEnteros) {
			if (numero == valor) {
				conteo += 1;
			}
		}
		int[] nuevo = new int[tamaño - conteo];
		int j = 0;

		for (int numero : this.arregloEnteros) {
			if (numero != valor) {
				nuevo[j] = numero;
				j += 1;
			}
		}
		this.arregloEnteros = nuevo;
	}

	/**
	 * Elimina todas las apariciones de un determinado valor dentro del arreglo de
	 * cadenas
	 * 
	 * @param cadena La cadena que se va eliminar
	 */
	public void eliminarCadena(String cadena) {
		int tamaño = getCantidadCadenas();
		int conteo = 0;

		for (String texto : this.arregloCadenas) {
			if (texto.equals(cadena)) {
				conteo += 1;
			}
		}
		String[] nuevo = new String[tamaño - conteo];
		int j = 0;

		for (String texto : this.arregloCadenas) {
			if (!texto.equals(cadena)) {
				nuevo[j] = texto;
				j += 1;
			}
		}
		this.arregloCadenas = nuevo;
	}

	/**
	 * Inserta un nuevo entero en el arreglo de enteros.
	 * 
	 * @param entero   El nuevo valor que debe agregarse
	 * @param posicion La posición donde debe quedar el nuevo valor en el arreglo
	 *                 aumentado. Si la posición es menor a 0, se inserta el valor
	 *                 en la primera posición. Si la posición es mayor que el tamaño
	 *                 del arreglo, se inserta el valor en la última posición.
	 */
	public void insertarEntero(int entero, int posicion) {
		int tamaño = getCantidadEnteros();
		int[] nuevo = new int[tamaño + 1];
		int j = 0;

		if (posicion > tamaño) {
			posicion = tamaño;
		} else if (posicion < 0) {
			posicion = 0;
		}

		for (int i = 0; i < nuevo.length; i++) {
			if (i == posicion) {
				nuevo[i] = entero;
			} else {
				nuevo[i] = this.arregloEnteros[j];
				j += 1;
			}
		}
		this.arregloEnteros = nuevo;
	}

	/**
	 * Elimina un valor del arreglo de enteros dada su posición.
	 * 
	 * @param posicion La posición donde está el elemento que debe ser eliminado. Si
	 *                 el parámetro posicion no corresponde a ninguna posición del
	 *                 arreglo de enteros, el método no debe hacer nada.
	 */
	public void eliminarEnteroPorPosicion(int posicion) {
		int tamaño = getCantidadEnteros();
		if (0 <= posicion && posicion <= tamaño - 1) {
			int[] nuevo = new int[tamaño - 1];

			int j = 0;

			for (int i = 0; i < tamaño; i++) {
				if (posicion != i) {
					nuevo[j] = this.arregloEnteros[i];
					j += 1;
				}
			}
			this.arregloEnteros = nuevo;
		}
	}

	/**
	 * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del
	 * parámetro 'valores' truncados.
	 * 
	 * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería
	 * quedar el entero 3.
	 * 
	 * @param valores Un arreglo de valores decimales.
	 */
	public void reiniciarArregloEnteros(double[] valores) {
		int tamaño = valores.length;
		int[] nuevo = new int[tamaño];

		for (int i = 0; i < tamaño; i++) {
			nuevo[i] = (int) valores[i];
		}
		this.arregloEnteros = nuevo;
	}

	/**
	 * Reinicia el arreglo de cadenas con las representaciones como Strings de los
	 * objetos contenidos en el arreglo del parámetro 'objetos'.
	 * 
	 * Use el método toString para convertir los objetos a cadenas.
	 * 
	 * @param valores Un arreglo de objetos
	 */
	public void reiniciarArregloCadenas(Object[] objetos) {
		int tamaño = objetos.length;
		String[] nuevo = new String[tamaño];

		for (int i = 0; i < tamaño; i++) {
			nuevo[i] = objetos[i].toString();
		}
		this.arregloCadenas = nuevo;
	}

	/**
	 * Modifica el arreglo de enteros para que todos los valores sean positivos.
	 * 
	 * Es decir que si en una posición había un valor negativo, después de ejecutar
	 * el método debe quedar el mismo valor muliplicado por -1.
	 */
	public void volverPositivos() {
		for (int i = 0; i < this.arregloEnteros.length; i++) {
			if (this.arregloEnteros[i] < 0) {
				this.arregloEnteros[i] *= -1;
			}
		}
	}

	/**
	 * Modifica el arreglo de enteros para que todos los valores queden organizados
	 * de menor a mayor.
	 */
	public void organizarEnteros() {
		Arrays.sort(this.arregloEnteros);
	}

	/**
	 * Modifica el arreglo de cadenas para que todos los valores queden organizados
	 * lexicográficamente.
	 */
	public void organizarCadenas() {
		Arrays.sort(arregloCadenas);
	}

	/**
	 * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de
	 * enteros
	 * 
	 * @param valor El valor buscado
	 * @return La cantidad de veces que aparece el valor
	 */
	public int contarApariciones(int valor) {
		int apariciones = 0;
		for (int elemento : this.arregloEnteros) {
			if (elemento == valor) {
				apariciones += 1;
			}
		}
		return apariciones;
	}

	/**
	 * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo
	 * de cadenas.
	 * 
	 * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
	 * 
	 * @param cadena La cadena buscada
	 * @return La cantidad de veces que aparece la cadena
	 */
	public int contarApariciones(String cadena) {
		int apariciones = 0;
		for (String elemento : this.arregloCadenas) {
			if (elemento.toLowerCase().equalsIgnoreCase(cadena)) {
				apariciones += 1;
			}
		}
		return apariciones;
	}

	/**
	 * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se
	 * recibe en el parámetro
	 * 
	 * @param valor El valor que se debe buscar
	 * @return Un arreglo con los números de las posiciones del arreglo de enteros
	 *         en las que se encuentra el valor buscado. Si el valor no se
	 *         encuentra, el arreglo retornado es de tamaño 0.
	 */
	public int[] buscarEntero(int valor) {
		int contador = 0;

		for (int i = 0; i < this.arregloEnteros.length; i++) {
			if (this.arregloEnteros[i] == valor) {
				contador += 1;
			}
		}

		int[] arregloPosiciones = new int[contador];
		int indiceActual = 0;

		for (int j = 0; j < this.arregloEnteros.length; j++) {
			if (this.arregloEnteros[j] == valor) {
				arregloPosiciones[indiceActual] = j;
				indiceActual += 1;
			}
		}
		return arregloPosiciones;
	}

	/**
	 * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
	 * 
	 * @return Un arreglo con dos posiciones: en la primera posición, debe estar el
	 *         valor mínimo en el arreglo de enteros; en la segunda posición, debe
	 *         estar el valor máximo en el arreglo de enteros. Si el arreglo está
	 *         vacío, debe retornar un arreglo vacío.
	 */
	public int[] calcularRangoEnteros() {
		int tamañoarreglo = this.arregloEnteros.length;
		if (tamañoarreglo > 0) {
			int[] posiciones = new int[2];
			posiciones[0] = this.arregloEnteros[0];
			posiciones[1] = this.arregloEnteros[0];

			for (int i = 1; i < tamañoarreglo; i++) {
				if (posiciones[0] > this.arregloEnteros[i]) {
					posiciones[0] = this.arregloEnteros[i];
				}
				if (posiciones[1] < this.arregloEnteros[i]) {
					posiciones[1] = this.arregloEnteros[i];
				}
			}
			return posiciones;

		} else {
			return new int[0];
		}
	}

	/**
	 * Calcula un histograma de los valores del arreglo de enteros y lo devuelve
	 * como un mapa donde las llaves son los valores del arreglo y los valores son
	 * la cantidad de veces que aparece cada uno en el arreglo de enteros.
	 * 
	 * @return Un mapa con el histograma de valores.
	 */
	public HashMap<Integer, Integer> calcularHistograma() {
		return auxiliarhistograma(this.arregloEnteros);
	}
	
	
	/**
	 * auxiliar
	 */

	public HashMap<Integer, Integer> auxiliarhistograma(int[] arreglo) {
		HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();

		for (int i = 0; i < arreglo.length; i++) {
			int valoractual = arreglo[i];
			mapa.put(valoractual, mapa.getOrDefault(valoractual, 0) + 1);
		}

		return mapa;
	}
	
	

	/**
	 * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
	 * 
	 * @return La cantidad de enteos diferentes que aparecen más de una vez
	 */
	public int contarEnterosRepetidos() {
		int contador = 0;

		HashMap<Integer, Integer> mapa = calcularHistograma();
		for (int cantidadnumero : mapa.values()) {
			if (cantidadnumero > 1) {
				contador += 1;
			}
		}
		return contador;
	}

	/**
	 * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son
	 * iguales, es decir que contienen los mismos elementos exactamente en el mismo
	 * orden.
	 * 
	 * @param otroArreglo El arreglo de enteros con el que se debe comparar
	 * @return True si los arreglos son idénticos y false de lo contrario
	 */
	public boolean compararArregloEnteros(int[] otroArreglo) {
		return Arrays.equals(this.arregloEnteros, otroArreglo);
	}

	/**
	 * Compara el arreglo de enteros con otro arreglo de enteros y verifica que
	 * tengan los mismos elementos, aunque podría ser en otro orden.
	 * 
	 * @param otroArreglo El arreglo de enteros con el que se debe comparar
	 * @return True si los elementos en los dos arreglos son los mismos
	 */
	public boolean mismosEnteros(int[] otroArreglo) {
		HashMap<Integer, Integer> mapa1 = auxiliarhistograma(this.arregloEnteros);
		HashMap<Integer, Integer> mapa2 = auxiliarhistograma(otroArreglo);		
		return mapa1.equals(mapa2);
	}

	/**
	 * Cambia los elementos del arreglo de enteros por una nueva serie de valores
	 * generada de forma aleatoria.
	 * 
	 * Para generar los valores se debe partir de una distribución uniforme usando
	 * Math.random().
	 * 
	 * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
	 * 
	 * @param cantidad La cantidad de elementos que debe haber en el arreglo
	 * @param minimo   El valor mínimo para los números generados
	 * @param maximo   El valor máximo para los números generados
	 */
	public void generarEnteros(int cantidad, int minimo, int maximo) {
		int[] nuevo = new int[cantidad];
		
		for (int i = 0 ; i < cantidad ; i++) {
			nuevo[i] = (int) Math.floor((Math.random()*(maximo - minimo +1) + minimo));
		}
		this.arregloEnteros = nuevo;
	}

}
