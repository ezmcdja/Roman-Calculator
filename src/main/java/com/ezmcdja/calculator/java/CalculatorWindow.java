package com.ezmcdja.calculator.java;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorWindow {

    private JFrame frmRomanAdditionCalculator;
    private JButton btnEquals;
    private JButton btnClear;
    private JTextField inputField;
    private JTextField resultField;

    private char operator;
    private JTextField decimalField;

    /**
     * Launch the application.
     */
    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CalculatorWindow().frmRomanAdditionCalculator.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public CalculatorWindow() {
        initialize();
        operator = 0;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        initialiseFrame();
        final JPanel outerPanel = initialiseOuterPanel();
        final JPanel resultFieldPanel = initialiseResultFieldPanel(outerPanel);
        initialiseResultField(resultFieldPanel);
        final JPanel inputFieldPanel = initialiseInputFieldPanel(outerPanel);
        initialiseInputField(inputFieldPanel);
        final JPanel numbersPanel = initialiseNumbersPanel(outerPanel);
        final JPanel operatorsPanel = initialiseOperatorsPanel(outerPanel);
        final JPanel equalsPanel = initialiseEqualsPanel(outerPanel);
        final JPanel clearPanel = initialiseClearPanel(outerPanel);
        populateNumbersPanel(numbersPanel);
        initialiseInputButton(operatorsPanel, " + ");
        initialiseEqualsButton(equalsPanel);
        initialiseClearButton(clearPanel);
    }

    private void populateNumbersPanel(final JPanel numbersPanel) {
        initialiseInputButton(numbersPanel, "M");
        initialiseInputButton(numbersPanel, "D");
        initialiseInputButton(numbersPanel, "C");
        initialiseInputButton(numbersPanel, "L");
        initialiseInputButton(numbersPanel, "X");
        initialiseInputButton(numbersPanel, "V");
        initialiseBlankPanel(numbersPanel);
        initialiseInputButton(numbersPanel, "I");
    }

    private void initialiseInputButton(final JPanel aPanel, final String text) {
        final JButton aButton = new JButton(text);
        aButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent event) {
                inputCharacterFrom(aButton);
                if (aButton.getText().equals(" + ")) {
                    operator = '+';
                }
            }
        });
        aButton.setFont(new Font("Arial", Font.BOLD, 30));
        aPanel.add(aButton);
    }

    private void initialiseClearButton(final JPanel clearPanel) {
        btnClear = new JButton("C");
        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent event) {
                inputField.setText("");
                resultField.setText("");
                decimalField.setText("");
                decimalField.setFont(new Font("Tahoma", Font.PLAIN, 11));
                decimalField.setBackground(new Color(240, 240, 240));
                operator = 0;
            }
        });
        btnClear.setFont(new Font("Arial", Font.BOLD, 30));
        btnClear.setForeground(Color.RED);
        clearPanel.add(btnClear);
    }

    private void initialiseEqualsButton(final JPanel equalsPanel) {
        btnEquals = new JButton("=");
        btnEquals.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent event) {
                if (operator == '+') {
                    add();
                }
            }
        });
        btnEquals.setFont(new Font("Arial", Font.BOLD, 30));
        equalsPanel.add(btnEquals);
    }

    private void initialiseBlankPanel(final JPanel numbersPanel) {
        final JPanel blankPanel = new JPanel();
        numbersPanel.add(blankPanel);
    }

    private JPanel initialiseClearPanel(final JPanel outerPanel) {
        final JPanel clearPanel = new JPanel();
        clearPanel.setBounds(344, 278, 183, 62);
        outerPanel.add(clearPanel);
        clearPanel.setLayout(new GridLayout(0, 1, 0, 0));
        return clearPanel;
    }

    private JPanel initialiseEqualsPanel(final JPanel outerPanel) {
        final JPanel equalsPanel = new JPanel();
        equalsPanel.setBounds(344, 489, 183, 62);
        outerPanel.add(equalsPanel);
        equalsPanel.setLayout(new GridLayout(0, 1, 0, 0));
        return equalsPanel;
    }

    private JPanel initialiseOperatorsPanel(final JPanel outerPanel) {
        final JPanel operatorsPanel = new JPanel();
        operatorsPanel.setBounds(354, 351, 165, 127);
        outerPanel.add(operatorsPanel);
        operatorsPanel.setLayout(new GridLayout(1, 2, 0, 0));
        return operatorsPanel;
    }

    private JPanel initialiseNumbersPanel(final JPanel outerPanel) {
        final JPanel numbersPanel = new JPanel();
        numbersPanel.setBounds(17, 258, 300, 300);
        outerPanel.add(numbersPanel);
        numbersPanel.setLayout(new GridLayout(3, 3, 0, 0));
        return numbersPanel;
    }

    private void initialiseInputField(final JPanel inputFieldPanel) {
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(510, 40));
        inputField.setMinimumSize(new Dimension(510, 20));
        inputField.setHorizontalAlignment(SwingConstants.RIGHT);
        inputField.setFont(new Font("Arial", Font.BOLD, 30));
        inputField.setEnabled(false);
        inputField.setDisabledTextColor(Color.BLACK);
        inputField.setColumns(10);
        inputField.setBackground(Color.WHITE);
        inputField.setBounds(10, 1, 490, 40);
        inputFieldPanel.add(inputField);
    }

    private JPanel initialiseInputFieldPanel(final JPanel outerPanel) {
        final JPanel inputFieldPanel = new JPanel();
        inputFieldPanel.setBounds(17, 74, 510, 42);
        inputFieldPanel.setLayout(null);
        inputFieldPanel.setPreferredSize(new Dimension(510, 42));
        inputFieldPanel.setName("");
        inputFieldPanel.setMinimumSize(new Dimension(510, 10));
        outerPanel.add(inputFieldPanel);
        return inputFieldPanel;
    }

    private void initialiseResultField(final JPanel resultFieldPanel) {
        resultField = new JTextField();
        resultField.setEnabled(false);
        resultField.setHorizontalAlignment(SwingConstants.CENTER);
        resultField.setBounds(10, 1, 490, 40);
        resultField.setMinimumSize(new Dimension(510, 20));
        resultField.setPreferredSize(new Dimension(510, 40));
        resultField.setDisabledTextColor(Color.BLACK);
        resultField.setBackground(Color.WHITE);
        resultField.setColumns(10);
        resultField.setFont(new Font("Arial", Font.BOLD, 30));
        resultFieldPanel.add(resultField);
    }

    private JPanel initialiseResultFieldPanel(final JPanel outerPanel) {
        final JPanel resultFieldPanel = new JPanel();
        resultFieldPanel.setBounds(17, 21, 510, 42);
        resultFieldPanel.setName("");
        resultFieldPanel.setMinimumSize(new Dimension(510, 10));
        resultFieldPanel.setPreferredSize(new Dimension(510, 42));
        outerPanel.add(resultFieldPanel);
        resultFieldPanel.setLayout(null);
        return resultFieldPanel;
    }

    private JPanel initialiseOuterPanel() {
        final JPanel outerPanel = new JPanel();
        frmRomanAdditionCalculator.getContentPane().add(outerPanel, BorderLayout.CENTER);
        outerPanel.setLayout(null);
        final JPanel decimalPanel = initialiseDecimalPanel(outerPanel);
        initialiseDecimalField(decimalPanel);
        return outerPanel;
    }

    private void initialiseDecimalField(final JPanel decimalPanel) {
        decimalField = new JTextField();
        decimalField.setPreferredSize(new Dimension(510, 40));
        decimalField.setMinimumSize(new Dimension(510, 20));
        decimalField.setHorizontalAlignment(SwingConstants.CENTER);
        decimalField.setEnabled(false);
        decimalField.setBackground(new Color(240, 240, 240));
        decimalField.setDisabledTextColor(Color.BLACK);
        decimalField.setColumns(10);
        decimalField.setBounds(10, 1, 490, 40);
        decimalPanel.add(decimalField);
    }

    private JPanel initialiseDecimalPanel(final JPanel outerPanel) {
        final JPanel decimalPanel = new JPanel();
        decimalPanel.setLayout(null);
        decimalPanel.setPreferredSize(new Dimension(510, 42));
        decimalPanel.setName("");
        decimalPanel.setMinimumSize(new Dimension(510, 10));
        decimalPanel.setBounds(17, 127, 510, 42);
        outerPanel.add(decimalPanel);
        return decimalPanel;
    }

    private void initialiseFrame() {
        frmRomanAdditionCalculator = new JFrame();
        frmRomanAdditionCalculator.setTitle("Roman Addition Calculator");
        frmRomanAdditionCalculator.setBounds(650, 250, 560, 600);
        frmRomanAdditionCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inputCharacterFrom(final JButton aButton) {
        if (aButton.getText().equals(" + ") & operator == '+' & inputField.getText().lastIndexOf(" + ") == inputField.getText().length() - 3) {
        } else {
            inputField.setText(inputField.getText() + aButton.getText());
        }
    }

    private void add() {
        final String[] input = inputField.getText().split("[+]");
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i].trim();
        }
        try {
            final NumberConverter converter = new NumberConverter();
            final String[] results;
            for (final String operand : input) {
                converter.validateRomanNumber(operand);
            }
            results = RomanAdder.romanAdd(input);
            separateResultsAndDisplay(results);
        } catch (IllegalArgumentException iae) {
            displayInvalidNumberMessage(iae);
        }
    }

    private void displayInvalidNumberMessage(final IllegalArgumentException iae) {
        decimalField.setBackground(Color.RED);
        decimalField.setFont(new Font("Arial", Font.BOLD, 30));
        decimalField.setText(iae.getMessage());
    }

    private void separateResultsAndDisplay(final String[] results) {
        final String decimalOperands = results[0];
        final String decimalResult = results[1];
        final String additionResult = results[2];
        resultField.setText(additionResult);

        decimalField.setFont(new Font("Tahoma", Font.PLAIN, 11));
        decimalField.setBackground(new Color(240, 240, 240));
        decimalField.setText("(" + decimalOperands + " = " + decimalResult + ")");
    }
}
