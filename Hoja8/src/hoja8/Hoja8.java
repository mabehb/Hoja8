import java.util.Scanner;
import java.io.*;

/**
 *
 * @author michel
 */
public class Hoja8{

public static void main(String[] args) {
	BufferedReader bf = null;
	Scanner teclado=new Scanner(System.in);
	Hospital cont;
	Paciente paciente;
	String [] palabra= new String [3];
	int num;
	num=0;
	int num2;
	num2=1;
	cont = new Hospital();
	System.out.println("BIENVENIDOS AL HOSPITAL");
	System.out.println("El Orden de los pacientes es:");
	try{
		bf= new BufferedReader(new FileReader("datos.txt"));
		String lector="";
		while((lector= bf.readLine()) != null){
			num= num +1;
			palabra= lector.split(",");
			paciente= new Paciente(palabra[0],palabra[1],palabra[2]);
			cont.meterPaciente(paciente);
			}
		while(num !=0){
			System.out.println(num2 + cont.sacarPaciente().toString());
			num = num-1;
		}
		
			}
	catch(Exception e ){
			System.err.println("no metiste un archivo correcto");
		}
	}
}