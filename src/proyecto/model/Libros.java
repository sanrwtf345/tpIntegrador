package proyecto.model;

public abstract class Libros {
    private int ISMB;
    private String titulo;
    private String autor;
    private Estado estado;

    public Libros(int ISBM, String titulo, String autor, Estado estado){
        this.ISMB = ISBM;
        this.titulo = titulo;
        this.autor = autor;
        this.estado = estado;
    }

    //setters
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setISMB(int ISMB) {
        this.ISMB = ISMB;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //getters
    public int getISMB() {
        return ISMB;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Estado getEstado() {
        return estado;
    }
}
