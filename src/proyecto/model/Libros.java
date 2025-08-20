package proyecto.model;

import proyecto.Main;
import proyecto.exceptions.LibroNoDisponibleException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

public class Libros implements Prestable, Reservable {

  public static final Logger log = Logger.getLogger(Libros.class.getName());
  private String isbn;
  private String titulo;
  private String autor;
  private String categoria;
  private boolean disponible;
  private Queue<Usuarios> listaEspera;

  public Libros(String isbn, String titulo, String autor, String categoria) {
    this.isbn = isbn;
    this.titulo = titulo;
    this.autor = autor;
    this.categoria = categoria;
    this.disponible = true;
    this.listaEspera = new LinkedList<>();
  }

  //setters
  public void setListaEspera(Queue<Usuarios> listaEspera) {
    this.listaEspera = listaEspera;
  }

  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public void setAutor(String autor) {
    this.autor = autor;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  //getters
  public String getIsbn() {
    return isbn;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getAutor() {
    return autor;
  }

  public String getCategoria() {
    return categoria;
  }

  public boolean isDisponible() {
    return disponible;
  }

  public Queue<Usuarios> getListaEspera() {
    return listaEspera;
  }

  @Override
  public void prestar(Usuarios usuario) throws LibroNoDisponibleException {
    if (!disponible) {
      throw new LibroNoDisponibleException("El libro " + titulo + " no está disponible.");
    }
    disponible = false;
    log.info("Libro prestado: " + titulo + " a " + usuario.getNombre());
  }

  @Override
  public void devolver() {
    disponible = true;
    if (!listaEspera.isEmpty()) {
      Usuarios siguiente = listaEspera.poll();
      log.info("El libro " + titulo + " se asigna automáticamente a " + siguiente.getNombre());
      try {
        prestar(siguiente);
      } catch (LibroNoDisponibleException e) {
        log.info("Error inesperado al asignar el libro en espera.");
      }
    }
  }

  @Override
  public void reservar(Usuarios usuario) {
    listaEspera.offer(usuario);
    log.info(usuario.getNombre() + " ha sido agregado a la lista de espera del libro " + titulo);
  }

  @Override
  public String toString() {
    return titulo + " [" + isbn + "] - " + (disponible ? "Disponible" : "Prestado");
  }

}
