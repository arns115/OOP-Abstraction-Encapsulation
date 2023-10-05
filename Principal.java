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
            System.out.println("1)Crear grupo\n2)Modificar Grupo\n3)Imprimir Promedio Escolar\n4)Mostrar informacion grupos\n5)Salir\n");
            op=sc.nextInt();
            sc.nextLine();
            switch(op){
                case 1:
                    grupos.add(Grupo.registrarGrupo());
                    break;
                case 2:

                    break;
                case 3:
                    System.out.println("Promedio escolar: "+ Grupo.getPromedioEscuela()+'\n');
                    for (Grupo grupo:grupos){
                        System.out.println("Promedio grupo "+grupo.getIdentificadorGrupo()+ ": "+ grupo.getPromedioGrupo());
                    }
                    break;
                case 4:

            }
        }
    }

}
