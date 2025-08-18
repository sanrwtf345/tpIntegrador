package proyecto.model;

import proyecto.exceptions.LibroNoDisponibleException;

public interface Prestable {
  void prestar(Usuarios usuario) throws LibroNoDisponibleException;

  void devolver();
}
