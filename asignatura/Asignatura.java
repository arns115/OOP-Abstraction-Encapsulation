package asignatura;

import profesor.Profesor;
import java.util.*;

public class Asignatura {
    private String nombreAsignatura;
    private Profesor profesor;
    private List<Float> calificaciones= new ArrayList<Float>();
    private String temas;
    private int claveAsignatura;
    private float promedioAsignatura;
    private static int numAsignaturas;
     
    public Asignatura(String nombreAsignatura, Profesor profesor, int claveAsignatura, List<Float> l1){
        this.nombreAsignatura=nombreAsignatura;
        this.profesor=profesor;
        this.claveAsignatura=claveAsignatura;
        this.calificaciones=l1; 
        numAsignaturas++;
    }

    public Asignatura(String nombreAsignatura, Profesor profesor, String temas, int claveAsignatura, List<Float> l1){
        this.nombreAsignatura=nombreAsignatura;
        this.profesor=profesor;
        this.temas=temas;
        this.claveAsignatura=claveAsignatura;
        this.calificaciones=l1;
        numAsignaturas++;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Float> getCalificaciones() {
        return calificaciones;
    }

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public int getClaveAsignaturas() {
        return claveAsignatura;
    }

    public void setClaveAsignaturas(int claveAsignaturas) {
        this.claveAsignatura = claveAsignaturas;
    }

    public float getPromedioAsignatura() {
        return promedioAsignatura;
    }

    public void setPromedioAsignatura(float promedioAsignatura) {
        this.promedioAsignatura = promedioAsignatura;
    }

    public static int getNumAsignaturas(){
        return numAsignaturas;
    }

    public void actualizarPromedioAsignatura(){
        setPromedioAsignatura(0);
        for (Float calif:getCalificaciones()){
            setPromedioAsignatura(getPromedioAsignatura()+(calif/calificaciones.size()));
        }
    }

    public void modificarCalificacion(int index, Float calificacion){
        calificaciones.set(index, calificacion);
        actualizarPromedioAsignatura();
    }

    public void simularCalificaciones(){
        for (int i=0;i<getCalificaciones().size();i++){
            Float a=(float)Math.random()*10.0f;
            modificarCalificacion(i, a);
        }
    }

    public static Asignatura registrarAsignatura(List<Float> listaCalif){
        Scanner sc=new Scanner(System.in);
        int op=0;
        String nombre, temas;
        int clave;
        Asignatura asignatura;
        System.out.println("Ingrese nombre de asignatura");
        nombre=sc.nextLine();
        System.out.println("Ingrese la clave de asignatura");
        clave=sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese la informacion del profesor");
        Profesor profesor=Profesor.registrarProfesor();
        System.out.println("Desea agregar los temas de la asignatura? 1)SI 2)NO");
        op=sc.nextInt();
        sc.nextLine();
        if(op==1){
            System.out.println("Ingrese los temas");
            temas=sc.nextLine();
            asignatura=new Asignatura(nombre, profesor, temas, clave, listaCalif);
        }
        else{
            asignatura=new Asignatura(nombre, profesor, clave, listaCalif);
        }
        return asignatura;
    }

    public void modificarAsignatura(){
        Scanner sc = new Scanner(System.in);
        int op=0;
        System.out.println("Que informacion desea modificar?");
        System.out.println("1) Temas de asignatura\n2) Informacion del profesor\n");
        op=sc.nextInt();
        sc.nextLine();
        switch(op){
            case 1:
                System.out.println("Ingrese nuevo temario de la asignatura");
                String nuevosTemas=sc.nextLine();
                setTemas(nuevosTemas);
                break;
            case 2:
                getProfesor().modificarProfesor();
                break;
            default:
                System.out.println("Opcion no disponible");
        }
    }
}
