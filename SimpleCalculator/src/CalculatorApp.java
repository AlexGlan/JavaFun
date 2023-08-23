import javax.swing.SwingUtilities;

public class CalculatorApp {
    public static void main(String[] args) {   
        SwingUtilities.invokeLater(() -> {
            UI ui = new UI();
            new Logic(ui);
        });
    }    
}