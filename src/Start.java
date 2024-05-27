// Importo la clase Scanner para pedir datos al usuario
import java.util.Scanner;
public class Start {
	// Creo una función para calcular que caballo ha ganado
	public static String caballoGanador(Caballos caballo1, Caballos caballo2, Caballos caballo3) {
		int tiempoCaballo1 = caballo1.getTiempo();
		int tiempoCaballo2 = caballo2.getTiempo();
		int tiempoCaballo3 = caballo3.getTiempo();

		if (tiempoCaballo1 < tiempoCaballo2 && tiempoCaballo1 < tiempoCaballo3) {
			return caballo1.getNombre();
		} else if (tiempoCaballo2 < tiempoCaballo1 && tiempoCaballo2 < tiempoCaballo3) {
			return caballo2.getNombre();
		} else {
			return caballo3.getNombre();
		}
	}

	// Creo una función que muestre por pantalla la clasifiación de los caballos
	public static void podiumCaballos(Caballos caballo1, Caballos caballo2, Caballos caballo3) {
		int tiempoCaballo1 = caballo1.getTiempo();
		int tiempoCaballo2 = caballo2.getTiempo();
		int tiempoCaballo3 = caballo3.getTiempo();

		if (tiempoCaballo1 < tiempoCaballo2 && tiempoCaballo1 < tiempoCaballo3) {
			if (tiempoCaballo2 < tiempoCaballo3) {
				System.out.println("\nPuesto 1: " + caballo1.getNombre());
				System.out.println("\nPuesto 2: " + caballo2.getNombre());
				System.out.println("\nPuesto 3: " + caballo3.getNombre());
			} else {
				System.out.println("\nPuesto 1: " + caballo1.getNombre());
				System.out.println("\nPuesto 2: " + caballo3.getNombre());
				System.out.println("\nPuesto 3: " + caballo2.getNombre());

			}
		} else if (tiempoCaballo2 < tiempoCaballo1 && tiempoCaballo2 < tiempoCaballo3) {
			if (tiempoCaballo1 < tiempoCaballo3) {
				System.out.println("\nPuesto 1: " + caballo2.getNombre());
				System.out.println("\nPuesto 2: " + caballo1.getNombre());
				System.out.println("\nPuesto 3: " + caballo3.getNombre());
			} else {
				System.out.println("\nPuesto 1: " + caballo2.getNombre());
				System.out.println("\nPuesto 2: " + caballo3.getNombre());
				System.out.println("\nPuesto 3: " + caballo1.getNombre());
			}
		} else if (tiempoCaballo3 < tiempoCaballo2 && tiempoCaballo3 < tiempoCaballo1) {
			if (tiempoCaballo2 < tiempoCaballo1) {
				System.out.println("\nPuesto 1: " + caballo3.getNombre());
				System.out.println("\nPuesto 2: " + caballo2.getNombre());
				System.out.println("\nPuesto 3: " + caballo1.getNombre());
			} else {
				System.out.println("\nPuesto 1: " + caballo3.getNombre());
				System.out.println("\nPuesto 2: " + caballo1.getNombre());
				System.out.println("\nPuesto 3: " + caballo2.getNombre());
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Importo la clase Scanner y creo las variables para guardar los nombres de los
		// caballos
		Scanner scan = new Scanner(System.in);
		String nombre1 = "";
		String nombre2 = "";
		String nombre3 = "";
		// Pido el nombre del primer caballo y creo el objeto
		System.out.print("Dame el nombre del caballo1: ");
		nombre1 = scan.nextLine();
		Caballos caballo1 = new Caballos(nombre1);
		// Pido el nombre del segundo caballo y creo el objeto
		System.out.print("Dame el nombre del caballo2: ");
		nombre2 = scan.nextLine();
		Caballos caballo2 = new Caballos(nombre2);
		// Pido el nombre del tercer caballo y creo el objeto
		System.out.print("Dame el nombre del caballo3: ");
		nombre3 = scan.nextLine();
		Caballos caballo3 = new Caballos(nombre3);
		// Convierto el caballo en un hilo
		Thread t1 = new Thread(caballo1);
		System.out.println("\nSale el caballo " + nombre1);
		// Lanzo el hilo
		t1.start();
		// Convierto el caballo en un hilo
		Thread t2 = new Thread(caballo2);
		System.out.println("Sale el caballo " + nombre2);
		// Lanzo el hilo
		t2.start();
		// Convierto el caballo en un hilo
		Thread t3 = new Thread(caballo3);
		System.out.println("Sale el caballo " + nombre3);
		// Lanzo el hilo
		t3.start();
		// Utilizo el join para poder operar con las variables anteriores
		t1.join();
		t2.join();
		t3.join();
		// Llamo a la función para que muestre por pantalla cuál es el caballo ganador
		System.out.println("\nEl caballo ganador es: " + caballoGanador(caballo1, caballo2, caballo3));
		// Llamo a la función para ver la clasificación de los caballos
		podiumCaballos(caballo1, caballo2, caballo3);
		// Cierro la clase Scanner
		scan.close();
	}
}