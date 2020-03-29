package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    ArrayList<String> arrayList = new ArrayList<>();
    boolean condition = false, condition1 = true;
    String expression;char type='D';
    @FXML
    Label answer, history;
    @FXML
    Button sin, tan, cos, fact, pi, ln, Inverse, e, log, equal;
    @FXML
    RadioButton Scientific, Standard, Degree, Radian;
    @FXML
    TextField box;
    int x=0;
    @FXML
    protected void numbers(ActionEvent actionEvent) {
        condition1 = false;
        condition = true;
        Button button = (Button) actionEvent.getSource();
        arrayList.add(button.getText());
        box.setText(box.getText() + button.getText());
        expression = box.getText();
        x=arrayList.size()-1;
    }

    @FXML
    protected void Operator(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (!box.getText().equals("")){
        box.setText(expression+button.getText());
        arrayList.set(x,button.getText());
        condition1=true;
        }
        if(button.getText().equals("-")&&box.getText().equals("")){
            arrayList.add(button.getText());
            box.setText(box.getText() + button.getText());
            expression = box.getText();
        }

    }

    @FXML
    protected void brackets(ActionEvent actionEvent) {
        condition1 = true;
        Button button = (Button) actionEvent.getSource();
        arrayList.add(button.getText());
        box.setText(box.getText() + button.getText());
        expression = box.getText();
        x=arrayList.size()-1;
    }

    @FXML
    protected void Evaluate()  {
        if (!box.getText().equals("")) {
            try{
            Calculator calculator = new Calculator(box.getText(), type);
            history.setText(calculator.mem+"=");
            answer.setText("" + calculator.findAnswers());
            }
            catch (Exception e){
                box.setText("");
                answer.setText("Bad Expression");
            }
        }
    }
    @FXML
    protected void clear() {
        expression = "";
        answer.setText("");
        arrayList.clear();
        history.setText("");
        box.setText(expression);
        condition1=true;
        condition=false;
    }

    @FXML
    protected void MathFunction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (button.getText().equals("^")) {
            arrayList.add("^(");
            box.setText(box.getText() +"^(");
            expression = box.getText();
        }
        if (button.getText().equals("n!")) {
            arrayList.add("!");
            box.setText(box.getText() + "!");
            expression = box.getText();
        }
        if (condition1) {
            if (button.getText().equals("sin")) {
                arrayList.add("sin(");
                box.setText(box.getText() + "sin(");
                expression = box.getText();
            }
            if (button.getText().equals("asin")) {
                arrayList.add("asin(");
                box.setText(box.getText() + "asin(");
                expression = box.getText();
            }
            if (button.getText().equals("cos")) {
                arrayList.add("cos(");
                box.setText(box.getText() + "cos(");
                expression = box.getText();
            }
            if (button.getText().equals("acos")) {
                arrayList.add("acos(");
                box.setText(box.getText() + "acos(");
                expression = box.getText();
            }
            if (button.getText().equals("tan")) {
                arrayList.add("tan(");
                box.setText(box.getText() + "tan(");
                expression = box.getText();
            }
            if (button.getText().equals("atan")) {
                arrayList.add("atan(");
                box.setText(box.getText() + "atan(");
                expression = box.getText();
            }
            if (button.getText().equals("log")) {
                arrayList.add("log(");
                box.setText(box.getText() + "log(");
                expression = box.getText();
            }
            if (button.getText().equals("10^x")) {
                arrayList.add("10^");
                box.setText(box.getText() + "10^");
                expression = box.getText();
            }
            if (button.getText().equals("ln")) {
                arrayList.add("ln(");
                box.setText(box.getText() + "ln(");
                expression = box.getText();
            }
            if (button.getText().equals("e^x")) {
                arrayList.add("e^");
                box.setText(box.getText() + "e^");
                expression = box.getText();
            }
            if (button.getText().equals("√")) {
                arrayList.add("√(");
                box.setText(box.getText() +"√(");
                expression = box.getText();
            }
        }
        x=arrayList.size()-1;
    }

    @FXML
    protected void cut() {
        if (arrayList.size() != 0) {
            expression = "";
            arrayList.remove(arrayList.size() - 1);
            for (String s : arrayList) expression = String.format("%s%s", expression, s);
            box.setText(expression);
            x=arrayList.size()-1;
            condition1=true;
            condition=true;
        }
    }
    @FXML
    protected void InverseFunction(ActionEvent actionEvent){
        Button button = (Button) actionEvent.getSource();
        if (!button.isDefaultButton()){
            log.setText("10^x");
            ln.setText("e^x");
            sin.setText("asin");
            cos.setText("acos");
            tan.setText("atan");
            button.setDefaultButton(true);
        }
        else{
            button.setDefaultButton(false);
            log.setText("log");
            ln.setText("ln");
            sin.setText("sin");
            cos.setText("cos");
            tan.setText("tan");
        }
    }
    @FXML
    protected void Enable(ActionEvent actionEvent) {
        if (((RadioButton) actionEvent.getSource()).getText().equals("Scientific")) {
            Scientific.setDisable(true);
            Standard.setSelected(false);
            Standard.setDisable(false);
            sin.setDisable(false);
            cos.setDisable(false);
            tan.setDisable(false);
            fact.setDisable(false);
            pi.setDisable(false);
            ln.setDisable(false);
            log.setDisable(false);
            Inverse.setDisable(false);
            e.setDisable(false);
        }
        if (((RadioButton) actionEvent.getSource()).getText().equals("Standard")) {
            Scientific.setSelected(false);
            Standard.setDisable(true);
            Scientific.setDisable(false);
            sin.setDisable(true);
            cos.setDisable(true);
            tan.setDisable(true);
            fact.setDisable(true);
            pi.setDisable(true);
            ln.setDisable(true);
            log.setDisable(true);
            Inverse.setDisable(true);
            e.setDisable(true);
        }

    }
    @FXML
    protected void measureSystem(ActionEvent actionEvent) {
        if (((RadioButton) actionEvent.getSource()).getText().equals("Degree")) {
            Radian.setSelected(false);
            Radian.setDisable(false);
            Degree.setDisable(true);
            type='D';
        }
        if (((RadioButton) actionEvent.getSource()).getText().equals("Radian")) {
            type='R';
            Degree.setSelected(false);
            Degree.setDisable(false);
            Radian.setDisable(true);
        }
    }
}
