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
    static float promedioEscuela;

    public Grupo(String identificadorGrupo, List <Alumno> listaAlumnos, List<Asignatura> materias, int numAlumnos){
        this.identificadorGrupo=identificadorGrupo;
        this.listaAlumnos=listaAlumnos;
        this.materias=materias;
        this.numAlumnos=numAlumnos;
        numGrupos++;
    }
    public Grupo(String identificadorGrupo, List<Alumno> listaAlumnos, int numAlumnos){
        this.identificadorGrupo=identificadorGrupo;
        this.listaAlumnos=listaAlumnos;
        this.numAlumnos=numAlumnos;
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

    public static float getPromedioEscuela() {
        return promedioEscuela;
    }

    public static void actualizarPromedioEscuela(float a, float b){
        promedioEscuela-=(a/numGrupos);
        promedioEscuela+=(b/numGrupos);
    }


    public void actualizarPromedioGrupo(){
        float a=getPromedioGrupo();
        setPromedioGrupo(0.0f);
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
    
    public static Grupo registrarGrupo(){
        Scanner sc= new Scanner(System.in);
        Grupo grupo;
        int op=0, op1=0, op2=0;
        String id;
        int numAlumnos=0;
        System.out.println("Ingrese el identificador del grupo");
        id=sc.nextLine();
        System.out.println("Desea agregar la lista de alumnos? 1)SI 2)NO");
        op=sc.nextInt();
        sc.nextLine();
        if(op==1){
            List <Alumno> listaDeAlumnos = new ArrayList<Alumno>();
            do{
                listaDeAlumnos.add(Alumno.registrarAlumno());
                listaDeAlumnos.get(numAlumnos).setNumeroLista(numAlumnos);
                numAlumnos++;
                System.out.println("Desea registrar otro alumno? 1)SI 2)NO");
                op1=sc.nextInt();
                sc.nextLine();
            } while(op1==1); 
            System.out.println("Desea agregar la lista de materias? 1)SI 2)NO");
            op2=sc.nextInt();
            sc.nextLine();
            if(op2==1){
                List <Asignatura> listaDeAsignaturas = new ArrayList<Asignatura>();
                List<Float> listCalificaciones=new ArrayList<Float>();
                for (int i=0;i<numAlumnos;i++){
                    listCalificaciones.add(0.0f);
                }
                do{
                    Asignatura materia1=Asignatura.registrarAsignatura(listCalificaciones);
                    listaDeAsignaturas.add(materia1);
                    System.out.println("Desea registrar otra asignatura? 1)SI 2)NO");
                    op1=sc.nextInt();
                    sc.nextLine();
                } while(op1==1); 
                grupo=new Grupo(id, listaDeAlumnos, listaDeAsignaturas, numAlumnos);
            }
            else{
                grupo=new Grupo(id, listaDeAlumnos, numAlumnos);
            }
        } 
        else{
            grupo=new Grupo(id);
        }
        return grupo;
    }
    
    public void modificarGrupo(){
        Scanner sc=new Scanner(System.in);
        int op=0, i=0, index, op1=0;
        System.out.println("Que desea modificar?");
        while(op!=5){
            System.out.println("1)Agregar alumno\n2)Modificar alumno\n3)Agregar asignatura\n"+
            "4)Modificar asignatura\n5)Salir");
            op=sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    Alumno alumno =Alumno.registrarAlumno();
                    alumno.setNumeroLista(getNumAlumnos());
                    setNumAlumnos(getNumAlumnos()+1);
                    listaAlumnos.add(alumno);
                    for (Asignatura asignatura1: getMaterias()){
                        asignatura1.getCalificaciones().add(0.0f);
                    }
                    break;
                case 2:
                    System.out.println("Que alumno quiere modificar? Ingrese numero de lista");
                    i=0;
                    for (Alumno alum: listaAlumnos){
                        System.out.println(i + " ------> " +alum);
                    }
                    index=sc.nextInt();
                    sc.nextLine();
                    if(index>=getNumAlumnos()){
                        System.out.println("Alumno no existe");
                    }
                    else{
                        listaAlumnos.get(index).modificarAlumno();
                        System.out.println("Desea modificar sus calificaciones? 1)SI 2)NO");
                        op1=sc.nextInt();
                        sc.nextLine();
                        int numLista=listaAlumnos.get(index).getNumeroLista();
                        float nueva;
                        if(op1==1){
                            for (Asignatura asignatura3: getMaterias()){
                                System.out.println(asignatura3+ "Promedio alumno: "+ 
                                                    asignatura3.getCalificaciones().get(numLista));
                                System.out.println("Ingrese nueva calificacion de la materia");
                                nueva=sc.nextFloat();
                                sc.nextLine();
                                asignatura3.modificarCalificacion(numLista, nueva);
                            }
                        }
                    }
                    break;
                case 3:
                    List<Float> listCalificaciones1=new ArrayList<Float>();
                    for (int j=0;j<numAlumnos;j++){
                        listCalificaciones1.add(0.0f);
                    }
                    Asignatura asignatura1=Asignatura.registrarAsignatura(listCalificaciones1);
                    agregarAsignatura(asignatura1);
                    break;
                case 4:
                    System.out.println("Que asignatura quiere modificar? - Ingrese indice");
                    i=0;
                    for (Asignatura asignatura2: getMaterias()){
                        System.out.println(i+ " ------> "+ asignatura2);
                    }
                    index=sc.nextInt();
                    sc.nextLine();
                    if(index>=getMaterias().size()){
                        System.out.println("Materia no existe");
                    }
                    else{
                        materias.get(index).modificarAsignatura();
                    }
                    break;
                case 5:
                    continue;
                default:
                    System.out.println("Opcion no disponible");
            }

        } 
    }

    public String toString(){
        StringBuilder str1=new StringBuilder(1000);
        str1.append("Identificador Grupo: " +getIdentificadorGrupo()+"\n");
        str1.append("MATERIAS: \n#########################\n");
        for (Asignatura asignatura:getMaterias()){
            str1.append(asignatura.getNombreAsignatura()+"\n");
            str1.append("Clave: "+asignatura.getClaveAsignaturas()+'\n');
            if(asignatura.getTemas()!=null){
                str1.append("Temas: "+asignatura.getTemas()+"\n");
            }
            str1.append(asignatura.getProfesor()+"\n");
            str1.append("Calificaciones: \n");
            for (int m=0;m<getNumAlumnos();m++){
                str1.append(getListaAlumno().get(m)+": "+ asignatura.getCalificaciones().get(m)+"\n");
            }
            str1.append("\nPromedio general de la asignatura: "+ asignatura.getPromedioAsignatura()+"\n");
            str1.append("Numero de alumnos aprobados: "+ asignatura.getProfesor().AlumnosAprobados(asignatura.getCalificaciones())+"\n");
            str1.append("Numero de alumnos reprobados: "+ asignatura.getProfesor().AlumnosReprobados(asignatura.getCalificaciones())+"\n");
        }
        str1.append("\nPromedio general del grupo: "+ getPromedioGrupo()+"\n");
        return str1.toString();
    }
}
