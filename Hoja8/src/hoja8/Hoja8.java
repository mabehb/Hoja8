package hoja8;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.PriorityQueue;

/**
 *
 * @author michel
 */
public class Hoja8{

public static void main(String[] args) {
        //se crea un fichero
        File pacientes = new File("pacientes.txt");
        //para la implementacion con heap
	VectorHeap hospital;
        hospital = new VectorHeap();
        //para la implementacion con JCF
        PriorityQueue<Paciente> hospital2;
        hospital2= new PriorityQueue();
        //instancia para la ficha del paciente
	Paciente paciente;
        //informacion del paciente
	String [] informacion;
        //contadores
	int num;
        int num2;
        int num3;
        num=0;
	num2=1;
        
        //inicio de la interaccion con el usuario
	System.out.println("BIENVENIDOS AL HOSPITAL");
	System.out.println("Orden de llegada de los pacientes:");
        //se lee el archivo de texto con la informacion de los pacientes que van llegando
        try{
            BufferedReader br = new BufferedReader(new FileReader(pacientes));
            try { //array de tipo numeral que implementa comparable
                int z=0;
                for(String line; (line = br.readLine()) != null; ){
                    System.out.println(num2+". "+line);
                    num= num +1;
                    //se guarda por separado la informacion del paciente
                    informacion= line.split(",");
                    //con la informacion se crea una ficha para el paciente
                    paciente= new Paciente(informacion[0],informacion[1],informacion[2]);
                    //se realizan las 2 diferenres implementaciones
                    hospital.add((Comparable) paciente); //heap
                    hospital2.add(paciente); //JCF
                    z++;
                }
            }
            catch(IOException ex) {
                Logger.getLogger(Hoja8.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Se imprimen los resultados, primero empleando heap y luego JCF
            //los resultados deben ser los mismos
            System.out.println("\nAtender a los pacientes en el siguiente orden: ");
            
            //implementacion con heap
            num3=num;
            num2=1;
            System.out.println("\n--Implementacion empleando un heap--");
            while(num !=0){
                System.out.println(num2+". " + hospital.remove().toString());
		num = num-1;
                num2++;
            }
            
            //implementacion con JCF
            num2=1;
            System.out.println("\n--Implementacion empleando JCF--");
            while(num3 !=0){
                System.out.println(num2+". " + hospital2.remove().toString());
		num3 = num3-1;
                num2++;
            }
	}
        catch(FileNotFoundException ex) {
            Logger.getLogger(Hoja8.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
}