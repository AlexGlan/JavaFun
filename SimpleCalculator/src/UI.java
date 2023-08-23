import java.awt.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class UI extends JFrame {
    Logic logic;
    JLabel label;
    JTextField textField;
    JPanel panel;
    JButton[] numButtons = new JButton[10];
    JButton[] funButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, remButton;
    JButton decButton, equButton, clrButton, negButton, delButton;
    Font funButtonFont = new Font("Roboto", Font.BOLD, 25);
    Font numButtonFont = new Font("Roboto", Font.PLAIN, 24);
    Color clrAccent = new Color(255, 105, 70);
    Color clrPrimary = new Color(46, 66, 75);
    Color clrGray = new Color(150, 150, 150);

    public UI() {
        logic = new Logic(this);
        // Frame properties
        setTitle("Calculator App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 510);
        setLayout(null);
        setResizable(false);
        // Label properties
        label = new JLabel();
        label.setFont(new Font("Sans-Serif", Font.ITALIC, 18));
        label.setForeground(new Color(90, 90, 90));
        label.setOpaque(false);
        label.setBounds(22, 80, 280, 35);
        label.setHorizontalAlignment(JTextField.RIGHT);
        // Textfield properties
        textField = new JTextField();
        textField.setFont(new Font("Roboto", Font.PLAIN, 52));
        textField.setForeground(clrPrimary);
        textField.setOpaque(false);
        textField.setBorder(BorderFactory.createEmptyBorder());
        textField.setBounds(25, 105, 280, 80);
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        logic.putPlaceholder();
        // Panel properties
        panel = new JPanel();
        panel.setBounds(20, 200, 300, 250);
        panel.setLayout(new GridLayout(5, 4, 5, 5));
        // Button configuration
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        remButton = new JButton("%");
        decButton = new JButton(".");
        equButton = new JButton("=");
        clrButton = new JButton("C");
        negButton = new JButton("+/-");
        delButton = new JButton("CE");
        
        funButtons[0] = addButton;
        funButtons[1] = subButton;
        funButtons[2] = mulButton;
        funButtons[3] = divButton;
        funButtons[4] = remButton;
        funButtons[5] = decButton;        
        funButtons[6] = equButton;
        funButtons[7] = clrButton;
        funButtons[8] = negButton;
        funButtons[9] = delButton;

        for (int btn = 0; btn < funButtons.length; btn++) {
            logic.addButtonListener(funButtons[btn]);
            funButtons[btn].setFont(funButtonFont);
            if (funButtons[btn].getText().equals("=")) {
                funButtons[btn].setBackground(clrAccent);
                funButtons[btn].setForeground(new Color(254, 254, 254));
                funButtons[btn].setFocusable(false);                
                funButtons[btn].setBorderPainted(false);
            } else { 
                funButtons[btn].setBackground(new Color(0, 0, 0, 0));
                funButtons[btn].setForeground(clrPrimary);
                funButtons[btn].setContentAreaFilled(false);
                funButtons[btn].setFocusable(false);
                funButtons[btn].setBorderPainted(false);              
            }
            if (funButtons[btn].getText().matches("[\\+\\-\\*/]")) {
                funButtons[btn].setForeground(clrAccent);
            }
        }

        for (int btn = 0; btn < numButtons.length; btn++) {
            numButtons[btn] = new JButton(String.valueOf(btn));            
            logic.addButtonListener(numButtons[btn]);
            numButtons[btn].setFont(numButtonFont);
            numButtons[btn].setFocusable(false);
            numButtons[btn].setBackground(new Color(0, 0, 0, 0));
            numButtons[btn].setContentAreaFilled(false);
            numButtons[btn].setBorderPainted(false);
            numButtons[btn].setForeground(clrPrimary);
        }
        // Add components to panel
        // 1st row
        panel.add(clrButton);
        panel.add(delButton);
        panel.add(remButton);
        panel.add(divButton);
        // 2nd row
        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(mulButton);
        // 3rd row
        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);
        // 4th row
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(addButton);
        // 5th row
        panel.add(negButton);
        panel.add(numButtons[0]);
        panel.add(decButton);
        panel.add(equButton);

        // Add components to frame
        add(label);
        add(panel);
        add(textField);
        // hide the caret
        textField.setCaret(new DefaultCaret() {
            @Override
            public void setVisible(boolean visible) {
                //
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JButton[] getNumButtons() {
        return numButtons;
    }
}