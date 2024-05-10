package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TextField txt_result;

    String op = "";
    long number1;
    long number2;

    // click CTRL
    // First Method
    public void Number (ActionEvent ae) {

        String no = ((Button) ae.getSource()).getText();
        txt_result.setText(txt_result.getText()+no);

    }

    // Second Method
    public void Operation (ActionEvent ae) {

        String operation = ((Button) ae.getSource()).getText();
        if (!operation.equals("=")) {
            if (!op.equals("")) {
                return;
            }
            op = operation;
            number1 = Long.parseLong(txt_result.getText());
            txt_result.setText("");
        } else {

            if (op.equals("")) {
                return;
            }
            number2 = Long.parseLong(txt_result.getText());
            // create 3 Method calculate
            calculate(number1, number2, op);
            op="";
        }
    }

    // 3 Methods
    public void calculate (long n1, long n2, String op) {
        switch (op) {
            case "+" : txt_result.setText(n1 + n2 + ""); break;
            case "-" : txt_result.setText(n1 - n2 + ""); break;
            case "x" : txt_result.setText(n1 * n2 + ""); break;
            case "/" :
                if (n2 == 0) {
                    txt_result.setText("0"); break;
                } else if (n1 % n2 != 0){
                    txt_result.setText((double) n1 / n2 + ""); break;
                } else {
                    txt_result.setText(n1 / n2 + ""); break;
                }
        }
    }

    @FXML
    void onClearBtnClick(ActionEvent event) {
        txt_result.setText("");
    }

    @FXML
    void onDelBtnClick(ActionEvent event) {
        String result = txt_result.getText();
        txt_result.setText("");
        for (int i = 0; i < result.length()-1; i++) {
            txt_result.setText(txt_result.getText() + result.charAt(i));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}