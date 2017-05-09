import java.util.LinkedList;
class LinkedAlumno{
    int id = 0;
    String nombre = " ";
    double[]Calificaciones = new double[3];
    LinkedAlumno(int i,String n, double c[]){
        id = i;
        nombre=n;
        Calificaciones = c;
    }
    @Override
    public String toString(){
        return "\nID: "+id+"\nNombre: "+nombre+"\nCalificaciones: "+"\n1: "+Calificaciones[0]+"\n2: "+Calificaciones[1]+"\n3: "+Calificaciones[2];
    }
    public int promedio(){
        int suma = 0;
         for(int i = 0; i < 3; i++){
         suma = suma +(int) Calificaciones[i];
        }
        return suma/4;
    }
}
