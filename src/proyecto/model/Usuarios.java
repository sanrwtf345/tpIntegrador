package proyecto.model;

public abstract class Usuarios {
    private int ID;
    private String nombre;

    public Usuarios(int ID, String nombre){
        this.ID = ID;
        this.nombre = nombre;
    }

    //setters
    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //getters
    public int getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }
}
