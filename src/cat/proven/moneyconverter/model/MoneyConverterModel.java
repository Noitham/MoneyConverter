package cat.proven.moneyconverter.model;

import cat.proven.moneyconverter.views.MoneyValuesPanel;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



/**
 *
 * @author Daniel
 */

public final class MoneyConverterModel {

    Map<String, Double> currencyMap;

    public MoneyValuesPanel myPanel;

    public MoneyConverterModel() {
        currencyMap = new HashMap<>();
        setCurrencyMap();
    }

    /**
     * Here we add currencies to our currencyMap
     */
    public void setCurrencyMap() {
        currencyMap.put("Euro (€)", 1.0);
        currencyMap.put("Dollar ($)", 1.18414);
        currencyMap.put("Pound (£)", 0.8851);
        currencyMap.put("Yen", 132.0847);
        currencyMap.put("DKK", 7.44447);
        
    }

    //Getter (for our currencies Keys)
    public Set<String> getCurrencies() {
        return currencyMap.keySet();
    }

    //Setter
    public void setCurrencyMap(Map<String, Double> currencyMap) {
        this.currencyMap = currencyMap;
    }

    //Getter
    public Map<String, Double> getCurrencyMap() {
        return currencyMap;
    }

    /**
     * We put a new currency to our currencyMap
     *
     * @param currency
     * @param value
     */
    public void addCurrency(String currency, Double value) {
        currencyMap.put(currency, value);
    }

    /**
     * We set the rate of a currency
     *
     * @param currency
     * @param value
     */
    public void setCurrency(String currency, Double value) {
        currencyMap.replace(currency, value);
    }

    /**
     * We convert our money from start currency to the desired currency
     *
     * @param start
     * @param result
     * @param startQuantity
     * @return finalQuantity, which is our result.
     */
    public Double convert(String start, String result, Double startQuantity) {
        Double finalQuantity;
        Double startRate;
        Double resultRate;

        startRate = currencyMap.get(start);
        resultRate = currencyMap.get(result);

        finalQuantity = (startQuantity * (resultRate / startRate));

        return finalQuantity;

    }

}
