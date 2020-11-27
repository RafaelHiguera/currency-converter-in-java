package test;

import currencyConverter.Currency;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static currencyConverter.MainWindow.convert;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoiteNoire {
    // Partition des entrees et valeurs frontieres
    double normalInput = 20;
    double nullInput = 0;
    double extremeUpperInput = Integer.MAX_VALUE;
    double extremeLowerInput = Integer.MIN_VALUE;

    //values needed for the test
    private ArrayList<Currency> currencies = Currency.init();

   //conversion name
    //"US Dollar", "Euro", "British Pound", "Swiss Franc", "Chinese Yuan Renminbi", "Japanese Yen"

    public double usdToEuroToPoundToYuan(double input){
        double euro = convert("US Dollar", "Euro", currencies, input);
        double pound = convert( "Euro", "British Pound", currencies, euro);
        return convert("British Pound", "Chinese Yuan Renminbi", currencies, pound);
    }

    public double usdToFrancToYenToYuan(double input){
        double franc = convert("US Dollar", "Swiss Franc", currencies, input);
        double yen = convert( "Swiss Franc", "Japanese Yen", currencies, franc);
        return convert("Japanese Yen", "Chinese Yuan Renminbi", currencies, yen);
    }

    @Test
    public void testNormalInput() {
        assertEquals(usdToEuroToPoundToYuan(normalInput), usdToFrancToYenToYuan(normalInput));
    }

    @Test
    public void testNullInput() {
        assertEquals(usdToEuroToPoundToYuan(nullInput), usdToFrancToYenToYuan(nullInput));
    }

    @Test
    public void testExtremeUpperInput() {
        assertEquals(usdToEuroToPoundToYuan(extremeUpperInput), usdToFrancToYenToYuan(extremeUpperInput));
    }

    @Test
    public void testExtremeLowerInput() {
        assertEquals(usdToEuroToPoundToYuan(extremeLowerInput), usdToFrancToYenToYuan(extremeLowerInput));
    }
}
