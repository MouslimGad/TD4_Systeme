import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Chariot {

    private int poidsMax, nbMax;
    private boolean plein;
    private List<AleaObjet> stock ;
    private int poidsCourant, nbCourant;

    private Lock lock;
    private Condition nonPlein;

    public Chariot(int poidsMax, int nbMax) {
        this.poidsMax = poidsMax;
        this.nbMax = nbMax;
        stock = new ArrayList<>(nbMax);
    }


    public boolean deposer(AleaObjet aleaObjet) throws InterruptedException{
        try{
            lock.lock();
            if((poidsCourant + aleaObjet.getPoids() < poidsMax) && (nbCourant < nbMax)){
                poidsCourant = poidsCourant + aleaObjet.getPoids();
                nbCourant++;
                stock.add(aleaObjet);
                System.out.println("Depot d'un objet de poids" + aleaObjet.getPoids());
                System.out.println("Poids total:"+poidsCourant+", nombre total:"+nbCourant);
                return true;
            }else {
                return false;
            }
        }finally {
            lock.unlock();
        }
    }

    public void setPlein(Dechargeur dechargeur){
        dechargeur.decharger(stock);
        stock.clear();
    }

    public void attendreVide()throws InterruptedException{
        try {
            lock.lock();
            while(plein) {
                nonPlein.await();
            }
        }
        finally {
            lock.unlock();
        }

    }


    public int getPoidsMax() {
        return poidsMax;
    }

    public int getNbMax() {
        return nbMax;
    }

    public void setPoidsMax(int poidsMax) {
        this.poidsMax = poidsMax;
    }

    public void setNbMax(int nbMax) {
        this.nbMax = nbMax;
    }
}
