import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
        lock = new ReentrantLock();
        nonPlein = lock.newCondition();
    }


    public boolean deposer(AleaObjet aleaObjet) throws InterruptedException{
        try{
            lock.lock();
            if((poidsCourant + aleaObjet.getPoids() < poidsMax) && (nbCourant < nbMax)){
                poidsCourant = poidsCourant + aleaObjet.getPoids();
                nbCourant++;
                stock.add(aleaObjet);
                System.out.println("Depot d'un objet de poids " + aleaObjet.getPoids());
                System.out.println("Poids total:"+poidsCourant+", nombre total: "+nbCourant);
                return true;
            }else {
                return false;
            }
        }finally {
            lock.unlock();
        }
    }


    public boolean decharger() throws InterruptedException{
        try{
            lock.lock();
            if((poidsCourant + aleaObjet.getPoids() < poidsMax) && (nbCourant < nbMax)){
                poidsCourant = poidsCourant + aleaObjet.getPoids();
                nbCourant++;
                stock.add(aleaObjet);
                System.out.println("Depot d'un objet de poids " + aleaObjet.getPoids());
                System.out.println("Poids total:"+poidsCourant+", nombre total: "+nbCourant);
                return true;
            }else {
                return false;
            }
        }finally {
            lock.unlock();
        }
    }

    public void setVide() throws InterruptedException {
        try {

        }
    }


    public void setPlein() throws InterruptedException{
        try {
            lock.lock();
            plein = true;
        }
        finally {
            lock.unlock();
        }
    }

    public void attendreVide() throws InterruptedException{
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

}
