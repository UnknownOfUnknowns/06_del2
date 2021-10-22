package game.domain;

public class Konto {
    private int saldo;
    public Konto(int startbeholdning){
        saldo = startbeholdning;
    }

    public int getSaldo() {
        påvirkBalance(100);
        return saldo;
    }

    public boolean påvirkBalance(int s){
        saldo += s;
        if(saldo < 0) saldo = 0;
        return true;
    }
}
