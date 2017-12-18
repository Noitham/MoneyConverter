package cat.proven.moneyconverter.views;

import cat.proven.moneyconverter.controller.MoneyConverterController;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Daniel
 */

public class MoneyValuesPanel extends JPanel implements ActionListener {

    private Map<String, Double> currencyRates;

    private final MoneyConverterController controller;

    private JButton SaveButton;
    private JButton ClearButton;
    String contenido;
    ArrayList<String> Value = new ArrayList<>();
    ArrayList<String> Key = new ArrayList<>();

    private JComboBox currenciesBox;
    private JTextField valuetxt;

    private JLabel Basecurrtxt;
    private JLabel Basecurrvalue;

    //public TempConPanel(TempConMainFrame parent) {
    public MoneyValuesPanel(MoneyConverterController controller) {
        this.controller = controller;
        initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("cambio")) {
            getValueText();
        }

    }

    private void initComponents() {

        Object[] Currencies = controller.getCurrencyRatesMap().keySet().toArray();

        currenciesBox = new JComboBox(Currencies);
        currenciesBox.setSelectedIndex(0);
        currenciesBox.setActionCommand("cambio");
        currenciesBox.addActionListener(this);

        Basecurrtxt = new JLabel("1 Euro (€)");

        Basecurrvalue = new JLabel("1.0");

        SaveButton = new JButton("Save Values");
        SaveButton.setActionCommand("set");
        SaveButton.addActionListener(controller);
        ClearButton = new JButton("Clear");
        ClearButton.setActionCommand("clearvaluespanel");
        ClearButton.addActionListener(controller);

        currencyRates = controller.getCurrencyRatesMap();

        valuetxt = new JTextField("");

        currencyRates.entrySet().stream().map((Map.Entry<String, Double> e) -> e).forEachOrdered((Map.Entry<String, Double> e) -> {

            Key.add(e.getKey());
            Value.add(e.getValue().toString());

            if (e.getKey().equals(currenciesBox.getSelectedItem().toString())) {

                contenido = e.getValue().toString();
                valuetxt.setText(contenido);

            }

        });

        setLayout(new GridLayout(3, 2));
        add(Basecurrtxt);add(Basecurrvalue);
        add(currenciesBox);add(valuetxt);
        add(SaveButton);add(ClearButton);

    }
    
    public void getValueText() {

        for (int i = 0; i < currencyRates.size(); i++) {

            if (currenciesBox.getSelectedItem().equals(Key.get(i))) {

                valuetxt.setText(Value.get(i));
                add(valuetxt);
            }
        }

    }

    /**
     * Clears the introduced values
     */
    public void clear() {

        valuetxt.setText(null);
    }

    public Map<String, Double> getValues() {

        String currency = currenciesBox.getSelectedItem().toString();
        Double value = Double.parseDouble(valuetxt.getText());
        currencyRates.replace(currency, value);

        return currencyRates;
    }

    

}
