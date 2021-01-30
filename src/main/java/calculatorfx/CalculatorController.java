package calculatorfx;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CalculatorController {
    public TextField output;
    private String operation;
    private long leftOperand;

    public void inputDigit(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        output.appendText(button.getText());
    }

    public void calculate(ActionEvent actionEvent) {
        calculate();
    }

    private void calculate() {
        long rightOperand = Long.parseLong(output.getText());
        switch (operation) {
            case "+":
                output.setText(String.valueOf(leftOperand + rightOperand));
                break;
            case "-":
                output.setText(String.valueOf(leftOperand - rightOperand));
                break;
            case "*":
                output.setText(String.valueOf(leftOperand * rightOperand));
                break;
            case "/":
                output.setText(String.valueOf(leftOperand / rightOperand));
                break;
        }
    }

    public void operate(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        operate(button.getText());
    }

    private void operate(String operation) {
        this.operation = operation;
        leftOperand = Long.parseLong(output.getText());
        clear();
    }

    public void clear(ActionEvent actionEvent) {
        clear();
    }

    private void clear() {
        output.clear();
    }

    public void keyLesten(KeyEvent keyEvent) {
//        char ch = keyEvent.getText().charAt(0);
//        if (ch >= '0' && ch <= '9') {
//            output.appendText(keyEvent.getText());
//        } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
//            operate(keyEvent.getText());
//        } else if (ch == '=') {
//            calculate();
//        }
       String str = keyEvent.getText();
        if (str.matches("[0-9]")) {
            output.appendText(keyEvent.getText());
        } else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            operate(keyEvent.getText());
        } else if (str.equals("=")) {
            calculate();
        }
    }
}
