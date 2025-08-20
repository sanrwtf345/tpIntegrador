package proyecto.model;

import proyecto.exceptions.LibroNoDisponibleException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class Biblioteca {

  public static final Logger log = Logger.getLogger(Biblioteca.class.getName());
  private Map<String, Libros> catalogoLibros;
  private Map<String, Set<Libros>> librosPorCategoria;
  private Set<Usuarios> usuariosRegistrados;

  public Biblioteca() {
    catalogoLibros = new HashMap<>();
    librosPorCategoria = new HashMap<>();
    usuariosRegistrados = new HashSet<>();
  }

  // Registro de libros
  public void registrarLibro(Libros libro) {
    catalogoLibros.put(libro.getIsbn(), libro);
    librosPorCategoria.computeIfAbsent(libro.getCategoria(), k -> new HashSet<>()).add(libro);
  }

  // Registro de usuarios
  public void registrarUsuario(Usuarios usuario) {
    usuariosRegistrados.add(usuario);
  }

  // Buscar libro por ISBN
  public Libros buscarLibro(String isbn) {
    return catalogoLibros.get(isbn);
  }

  // Préstamo
  public void prestarLibro(String isbn, Usuarios usuario) {
    try {
      Libros libro = buscarLibro(isbn);
      if (libro == null) {
        log.info("Libro no encontrado.");
        return;
      }
      libro.prestar(usuario);
      Prestamos prestamo = new Prestamos(libro, usuario);
      usuario.agregarPrestamo(prestamo);
    } catch (LibroNoDisponibleException e) {
      log.info(e.getMessage());
    }
  }

  // Devolución
  public void devolverLibro(String isbn) {
    Libros libro = buscarLibro(isbn);
    if (libro != null) {
      libro.devolver();
    }
  }

  // Reservar
  public void reservarLibro(String isbn, Usuarios usuario) {
    Libros libro = buscarLibro(isbn);
    if (libro != null) {
      libro.reservar(usuario);
    }
  }

  // Mostrar catálogo por categoría
  public void mostrarLibrosPorCategoria(String categoria) {
    Set<Libros> libros = librosPorCategoria.get(categoria);
    if (libros != null) {
      libros.forEach(System.out::println);
    } else {
      log.info("No hay libros en la categoría " + categoria);
    }
  }
}

