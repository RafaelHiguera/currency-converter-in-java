package test;

import currencyConverter.Currency;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static currencyConverter.MainWindow.convert;
import static currencyConverter.Currency.convert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoiteBlanche {


    double extremeUpperInput = Double.MAX_VALUE;
    double extremeLowerInput = Double.MIN_VALUE;
    double normalInput = 20;
    private final ArrayList<Currency> currencies = Currency.init();

    // A. Critère de couverture des instructions

    @Test
    public void test_MainWindowConvert_CoverAllInstruction() {
        assertEquals(convert("US Dollar", "Euro", currencies, normalInput), 18.6);
    }

    // B. Critère de couverture des arcs du graphe de flot de contrôle

    @Test
    public void test_MainWindowConvert_TrueForAllIf() {
        assertEquals(convert("US Dollar", "Euro", currencies, normalInput), 18.6);
    }

    @Test
    public void test_MainWindowConvert_WrongCurency1() {
        assertEquals(convert("CAD", "Euro", currencies, normalInput), 0.0);
    }

    @Test
    public void test_MainWindowConvert_WrongCurency2() {
        assertEquals(convert("US Dollar", "CAD", currencies, normalInput), 0.0);
    }


    // C. Critère de couverture des chemins indépendants du graphe de flot de contrôle

    // E. Critère de couverture des i-chemins


}
