package asignatura;

import profesor.Profesor;
import java.util.*;

public class Asignatura {
    private String nombreAsignatura;
    private Profesor profesor;
    private List<Float> calificaciones= new ArrayList<Float>();
    private String temas;
    private int claveAsignaturas;
    private float promedioAsignatura;
    static int numAsignaturas;
     
    public Asignatura(String nombreAsignatura, Profesor profesor){
        this.nombreAsignatura=nombreAsignatura;
        this.profesor=profesor;
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

    public void setCalificaciones(List<Float> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public String getTemas() {
        return temas;
    }

    public void setTemas(String temas) {
        this.temas = temas;
    }

    public int getClaveAsignaturas() {
        return claveAsignaturas;
    }

    public void setClaveAsignaturas(int claveAsignaturas) {
        this.claveAsignaturas = claveAsignaturas;
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


}
