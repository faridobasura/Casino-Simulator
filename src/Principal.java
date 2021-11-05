import Juegos.Ruleta;
import Miembros.*;

/**
 *
 * @author Ricardo Ruelas
 */

public class Principal {
    
    public static void main(String[] args) {
        Ruleta prueba = new Ruleta();
        Miembro mb = new MiembroSilver("Farido", "yoavpozos@gamil.com", "Silver");
        mb.setFichas(500);
        
        prueba.jugar(mb);
    }
    
}
