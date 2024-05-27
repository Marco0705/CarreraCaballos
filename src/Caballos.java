// Importo la clase Random para que me dé un número cualquiera 
import java.util.Random;

// Creo la clase caballos implementando el runnable 
public class Caballos implements Runnable {
	// Declaro los atributos
	private String nombre = "";
	private int tiempo = 0;

	// Genero el constructor sobrecargado que tiene como parámetro el nombre del
	// caballo
	public Caballos(String nombre) {
		this.nombre = nombre;
	}

	// Genero los getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	// Implemento el método run() de la interfaz Runnable
	@Override
	public void run() {
		Random random = new Random();
		tiempo = random.nextInt(10000);
		try {
			Thread.sleep(tiempo);
			System.out.println("\n" + nombre + " ha terminado en " + (tiempo / 1000.0) + " segundos.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
}

