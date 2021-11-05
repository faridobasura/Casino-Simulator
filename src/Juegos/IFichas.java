package Juegos;
import Miembros.*;

public interface IFichas {
	double cobrar(double apuesta, String membresia);
	void apostar(double apuesta, Miembro mbr);
	double calcularBono(Miembro mbr, double apuesta);
}