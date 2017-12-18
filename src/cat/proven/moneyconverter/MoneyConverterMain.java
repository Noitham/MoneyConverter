package cat.proven.moneyconverter;

import cat.proven.moneyconverter.controller.MoneyConverterController;
import cat.proven.moneyconverter.model.MoneyConverterModel;

public class MoneyConverterMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new RunnableImpl());
    }

    private static class RunnableImpl implements Runnable {

        public RunnableImpl() {
        }

        @Override
        public void run() {
            MoneyConverterModel model = new MoneyConverterModel();
            MoneyConverterController moneyConverterController = new MoneyConverterController(model);
        }
    }

}
