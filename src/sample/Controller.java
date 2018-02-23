package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class Controller {

    private String string1 = "";
    private String string2 = "";
    private String string3 = "";
    Boolean error = false;

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;

    private void showStrings() {
        if (!error) {
            label1.setText(string1);
            label2.setText(string2);
            label3.setText(string3);
            if (string3.equals("Infinity") || string3.equals("NaN")) error = true;
        }
    }

    public void press1() {
        adding("1");
    }

    public void press2() {
        adding("2");
    }

    public void press3() {
        adding("3");
    }

    public void press4() {
        adding("4");
    }

    public void press5() {
        adding("5");
    }

    public void press6() {
        adding("6");
    }

    public void press7() {
        adding("7");
    }

    public void press8() {
        adding("8");
    }

    public void press9() {
        adding("9");
    }

    public void press0() {
        adding("0");
    }

    public void pressPoint() {
        if (!string3.contains(".")) adding(".");
    }

    public void pressPlus() {
        sign("+");
    }

    public void pressMinus() {
        sign("-");
    }

    public void pressDivide() {
        sign("/");
    }

    public void pressMultiply() {
        sign("*");
    }

    private void sign(String s) {
        if (!string3.equals("")) {
            schet();
            string1 = string3;
            string3 = "";
        }
        string2 = s;
        showStrings();
    }

    public void pressEqual() {
        if (!string3.equals("")) {
            schet();
            string2 = "=";
            string1 = "";
        }
        showStrings();
    }

    private void schet() {
        if (!string1.equals("")) {
            switch (string2) {
                case "+":
                    string3 = String.valueOf(Double.valueOf(string1) + Double.valueOf(string3));
                    break;
                case "-":
                    string3 = String.valueOf(Double.valueOf(string1) - Double.valueOf(string3));
                    break;
                case "/":
                    string3 = String.valueOf(Double.valueOf(string1) / Double.valueOf(string3));
                    break;
                case "*":
                    string3 = String.valueOf(Double.valueOf(string1) * Double.valueOf(string3));
                    break;
            }
        }
        cutEnd();
    }

    private void cutEnd() {
        if (string3.length() > 2) {
            if (string3.substring(string3.length() - 2, string3.length()).equals(".0"))
                string3 = string3.substring(0, string3.length() - 2);
        }
    }

    public void pressChange() {
        if (!error) string3 = String.valueOf(-Double.valueOf(string3));
        cutEnd();
        showStrings();
    }

    public void pressClear() {
        string1 = "";
        string2 = "";
        string3 = "";
        error = false;
        showStrings();
    }

    public void pressClearLast() {
        if (string3.length() > 0) string3 = string3.substring(0, string3.length() - 1);
        showStrings();
    }

    private void adding(String s) {
        if (string2.equals("=")) {
            string2 = "";
            string3 = "";
        }
        if (string3.length() < 25 && !error) string3 += s;
        showStrings();
    }

    public void keyPress(KeyEvent event) {
        switch (event.getCode()) {
            case NUMPAD1:
                press1();
                break;
            case NUMPAD2:
                press2();
                break;
            case NUMPAD3:
                press3();
                break;
            case NUMPAD4:
                press4();
                break;
            case NUMPAD5:
                press5();
                break;
            case NUMPAD6:
                press6();
                break;
            case NUMPAD7:
                press7();
                break;
            case NUMPAD8:
                press8();
                break;
            case NUMPAD9:
                press9();
                break;
            case NUMPAD0:
                press0();
                break;
            case DECIMAL:
                pressPoint();
                break;
            case ADD:
                pressPlus();
                break;
            case SUBTRACT:
                pressMinus();
                break;
            case MULTIPLY:
                pressMultiply();
                break;
            case DIVIDE:
                pressDivide();
                break;
            case ESCAPE:
                pressClear();
                break;
            case BACK_SPACE:
                pressClearLast();
                break;
            case CONTROL:
                pressChange();
                break;
            case ENTER:
                pressEqual();
                break;
        }
    }
}
