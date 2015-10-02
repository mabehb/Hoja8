import java.util.Comparator;
public class Paciente implements Comparable<Paciente>{
	String nombre;
	String sintoma;
	String codigo;

	public Paciente(String nombre, String sintoma, String codigo){
        this.nombre=nombre;
        this.sintoma=sintoma;
        this.codigo=codigo;
    }
	public int compareTo(Object o){
        Paciente otro= (Paciente)o;
		return codigo.compareTo(otro.getCodigo());
    }
    public String getCodigo(){
    	return codigo;
    }
    public String toString(){
    	return nombre+", "+sintoma+", "+codigo;
    }
}