import java.util.*;
import grupo.Grupo;
import alumno.Alumno;
import asignatura.Asignatura;

public class Principal {
    public static void main(String [] args){
        List<Grupo> grupos= new ArrayList<Grupo>();
        Scanner sc=new Scanner(System.in);
        int op=0;
        System.out.println("BIENVENIDO\n################################");
        System.out.println("Que desea hacer?");
        while(op!=7){
            System.out.println("1)Crear grupo\n2)Modificar Grupo\n3) Calcular calificacion de grupos\n" +
            "4)Imprimir Promedio Escolar\n5)Mostrar informacion grupos\n6)Salir\n");
            op=sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    grupos.add(Grupo.registrarGrupo());

                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("De que grupo quieres calcular calificacion(simular)?- ingresa el indice");
                    int indice1=0;
                    for (Grupo grupo1: grupos){
                        System.out.println(indice1+ " -----> "+grupo1);
                    }
                    int indice2=sc.nextInt();
                    sc.nextLine();
                    if(indice2<grupos.size()){
                        for (Asignatura asignatura:grupos.get(indice2).getMaterias()){
                            asignatura.simularCalificaciones();
                        }
                        for (int indiceAlumno=0;indiceAlumno<grupos.get(indice2).getNumAlumnos();indiceAlumno++){
                            float promedioAlum=0;
                            for (Asignatura asignatura: grupos.get(indice2).getMaterias()){
                                promedioAlum+=(asignatura.getCalificaciones().get(indiceAlumno))/grupos.get(indice2).getMaterias().size();
                            }
                            grupos.get(indice2).getListaAlumno().get(indiceAlumno).setPromedio(promedioAlum);
                        }
                    }
                case 4:
                    System.out.println("Promedio escolar: "+ Grupo.getPromedioEscuela()+'\n');
                    for (Grupo grupo:grupos){
                        System.out.println("Promedio grupo "+grupo.getIdentificadorGrupo()+ ": "+ grupo.getPromedioGrupo());
                    }
                    break;

            }
        }
    }

}
