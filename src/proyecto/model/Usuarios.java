package proyecto.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuarios {
  private int id;
  private String nombre;
  private List<Prestamos> historialPrestamos;

  public Usuarios(int id, String nombre) {
    this.id = id;
    this.nombre = nombre;
    this.historialPrestamos = new ArrayList<>();
  }

  //setters
  public void setId(int id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  //getters
  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public void agregarPrestamo(Prestamos p) {
    historialPrestamos.add(p);
  }

  public List<Prestamos> getHistorialPrestamos() {
    return historialPrestamos;
  }

  @Override
  public String toString() {
    return nombre + " (ID: " + id + ")";
  }
}
