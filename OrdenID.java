import java.util.Comparator;

public class OrdenID implements Comparator<LinkedAlumno>
{
     @Override
     public int compare(LinkedAlumno alumno,LinkedAlumno alumno2){
        return alumno.id - alumno2.id;
        }

}
