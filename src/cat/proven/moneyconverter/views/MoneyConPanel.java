package cat.proven.moneyconverter.views;

import cat.proven.moneyconverter.controller.MoneyConverterController;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Daniel
 */

public class MoneyConPanel extends JPanel {

    private final MoneyConverterController controller;

    private JTextField txtStartValue;
    private JTextField txtFinalValue;

    private JButton CalculateButton;
    private JButton ClearButton;

    private JComboBox currBox1;
    private JComboBox currBox2;

    //public TempConPanel(TempConMainFrame parent) {
    public MoneyConPanel(MoneyConverterController controller) {
        this.controller = controller;
        initComponents();
    }

    private void initComponents() {

        //We create an object which will contain all aour currencies
        //Later, they will be shown on our JComboBox
        Object[] Currencies = controller.getCurrencyRatesMap().keySet().toArray();

        currBox1 = new JComboBox(Currencies);
        currBox1.setSelectedIndex(0);
        currBox1.addActionListener(controller);
        currBox2 = new JComboBox(Currencies);
        currBox2.setSelectedIndex(1);
        currBox2.addActionListener(controller);
        txtStartValue = new JTextField(20);
        txtFinalValue = new JTextField(20);
        CalculateButton = new JButton("Calculate");
        CalculateButton.setActionCommand("calc");
        CalculateButton.addActionListener(controller);
        ClearButton = new JButton("Clear");
        ClearButton.setActionCommand("clearconpanel");
        ClearButton.addActionListener(controller);

        setLayout(new GridLayout(3, 2));
        add(currBox1);add(txtStartValue);
        add(currBox2);add(txtFinalValue);
        add(CalculateButton);add(ClearButton);

    }

    public String getStartCurrency() {

        return currBox1.getSelectedItem().toString();
    }

    public String getFinalCurrency() {

        return currBox2.getSelectedItem().toString();
    }

    public JTextField getStartCurrencyValue() {
        return txtStartValue;
    }

    public JTextField getFinalCurrencyValue() {
        return txtFinalValue;
    }

    /**
     * Clears the values introduced on Start and Final txtBoxes
     */
    public void clear() {

        txtStartValue.setText(null);
        txtFinalValue.setText(null);

    }

}
