package hoja8;
import java.util.Scanner;
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
        File pacientes = new File("pacientes.txt");
	VectorHeap hospital;
	Paciente paciente;
	String [] palabra= new String [3];
	int num;
	int num2;
        int num3;
        num=0;
	num2=1;
	hospital = new VectorHeap();
        PriorityQueue<Paciente> hospital2;
        hospital2= new PriorityQueue();
	System.out.println("BIENVENIDOS AL HOSPITAL");
	System.out.println("Atender a los pacientes en el siguiente orden: \n");
        try{
            BufferedReader br = new BufferedReader(new FileReader(pacientes));
            try { //array de tipo numeral que implementa comparable
                int z=0;
                for(String line; (line = br.readLine()) != null; ){
                    num= num +1;
                    palabra= line.split(",");
                    paciente= new Paciente(palabra[0],palabra[1],palabra[2]);
                    hospital.add((Comparable) paciente);
                    hospital2.add(paciente);
                    z++;
                }
            }
            catch(IOException ex) {
                Logger.getLogger(Hoja8.class.getName()).log(Level.SEVERE, null, ex);
            }
            num3=num;
            System.out.println("--Implementacion empleando un heap--");
            while(num !=0){
                System.out.println(num2+". " + hospital.remove().toString());
		num = num-1;
                num2++;
            }
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