
import java.util.Comparator;

public class OrdenPromedio implements Comparator<LinkedAlumno>
{
     @Override
     public int compare(LinkedAlumno alumno,LinkedAlumno alumno2){
        return alumno.promedio() - alumno2.promedio();
        }

}
