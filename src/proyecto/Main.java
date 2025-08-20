package proyecto;


import proyecto.model.Biblioteca;
import proyecto.model.Libros;
import proyecto.model.Usuarios;

import java.util.logging.Logger;

public class Main {
  public static final Logger log = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    Biblioteca biblio = new Biblioteca();

    // Crear libros
    Libros l1 = new Libros("111", "Java Básico", "Autor A", "Programación") {
    };
    Libros l2 = new Libros("222", "Álgebra Lineal", "Autor B", "Matemáticas");

    // Registrar libros
    biblio.registrarLibro(l1);
    biblio.registrarLibro(l2);

    // Crear usuarios
    Usuarios u1 = new Usuarios(01, "Santiago");
    Usuarios u2 = new Usuarios(02, "María");

    // Registrar usuarios
    biblio.registrarUsuario(u1);
    biblio.registrarUsuario(u2);

    // Operaciones
    biblio.prestarLibro("111", u1); // Santiago pide Java Básico
    biblio.reservarLibro("111", u2); // María lo reserva
    biblio.devolverLibro("111"); // Se devuelve y pasa a María

    // Mostrar catálogo por categoría
    log.info("\nLibros de Programación:");
    biblio.mostrarLibrosPorCategoria("Programación");

  }
}