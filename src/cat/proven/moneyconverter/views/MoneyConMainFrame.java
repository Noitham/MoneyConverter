package cat.proven.moneyconverter.views;

import cat.proven.moneyconverter.controller.MoneyConverterController;
import cat.proven.moneyconverter.model.MoneyConverterModel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 *
 * @author Daniel
 */
public final class MoneyConMainFrame extends JFrame {

    private final MoneyConverterModel model;
    private JMenuBar menuBar;
    private MoneyConPanel moneyConPanel;
    private MoneyValuesPanel moneyValuesPanel;
    private WelcomePanel welcomePanel;

    private final MoneyConverterController controller;

    private final String aboutMessage;

    public MoneyConMainFrame(MoneyConverterModel model, MoneyConverterController controller) {
        this.controller = controller;
        this.model = model;
        aboutMessage = "<html><p>Currency converter application</p><p>(c) DanielSoft 2017</p></html>";
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Currency Converter Application");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                exitApplication();
            }
        });

        this.menuBar = buildMenuBar();
        this.setJMenuBar(menuBar);

        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        welcomePanel = new WelcomePanel(controller);
        pane.add(welcomePanel, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setSize(400, 300);
        this.setVisible(true);
    }

    public JMenuBar buildMenuBar() {
        JMenuBar mnBar = new JMenuBar();
        JMenu mnu;
        JMenuItem mItem;

        // FileMenu
        mnu = new JMenu("File");
        mItem = new JMenuItem("Exit");
        mItem.setActionCommand("exit");
        mItem.addActionListener(controller);
        mnu.add(mItem);
        mnBar.add(mnu);

        // Edit Menu
        mnu = new JMenu("Edit");
        mItem = new JMenuItem("Calculate");
        mItem.setActionCommand("conpanel");
        mItem.addActionListener(controller);
        mnu.add(mItem);

        mItem = new JMenuItem("Set Values");
        mItem.setActionCommand("setvaluespanel");
        mItem.addActionListener(controller);
        mnu.add(mItem);

        // Help Menu
        mnBar.add(mnu);
        mnu = new JMenu("Help");
        mItem = new JMenuItem("About");
        mItem.setActionCommand("about");
        mItem.addActionListener(controller);
        mnu.add(mItem);
        mnBar.add(mnu);

        return mnBar;
    }

    /**
     * Asks for confirmation and exits application
     */
    public void exitApplication() {
        int choice = JOptionPane.showConfirmDialog(this, "Would you like to close the application");
        if (choice == JOptionPane.OK_OPTION) {
            System.exit(0);
        } else if (choice == JOptionPane.OK_CANCEL_OPTION) {

        }

        System.out.println("Exitting app");

    }

    /**
     * Shows aboutDialogue
     */
    public void aboutDialogue() {

        JOptionPane.showMessageDialog(this, aboutMessage);

    }

    /**
     * Sets ValuesPanel
     */
    public void setValuesPanel() {

        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        moneyValuesPanel = new MoneyValuesPanel(controller);

        this.setContentPane(moneyValuesPanel);
        this.validate();

    }

    public MoneyValuesPanel getValuesPanel() {
        return moneyValuesPanel;
    }

    /**
     * Sets ConverionPanel
     */
    public void setConPanel() {

        Container pane = this.getContentPane();
        pane.setLayout(new BorderLayout());
        moneyConPanel = new MoneyConPanel(controller);

        this.setContentPane(moneyConPanel);
        this.validate();
    }

    public MoneyConPanel getConPanel() {
        return moneyConPanel;
    }

    /**
     * Clears moneyValuesPanel content
     */
    public void clearValuesPanel() {

        moneyValuesPanel.clear();

    }

    /**
     * Clears moneyConPanel content
     */
    public void clearConPanel() {

        moneyConPanel.clear();

    }

}
