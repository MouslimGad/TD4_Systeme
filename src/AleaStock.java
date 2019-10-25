import java.util.ArrayList;
import java.util.List;

public class AleaStock {

    private List<AleaObjet> stock ;


    public AleaStock(int taille) {
        stock = new ArrayList<>(taille);

    }

    public void remplirStock(AleaObjet aleaObjet) {
        stock.add(aleaObjet);
    }

    public synchronized boolean estVide() {
        if(stock.isEmpty()){
            return true;
        }
        return false;
    }


    public AleaObjet extractElem(){
        return stock.remove(0);
    }


}
