public class Chargeur implements Runnable {

    AleaStock aleaStock;
    Chariot chariot;


    public Chargeur(AleaStock aleaStock, Chariot chariot) {
        this.aleaStock = aleaStock;
        this.chariot = chariot;
    }

    public void run() {
        AleaObjet aDeposer;
        boolean depotOk;

        try {
            while (!aleaStock.estVide()) {
                aDeposer = aleaStock.extractElem();
                System.out.println("Extractop, d'un object." + aDeposer.toString());
                depotOk = chariot.deposer(aDeposer);
                if (!depotOk) {
                    chariot.setPlein();
                    chariot.attendreVide();
                    depotOk = chariot.deposer(aDeposer);
                    if (!depotOk) {
                        System.out.println("Cet objet n'entre pas dans le chariot");
                    }
                }
            }
            chariot.setPlein();
        } catch (Exception e) {
            System.out.println("Chargeur interrompu. Terminated!");
        }


    }
}