package Miembros;

import java.util.Scanner;

public class MiembroSilver extends Miembro{

    public MiembroSilver(String nombre, String correo, String membresia) {
        super(nombre, correo, membresia);
    }

    @Override
    public Miembro registrarMiembro(){
        Scanner input = new Scanner(System.in);
        String nombre, correo, membresia;
        System.out.print("\nIngresa tu nombre: ");
        nombre = input.nextLine();
        System.out.print("\nIngresa tu correo: ");
        correo = input.nextLine();

        return new MiembroSilver(nombre, correo, "Silver");
    }
    
}
