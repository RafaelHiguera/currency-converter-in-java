package test;

import currencyConverter.Currency;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static currencyConverter.MainWindow.convert;
import static currencyConverter.Currency.convert;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoiteNoire {
    // Partition des entrees et valeurs frontieres
    double normalInput = 20;
    double nullInput = 0;
    double extremeUpperInput = Double.MAX_VALUE;
    double extremeLowerInput = Double.MIN_VALUE;

    //values needed for the test
    private final ArrayList<Currency> currencies = Currency.init();

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
        assertEquals((int)usdToEuroToPoundToYuan(normalInput), (int)usdToFrancToYenToYuan(normalInput));
    }

    @Test
    public void testNullInput() {
        assertEquals(usdToEuroToPoundToYuan(nullInput), usdToFrancToYenToYuan(nullInput));
    }

    @Test
    public void testExtremeUpperInput() {
        assertEquals((int)usdToEuroToPoundToYuan(extremeUpperInput), (int)usdToFrancToYenToYuan(extremeUpperInput));
    }

    @Test
    public void testExtremeLowerInput() {
        assertEquals(usdToEuroToPoundToYuan(extremeLowerInput), usdToFrancToYenToYuan(extremeLowerInput));
    }


    //currencyConverter.Currency.convert(Double, Double)
    @Test
    public void test_CurrencyConvert_normal() {
        assertEquals(convert(normalInput, normalInput), normalInput*normalInput);
    }

    @Test
    public void test_CurrencyConvert_extreme() {
        assertNotEquals(convert(extremeUpperInput, extremeUpperInput), extremeUpperInput*extremeUpperInput);
    }

    @Test
    public void test_CurrencyConvert_null() {
        assertEquals(convert(nullInput, nullInput), 0);
    }
}
