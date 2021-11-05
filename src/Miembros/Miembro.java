package Miembros;
import java.util.Scanner;

public abstract class Miembro {
    
    private String nombre;
    private String correo;
    private String Membresia;
    private double Fichas;
    
    public Miembro(String nombre, String correo, String membresia){
        setNombre(nombre);
        setCorreo(correo);
        setMembresia(membresia);
    }

    public double getFichas() {
        return Fichas;
    }

    public void setFichas(double Fichas) {
        if(Fichas > 0)
            this.Fichas = Fichas;
        else{
            System.out.print("\nDebes depositar al menos una ficha, intenta de nuevo ");
            depositarF();
        }
    }

    public String getMembresia() {
        return Membresia;
    }

    public void setMembresia(String Membresia) {
        if(Membresia.length() > 3)
            this.Membresia = Membresia;
        else{
            System.out.print("\nUna membresia tiene que tener mas de 3 caracteres, intenta de nuevo");
            registrarMiembro();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(nombre.length() > 3)
            this.nombre = nombre;
        else{
            System.out.print("\nUn nombre tiene que tener mas de 3 caracteres, intenta de nuevo");
            registrarMiembro();
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if(correo.length() > 7)
            this.correo = correo;
        else{
            System.out.print("\nUn correo tiene que tener mas de 10 caracteres, intenta de nuevo");
            registrarMiembro();
        }
    }
    
    public abstract Miembro registrarMiembro();
    
    public void depositarF(){
        Scanner input = new Scanner(System.in);
        double dep;
        System.out.print("\nIngresa la cantidad de fichas a depositar: ");
        dep = Integer.parseInt(input.nextLine());
        setFichas(dep);
    }
}
