package alumno;

public class Alumno {
    //Atributos
    private String nombre;
    private String apellido;
    private int numeroDeLista;
    private float Promedio;
    private int Edad;
    private static int AlumnosTotales;

    //Constructores
    public Alumno(String nombre, String apellido, int Edad){
        this.nombre = nombre;
        this.apellido = apellido;
        this.Edad = Edad;
    }
    
    //metodos
    public String getNombre(){
        return this.nombre + " " + this.apellido;
    }
    public int getEdad(){
        return this.Edad;
    }
    public float getPromedio(){
        return this.Promedio;
    }
    public int getNumeroAlumnosTotales(){
        return AlumnosTotales;
    }
    public void setNumeroLista(int numeroDeLista){
        this.numeroDeLista = numeroDeLista;
    }
    public int getNumeroLista(){
        return this.numeroDeLista;
    }

    
}
