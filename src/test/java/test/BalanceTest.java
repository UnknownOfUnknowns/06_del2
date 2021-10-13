package test;
import static org.junit.Assert.assertTrue;
import game.domain.Spiller;
import org.junit.jupiter.api.Test;

public class BalanceTest {
    private int TESTITTERATIONER = 100000;
    @Test
    void balance_over_0(){
        Spiller spiller = new Spiller();
        for (int i = 0; i < TESTITTERATIONER; i++){
            int påvirkning = (int) (Math.random() * 700);
            påvirkning = (Math.random() > 0.5) ? -påvirkning : påvirkning;
            spiller.opdaterBalance(påvirkning);
            assertTrue(spiller.getBalance() >= 0);
        }
    }
}
