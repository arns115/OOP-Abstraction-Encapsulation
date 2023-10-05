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
    static int numAsignaturas;
     
    public Asignatura(String nombreAsignatura, Profesor profesor, int claveAsignatura){
        this.nombreAsignatura=nombreAsignatura;
        this.profesor=profesor;
        this.claveAsignatura=claveAsignatura;
        numAsignaturas++;
    }

    public Asignatura(String nombreAsignatura, Profesor profesor, String temas, int claveAsignatura){
        this.nombreAsignatura=nombreAsignatura;
        this.profesor=profesor;
        this.temas=temas;
        this.claveAsignatura=claveAsignatura;
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

    public void actualizarPromedioAsignatura(){
        setPromedioAsignatura(0);
        for (Float calif:getCalificaciones()){
            setPromedioAsignatura(getPromedioAsignatura()+(calif/calificaciones.size()));
        }
    }

    public void modificarCalificacion(int index, float calificacion){
        calificaciones.set(index, calificacion);
        actualizarPromedioAsignatura();
    }

    public void simularCalificaciones(){
        for (int i=0;i<getCalificaciones().size();i++){
            float a=(float)Math.random()*10.0f;
            modificarCalificacion(i, a);
        }
    }

    public static Asignatura registrarAsignatura(){
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
            asignatura=new Asignatura(nombre, profesor, temas, clave);
        }
        else{
            asignatura=new Asignatura(nombre, profesor, clave);
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
