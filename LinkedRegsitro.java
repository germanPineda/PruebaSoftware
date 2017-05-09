import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

public class LinkedRegsitro{
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int continuar=0,menu=0,pos=0,tam=0, objeto=0, cont = 0, contador = 0, p = 0;
        double suma=0;
        boolean compro;
        LinkedList listaAlumnos = new LinkedList();       
        
        do{
            do{
                cont = 0;
                System.out.println("PRESIONE A PARA AGREGAR UN ELEMENTO A LA LISTA  ");
                System.out.println("PRESIONE B PARA ELIMINAR UN ELEMENTO DE LA LISTA ");
                System.out.println("PRESIONE C PARA MOSTRAR LA LISTA ");
                System.out.println("PRESIONE D PARA VERIFICAR SI SE ENCUENTRA EN LA LISTA");
                System.out.println("PRESIONE E PARA REMPLAZAR UN ELEMENTO DE LA LISTA");
                System.out.println("PRESIONE F PARA ORDENAR LA LISTA");
                System.out.print("eleccion: ");
                menu=sc.nextInt();
                switch(menu){
                    case 1:
                        do{
                            int prome=0;
                            double cali[]=new double[3];
                            int id1=0;
                            String nombre1;
                            System.out.print("ID: ");
                            id1=sc.nextInt();
                            System.out.print("Nombre: ");
                            nombre1=sc.next();
                            for(int x=0;x<3;x++){
                                System.out.print("Calificacion "+(x+1) + ": ");
                                cali[x]=sc.nextDouble();
                            }
                            contador = contador + 3;
                            //System.out.println(contador);
                            LinkedAlumno alumno = new LinkedAlumno(id1,nombre1,cali);
                            listaAlumnos.add(alumno);
                            LinkedAlumno alum=(LinkedAlumno)listaAlumnos.get(p);
                            suma += alum.Calificaciones[0]+alum.Calificaciones[1]+alum.Calificaciones[2];
                            p++;
                            //System.out.println(suma);
                            //System.out.println(p);
                            System.out.print("¿Desea agregar a otro alumno?: ");
                            continuar=sc.nextInt();
                            sc.nextLine();
                        }while(continuar==1);
                        break;
                    case 2:
                        System.out.print("ID del alumno a eliminar: ");
                        pos=sc.nextInt();
                        for(int x=0; x<listaAlumnos.size();x++)
                        {
                            LinkedAlumno alumno = (LinkedAlumno)listaAlumnos.get(x);
                            if(alumno.id==pos)
                            {
                                listaAlumnos.remove(x);
                                System.out.println("elemento eliminado con exito");
                                cont = 1;
                            }
                        }
                        if(cont == 0)
                            System.out.println("el id no se encuentra en la lista");
                        break;
                    case 3:
                        Iterator itr=listaAlumnos.iterator();
                        while(itr.hasNext()){
                            LinkedAlumno imp=(LinkedAlumno)itr.next();
                            System.out.println(imp);
                        }
                        //System.out.print(contador);
                        System.out.println("El promedio final del grupo es de: " + suma/contador); 
                        break;
                        
                    case 4:
                        int id=0; //divisor = 0;
                        //double prom=0, suma2 = 0;
                        System.out.print("ID del alumno que desea verificar: ");
                        id=sc.nextInt();
                        Collections.sort(listaAlumnos, new OrdenID());
                        
                        LinkedAlumno searchkey = (LinkedAlumno)listaAlumnos.get(id);
                        int index = Collections.binarySearch(listaAlumnos, searchkey,new EmpComp());
                        System.out.println("El alumno se encuentra en la poscicion: ");
                        System.out.println(" " + index);
        
                        
                         
                        
                        
                        break;
                        
                    case 5:
                        System.out.print("Numero de la posicion del alumno que desea remplazar: ");
                        pos=sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese los nuevos datos");
                        int prome=0;
                        double cali[]=new double[3];
                        int id1=0;
                        String nombre1;
                        System.out.print("ID: ");
                        id1=sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nombre: ");
                        nombre1=sc.nextLine();
                        for(int x=0;x<3;x++){
                            System.out.println("Calificacion "+(x+1)+": ");
                            cali[x]=sc.nextInt();
                        }
                        LinkedAlumno alumno = new LinkedAlumno(id1,nombre1,cali);
                        listaAlumnos.set(pos,alumno);
                        break;
                        
                    case 6:
                    int respuesta;
                    
                    
                        System.out.println("PRESIONE 1 PARA ORDENAR POR NOMBRE");
                        System.out.println("PRESIONE 2 PARA ORDENAR POR CLAVE");
                        System.out.println("PRESIONE 3 PARA MOSTRAR POR PROMEDIO");
                        respuesta = sc.nextInt();
                        //LinkedAlumno alumno
                        switch(respuesta){
                         case 2:
                         Collections.sort(listaAlumnos, new OrdenID()) ;
                            
                         System.out.println(" Lista ordenada por id: ");
                         System.out.println(listaAlumnos);
                         
                         break;
                        
                        case 1:
                        Collections.sort(listaAlumnos,new OrdenNombre()); 

                         System.out.println(" Lista ordenada por nombre: ");
                         System.out.println(listaAlumnos);
                        break;
                        
                        case 3:
                        Collections.sort(listaAlumnos, new OrdenPromedio()); 

                        System.out.println(" Lista ordenada por promedio: ");
                         System.out.println(listaAlumnos);
                        break;
                    }

                    break;
                    default : 
                        System.out.println("ENTRADA ERRONEA.");
                    }
                System.out.print("¿Desea continuar?: ");
                continuar=sc.nextInt();
                }while(continuar==1);
            }while(continuar==1);
        }
            
      public static class EmpComp implements Comparator<LinkedAlumno>{
     
        public int compare(LinkedAlumno e1, LinkedAlumno e2) {
            if(e1.id == e2.id){
                return 0;
            } else {
                return -1;
            }
        }
    }
     
}    
    
    
    
    
    /*for(int x=0;x<listaAlumnos.size();x++){
                            LinkedAlumno alum=(LinkedAlumno)listaAlumnos.get(x);
                            if(alum.id==id){
                                System.out.println("El alumno se encuentra en la lista\n");
                                System.out.println("ID: "+alum.id);
                                System.out.println("Nombre: "+alum.nombre);
                                System.out.println("Calificaciones");
                                for ( int i = 0; i < 3; i++){
                                    System.out.println("#"+(i+1)+" "+ alum.Calificaciones[i]);
                                }
                                divisor = divisor + 3;
                                suma2 = alum.Calificaciones[0]+alum.Calificaciones[1]+alum.Calificaciones[2];
                                System.out.println("promedio: " + suma2/divisor);
                                cont = 1;
                            }
                        }
                        
                        if(cont == 0)
                            System.out.println("el id no se encuentra en la lista");
                            */
