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
        numeroDeProfesores++;
    }

    public Profesor(String nombre, String apellido, float CalificacionAprobatoria){
        this.nombre = nombre;
        this.apellido = apellido;
        this.CalificacionAprobatoria = CalificacionAprobatoria;
        numeroDeProfesores++;
    }

    //metodos
    public String getNombre(){
        return nombre + " " + apellido;
    }
    public float getCalificacionAprobatoria(){
        return CalificacionAprobatoria;
    }
    public void setCalificacionAprobatoria(float calificacionAprobatoria) {
        CalificacionAprobatoria = calificacionAprobatoria;
    }
    public int getNumeroProfesores(){
        return numeroDeProfesores;
    }

    public int getEdad() {
        return Edad;
    }
    
    public void setEdad(int edad) {
        Edad = edad;
    }

    public int getAlumnosAprobados() {
        return AlumnosAprobados;
    }

    public void setAlumnosAprobados(int alumnosAprobados) {
        AlumnosAprobados = alumnosAprobados;
    }

    public int getAlumnosReprobados() {
        return AlumnosReprobados;
    }

    public void setAlumnosReprobados(int alumnosReprobados) {
        AlumnosReprobados = alumnosReprobados;
    }

    public boolean aprobado(float calif){
        return calif>=getCalificacionAprobatoria();
    }

    public int AlumnosAprobados(List<Float> calificaciones){
        setAlumnosAprobados(0);
        for(Float calificacion: calificaciones){
            if(aprobado(calificacion)){
                setAlumnosAprobados(getAlumnosAprobados()+1);
            }
        }
        return getAlumnosAprobados();
    }

    public int AlumnosReprobados(List<Float> calificaciones){
        setAlumnosReprobados(0);
        for(Float calificacion: calificaciones){
            if(aprobado(calificacion)==false){
                setAlumnosReprobados(getAlumnosReprobados()+1);
            }
        }
        return getAlumnosReprobados();
    }

    public static Profesor registrarProfesor(){
        Scanner sc=new Scanner(System.in);
        int op=0;
        String nombre, apellido;
        int edad, calificacionAprobatoria;
        Profesor profesor;
        System.out.println("Ingrese nombre del profesor");
        nombre=sc.nextLine();
        System.out.println("Ingrese apellido del profesor");
        apellido=sc.nextLine();
        System.out.println("Ingrese calificacion aprobatoria del profesor");
        calificacionAprobatoria=sc.nextInt();
        sc.nextLine();
        System.out.println("Desea agregar la edad del profesor? 1)SI 2)NO");
        op=sc.nextInt();
        sc.nextLine();
        if(op==1){
            System.out.println("Ingrese edad del profesor");
            edad=sc.nextInt();
            sc.nextLine();
            profesor=new Profesor(nombre, apellido, edad, calificacionAprobatoria);
        }
        else{
            profesor =new Profesor(nombre, apellido, calificacionAprobatoria);
        }
        return profesor;
    }
     
    public void modificarProfesor(){
        float nuevaCalifAprobatoria;
        Scanner sc=new Scanner(System.in);
        System.out.println("Ha cumplido anios el profesor? 1)SI 2)NO");
        int cumpleanos=sc.nextInt();
        sc.nextLine();
        if(cumpleanos==1){
            setEdad(getEdad()+1);
        }
        System.out.println("Desea cambiar su calificacion aprobatoria? 1)SI 2)NO");
        int a=sc.nextInt();
        sc.nextLine();
        if(a==1){
            nuevaCalifAprobatoria=sc.nextFloat();
            sc.nextLine();
            setCalificacionAprobatoria(nuevaCalifAprobatoria);
        }
    }
}
