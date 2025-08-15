package proyecto.model;

public class Prestamos {
    private Libros libro;
    private Usuarios usuario;
    private String fecha;

    public Prestamos( Libros libro, Usuarios usuario, String fecha){
      this.libro = libro;
      this.usuario = usuario;
      this.fecha = fecha;
    }
}
