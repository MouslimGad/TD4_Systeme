import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<AleaObjet> stock = new ArrayList<AleaObjet>();

        AleaStock aleaStock = new AleaStock(10);

        for (int i = 0; i < 10; i++) {
            aleaStock.remplirStock(new AleaObjet(5,10));
        }

        Chariot chariot = new Chariot(25,5);

        Chargeur chargeur = new Chargeur(aleaStock,chariot);

        chargeur.run();
    }
}
