package cat.proven.moneyconverter.views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
class WelcomePanel extends JPanel {

    private JButton LaunchButton;
    private final ActionListener al;

    //public TempConPanel(TempConMainFrame parent) {
    public WelcomePanel(ActionListener al) {
        this.al = al;
        initComponents();
    }

    private void initComponents() {
        JLabel lblWelcome = new JLabel("Welcome to our Currency Calculator");
        LaunchButton = new JButton("Launch application");
        LaunchButton.setActionCommand("launchapp");
        LaunchButton.addActionListener(al);

        setLayout(new GridLayout(4, 2));
        add(lblWelcome);add(new JLabel(""));
        add(LaunchButton);

    }
}
