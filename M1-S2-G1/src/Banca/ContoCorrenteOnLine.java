package Banca;

public class ContoCorrenteOnLine extends ContoCorrente {

    double maxPrelievo;
    ContoCorrenteOnLine(String titolare, double saldo, double maxP) {
        super(titolare, saldo);
        this.maxPrelievo = maxP;
    }

    void stampaSaldo(){
            System.out.println("-"+"\nTitolare: "+titolare+"\nSaldo: "+saldo+"\nNum movimenti: "+nMovimenti+
                            "\nMassimo movimenti: "+maxMovimenti+"\nMassimo prelievo possibile: "+maxPrelievo+"\n-");
    }
    void preleva(double x) throws BancaException {
        if(x < maxPrelievo){
            super.preleva(x);
        }
        if (x > maxPrelievo)
            throw new BancaException("Prelievo non disponibile");
    }
}
