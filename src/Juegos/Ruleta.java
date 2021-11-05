package Juegos;

import java.util.Scanner;
import java.util.Random;
import Miembros.*;

/**
 *
 * @author Yoav Galdamez and Ricardo Ruelas
 */

public class Ruleta implements IFichas{
    Scanner input;
    Random rnd;
    
    public Ruleta(){
        input = new Scanner(System.in);
        rnd = new Random();
    }
    
    public void jugar(Miembro miembro){
        int i,j, k;
        System.out.println("\t****Bienvenido a la ruleta****");
        System.out.println("Reglas:");
        System.out.println("1)Seleccionar un numero entre el 0 y el 20");
        System.out.println("2)Se tiene que apostar al menos 1 ficha");
        System.out.println("3)Los miembros Silver tendran 2 veces su apuesta mas un bono adicional de la mitad de su apuesta");
        System.out.println("4)Los miembros Golden tendran 3 veces su apuesta mas un bono adicional de 1.5 veces su apuesta");
        System.out.println("5)Los miembros Diamond tendran 5 veces su apuesta mas un bono adicional del doble de su apuesta");
        System.out.println("\tDisfruta");
        System.out.print("Ingresa tu apuesta: ");
        int apuesta = Integer.parseInt(input.nextLine());
        while(apuesta < 1){
            System.out.print("\nNo se puede hacer una apuesta negativa, intenta de nuevo: ");
            apuesta = Integer.parseInt(input.nextLine());
        }
        apostar(apuesta, miembro);
        System.out.println("");
        System.out.println("Numeros disponibles:");
        for(i = 0; i <= 20; i++){
            if(i != 20){
                System.out.print(i + ", ");
            }
            else{
                System.out.print(i);
            }
        }
        
        System.out.print("\nIngresa el numero a apostar: ");
        int numero = Integer.parseInt(input.nextLine());
        while((numero < 0)||(numero>20)){
            System.out.print("\nIngresa un numero que este disponible: ");
            numero = Integer.parseInt(input.nextLine());
        }
        System.out.println("");
        
        i = rnd.nextInt(20); // numero elegido en la ruleta
        j = i - 1;  // numero anterior
        k = i + 1; // numero posterior
       
        for(int giros = 0; giros < 3; giros++){
            System.out.println("Girando...");
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                System.out.println("Error: Ocurrio un problema cargando la ruleta.");
            }
            System.out.println("\t▼");
            System.out.printf("%d\t%d\t%d", j++, i++, k++);
            System.out.println("\n");
        }
        if(i == numero){
            System.out.println("¡Felicidades!");
            double fichas;
            fichas = cobrar(apuesta, miembro.getMembresia()) + calcularBono(miembro, apuesta);
            System.out.println("\nHas ganado "+fichas+" fichas");
        }
        else{
            System.out.println("No te desanimes, intentalo de nuevo!");
        }
    }
    
    public double cobrar(double apuesta, String membresia){
        if(membresia == "Silver"){
            return (apuesta * 2);
        }
        if(membresia == "Golden"){
            return (apuesta * 3);
        }
        if(membresia == "Diamond"){
            return (apuesta * 5);
        }
        return 0;
    }
    
    public void apostar(double apuesta, Miembro miembro){
        if(apuesta < miembro.getFichas())
            miembro.setFichas(miembro.getFichas()-apuesta);
        else{
            System.out.print("\nNo tienes suficientes fichas, intenta de nuevo: ");
            apuesta = Double.parseDouble(input.nextLine());
            apostar(apuesta, miembro);
        }
    }
    
    public double calcularBono(Miembro mbr, double apuesta){
        if(mbr.getMembresia() == "Silver"){
            System.out.print("El bono por ser miembro "+mbr.getMembresia()+" es de: "+(apuesta*.5));
            return (apuesta*.5);
        }
        if(mbr.getMembresia() == "Golden"){
            System.out.print("El bono por ser miembro "+mbr.getMembresia()+" es de: "+(apuesta*1.5));
            return (apuesta*1.5);
        }
        if(mbr.getMembresia() == "Diamond"){
            System.out.print("El bono por ser miembro "+mbr.getMembresia()+" es de: "+(apuesta*2));
            return (apuesta*2);
        }
        return 0;
    }

    
}
