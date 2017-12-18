/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.moneyconverter.controller;

import cat.proven.moneyconverter.views.MoneyConMainFrame;
import cat.proven.moneyconverter.model.MoneyConverterModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 *
 * @author Daniel
 */
public class MoneyConverterController implements ActionListener {

    //We call model and view
    private final MoneyConverterModel model;
    private MoneyConMainFrame view;

    public MoneyConverterController(MoneyConverterModel model) {
        this.model = model;
        MoneyConverterController controller = this;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                controller.view = new MoneyConMainFrame(model, controller);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        processAction(action);
    }

    private void processAction(String action) {
        if (action != null) {
            switch (action) {
                case "exit":
                    // Exit
                    view.exitApplication();
                    break;
                case "clearconpanel":
                    // Neteja
                    view.clearConPanel();
                    break;
                case "clearvaluespanel":
                    // Neteja
                    view.clearValuesPanel();
                    break;
                case "launchapp":
                    // Shows values panel
                    view.setConPanel();
                    break;
                case "setvaluespanel":
                    // Shows values panel
                    view.setValuesPanel();
                    break;
                case "conpanel":
                    // Shows converter panel
                    view.setConPanel();
                    break;
                case "calc":
                    // Calculate
                    Convert();
                    break;
                case "about":
                    // About
                    view.aboutDialogue();
                    break;
                case "set":
                    setValues();
                    break;
                default:
                    break;
            }
            System.out.println("Execution action: " + action);
        }
    }

    public Map<String, Double> getCurrencyRatesMap() {
        Map<String, Double> currencyMap;
        currencyMap = model.getCurrencyMap();

        return currencyMap;
    }

    public void Convert() {
        String StartCurrency;
        String FinalCurrency;
        Double startQuantity;
        Double finalQuantity;

        StartCurrency = view.getConPanel().getStartCurrency();
        FinalCurrency = view.getConPanel().getFinalCurrency();
        startQuantity = Double.parseDouble((view.getConPanel().getStartCurrencyValue()).getText());
        finalQuantity = model.convert(StartCurrency, FinalCurrency, startQuantity);
        view.getConPanel().getFinalCurrencyValue().setText(finalQuantity.toString());
    }

    /**
     * Sets the values from currencies, given by MoneyValuesPanel
     */
    public void setValues() {
        Map<String, Double> values;
        values = view.getValuesPanel().getValues();
        model.setCurrencyMap(values);
    }
    

}
