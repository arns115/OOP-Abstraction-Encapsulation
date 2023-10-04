package grupo;

import java.util.*;
import asignatura.Asignatura;
import alumno.Alumno;

public class Grupo {
    private String identificadorGrupo;
    private int numAlumnos;
    private float promedioGrupo;
    private List<Alumno> listaAlumnos=new ArrayList<Alumno>();
    private List<Asignatura> materias =new ArrayList<Asignatura>();
    static int numGrupos;
    static int promedioEscuela;

    public Grupo(String identificadorGrupo, List <Alumno> listaAlumnos, List<Asignatura> materias){
        this.identificadorGrupo=identificadorGrupo;
        this.listaAlumnos=listaAlumnos;
        this.materias=materias;
        numGrupos++;
    }
    public Grupo(String identificadorGrupo, List<Alumno> listaAlumnos){
        this.identificadorGrupo=identificadorGrupo;
        this.listaAlumnos=listaAlumnos;
        numGrupos++;
    }
    public Grupo(String identificadorGrupo){
        this.identificadorGrupo=identificadorGrupo;
        numGrupos++;
    }

    public String getIdentificadorGrupo() {
        return identificadorGrupo;
    }

    public int getNumAlumnos() {
        return numAlumnos;
    }
    
    public void setNumAlumnos(int numAlumnos) {
        this.numAlumnos = numAlumnos;
    }

    public float getPromedioGrupo() {
        return promedioGrupo;
    }
    
    public void setPromedioGrupo(float promedioGrupo) {
        this.promedioGrupo = promedioGrupo;
    }

    public List<Alumno> getListaAlumno() {
        return listaAlumnos;
    }

    public void setListaAlumno(List<Alumno> listaAlumno) {
        this.listaAlumnos = listaAlumno;
    }

    public List<Asignatura> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Asignatura> materias) {
        this.materias = materias;
    }

    public static int getPromedioEscuela() {
        return promedioEscuela;
    }

    public static void actualizarPromedioEscuela(float a, float b){
        promedioEscuela-=(a/numGrupos);
        promedioEscuela+=(b/numGrupos);
    }


    public void actualizarPromedioGrupo(){
        float a=getPromedioGrupo();
        setPromedioGrupo(promedioGrupo);
        for (Asignatura asignatura: getMaterias()){
            setPromedioGrupo(getPromedioGrupo()+(asignatura.getPromedioAsignatura()/getMaterias().size()));
        }
        actualizarPromedioEscuela(a, getPromedioGrupo());
    }

    public void agregarAlumno(Alumno alumno){
        listaAlumnos.add(alumno);
    }

    public void eliminarAlumno(int index){
        listaAlumnos.remove(index);
    }

    public void eliminarAlumno(String nombre){
        int i=0;
        for (Alumno alumno1:getListaAlumno()){
            if (alumno1.getNombre()==nombre){
                listaAlumnos.remove(i);
                break;
            }
            i++;
        }
    }

    public void agregarAsignatura(Asignatura asignatura){
        materias.add(asignatura);
    }

    public void eliminarAsignatura(int index){
        materias.remove(index);
    }

    public void eliminarAsignatura(String nombreAsignatura){
        int i=0;
        for (Asignatura asignatura:getMaterias()){
            if(asignatura.getNombreAsignatura()==nombreAsignatura){
                materias.remove(i);
                break;
            }
            i++;
        }
    }

    public void imprimirInformacionGrupo(){
        
    }
    
}
