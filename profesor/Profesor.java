package profesor;

import alumno.Alumno;
import java.util.*;


public class Profesor {
    //atributos
    private String nombre;
    private String apellido;
    private int Edad;
    private float CalificacionAprobatoria;
    private int AlumnosAprobados;
    private int AlumnosReprobados;
    private static int numeroDeProfesores;

    //constructores
    public Profesor(String nombre, String apellido, int Edad, float CalificacionAprobatoria){
        this.nombre = nombre;
        this.apellido = apellido;
        this.Edad = Edad;
        this.CalificacionAprobatoria = CalificacionAprobatoria;
    }

    //metodos
    public String getNombre(){
        return this.nombre + " " + this.apellido;
    }
    public float getCalificaiconAprobatoria(){
        return this.CalificacionAprobatoria;
    }
    public int getNumeroProfesores(){
        return numeroDeProfesores;
    }


    public int AlumnosAprobados(ArrayList<Alumno> ListaDeAlumnos){
        this.AlumnosAprobados = 0;
        for(Alumno alumno : ListaDeAlumnos ){
            if(alumno.getPromedio() >= this.CalificacionAprobatoria){
                this.AlumnosAprobados ++;
            }
        }
        return this.AlumnosAprobados;
    }
    public int AlumnosReprobados(ArrayList<Alumno> ListaDeAlumnos){
        this.AlumnosReprobados = 0;
        for(Alumno alumno : ListaDeAlumnos ){
            if(alumno.getPromedio() < this.CalificacionAprobatoria){
                this.AlumnosReprobados ++;
            }
        }
        return this.AlumnosReprobados;
    }

}
