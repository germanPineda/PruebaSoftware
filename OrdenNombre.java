
import java.util.Comparator;

public class OrdenNombre implements Comparator<LinkedAlumno>
{
     @Override
     public int compare(LinkedAlumno alumno,LinkedAlumno alumno2){
        return new String(alumno.nombre).compareTo(new String (alumno2.nombre));
        //return 0;
        }

}

