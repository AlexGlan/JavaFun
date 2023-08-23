import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logic {
    UI ui;    
    private double num1 = 0, num2 = 0, result = 0;
    private DecimalFormat numberFormat = new DecimalFormat("#.0");
    private char operator;
    private ArrayList<String> history = new ArrayList<String>();

    public Logic(UI ui) {
        this.ui = ui;
    }

    public void putPlaceholder() {
        ui.textField.setText("0");
        ui.textField.setForeground(ui.clrGray);
    }

    public void removePlaceholder() {
        ui.textField.setText("");
        ui.textField.setForeground(ui.clrPrimary);
    }

    public void addHistory(double num1, char operator) {
        if (history.size() == 0) {
            history.add(String.valueOf(numberFormat.format(num1)));
            history.add(String.valueOf(operator));  
        } else {
            history.set(0, String.valueOf(numberFormat.format(num1)));
            history.set(1, String.valueOf(operator));
        }        
        ui.label.setText(history.get(0) + " " + history.get(1));
    }

    public void addHistory(double num1, char operator, double num2) {
        history.set(0, String.valueOf(numberFormat.format(num1)));
        history.set(1, String.valueOf(operator));
        history.add(String.valueOf(numberFormat.format(num2)));
        ui.label.setText(history.get(0) + " " + history.get(1) + " " + history.get(history.size() -1) + " = ");
    }

    public void clearHistory() {
        history.clear();
        ui.label.setText("");
    }

    public void addButtonListener(JButton btn) {
            btn.addActionListener(new ButtonListener());
        }

    public class ButtonListener implements ActionListener {             
        @Override
        public void actionPerformed(ActionEvent e) {
            JTextField textField = ui.getTextField();
            JButton[] numButtons = ui.getNumButtons();
            // number buttons:
            for (int i = 0; i < numButtons.length; i++) {
                if (e.getSource() == numButtons[i]) {
                    if (textField.getText().equals("0")) {
                        removePlaceholder();                    
                    }
                    textField.setText(textField.getText().concat(String.valueOf(i)));
                    ui.setTextField(textField);            
                }
            }
            // function buttons:
            if (e.getSource() == ui.addButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                putPlaceholder();
                addHistory(num1, operator);       
            }

            if (e.getSource() == ui.subButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                putPlaceholder();
                addHistory(num1, operator);
            }

            if (e.getSource() == ui.mulButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                putPlaceholder();
                addHistory(num1, operator);
            }

            if (e.getSource() == ui.divButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                putPlaceholder();
                addHistory(num1, operator);
            }

            if (e.getSource() == ui.remButton) {
                num1 = Double.parseDouble(textField.getText());
                operator = '%';
                putPlaceholder();
                addHistory(num1, operator);
            }
            // put decimals
            if (e.getSource() == ui.decButton) {
                textField.setText(textField.getText().concat("."));
                ui.setTextField(textField);
            }
            // calculate result
            if (e.getSource() == ui.equButton) {
                num2 = Double.parseDouble(textField.getText());            
                switch(operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;                
                    case '/':
                        result = num1 / num2;
                        break;                
                    case '%':
                        result = num1 % num2;
                        break;                
                }
                textField.setText(String.valueOf(numberFormat.format(result)));
                ui.setTextField(textField);
                addHistory(num1, operator, num2);
                num1 = result;
            }
            // clear all numbers from textfield and history
            if (e.getSource() == ui.clrButton) {
                textField.setText("");
                ui.setTextField(textField);
                clearHistory();
                putPlaceholder();
            }
            // delete last digit
            if (e.getSource() == ui.delButton) {
                String str = textField.getText();
                textField.setText("");
                for (int i = 0; i < str.length() - 1; i++) {
                    textField.setText(textField.getText() + str.charAt(i));
                    ui.setTextField(textField);
                }   
            }
            // negate number
            if (e.getSource() == ui.negButton) {
                double n = Double.parseDouble(textField.getText()) * -1;
                textField.setText(String.valueOf(n));
                ui.setTextField(textField);
            }
        }
    }
}