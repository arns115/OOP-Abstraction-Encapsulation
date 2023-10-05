package alumno;

import java.util.Scanner;

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
        AlumnosTotales++;
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

    public static Alumno registrarAlumno(){
        Scanner sc =new Scanner(System.in);
        int op=0;
        String nombre, apellido;
        int edad;
        System.out.println("Ingrese el nombre del alumno");
        nombre=sc.nextLine();
        System.out.println("Ingrese el apellido del alumno");
        apellido=sc.nextLine();
        System.out.println("Ingrese la edad del alumno");
        edad=sc.nextInt();
        sc.nextLine();
        Alumno alumno=new Alumno(nombre, apellido, edad);
        return alumno;
    }
}
