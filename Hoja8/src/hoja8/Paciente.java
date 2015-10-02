
/**
 *
 * @author Ma. Belen
 */
package hoja8;
public class Paciente implements Comparable<Paciente>{
	String nombre;
	String sintoma;
	String codigo;

	public Paciente(String nombre, String sintoma, String codigo){
        this.nombre=nombre;
        this.sintoma=sintoma;
        this.codigo=codigo;
    }
    
    public String getCodigo(){
    	return codigo;
    }
    public String toString(){
    	return nombre+", "+sintoma+", "+codigo;
    }

    @Override
    public int compareTo(Paciente o) {
        Paciente otro= (Paciente)o;
        return codigo.compareTo(otro.getCodigo());
    }
}