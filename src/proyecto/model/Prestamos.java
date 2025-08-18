package proyecto.model;

import java.util.Date;

public class Prestamos {
  private Libros libro;
  private Usuarios usuario;
  private Date fechaPrestamo;
  private Date fechaDevolucion;

  public Prestamos(Libros libro, Usuarios usuario) {
    this.libro = libro;
    this.usuario = usuario;
    this.fechaPrestamo = new Date();
    this.fechaDevolucion = null;
  }

  public void devolver() {
    this.fechaDevolucion = new Date();
  }

  @Override
  public String toString() {
    return "Préstamo de " + libro.getTitulo() + " a " + usuario.getNombre() +
        " en " + fechaPrestamo + (fechaDevolucion != null ? " | Devuelto: " + fechaDevolucion : "");
  }
}
