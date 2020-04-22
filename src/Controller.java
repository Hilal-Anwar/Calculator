package Code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    static CheckMenuItem select_menu = new CheckMenuItem();
    ArrayList<String> arrayList = new ArrayList<>();
    AnchorPane currentPane;
    String expression, number=" ";
    char type = 'D';
    @FXML
    ImageView imag;
    @FXML
    Label answer, history;
    @FXML
    Button sin, tan, cos, fact, pi, ln, Inverse, e, log, equal;
    @FXML
    RadioButton Scientific, Standard, Degree, Radian;
    @FXML
    TextField box;
    int x = 0;
    @FXML
    MenuButton menu_butt;
    @FXML
    CheckMenuItem len;
    @FXML
    RadioMenuItem converter_item,scientific_item,standard_item;
    @FXML
    public void numbers(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (Character.isDigit(button.getText().charAt(0))||button.getText().equals("e")||button.getText().equals("π")) {
            number = number + button.getText();
            box.setText(box.getText() + button.getText());
            arrayList.add(button.getText());
        }
        if (button.getText().equals(".") && !number.contains(".")) {
            number = number + button.getText();
            box.setText(box.getText() + button.getText());
            arrayList.add(button.getText());
        }
        expression = box.getText();
    }
    @FXML
    protected void power(){
        if (!number.equals(" ")){
            box.setText(box.getText()+"^(");
            arrayList.add("^(");
            expression=box.getText();
        }

    }
    @FXML
    protected void Operator(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (!box.getText().equals(""))
        {
            if (!number.equals(" ")) {
                box.setText(expression + button.getText());
                arrayList.add(button.getText());
                x = arrayList.size() - 1;
            }
            else if (!box.getText().equals("-")){
                box.setText(expression + button.getText());
                arrayList.set(x, button.getText());
            }
        }
        if (button.getText().equals("-") && box.getText().equals("")) {
            arrayList.add(button.getText());
            box.setText(box.getText() + button.getText());
            expression = box.getText();
        }
        System.out.println(arrayList);
        number = " ";
    }

    @FXML
    protected void brackets(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        arrayList.add(button.getText());
        box.setText(box.getText() + button.getText());
        expression = box.getText();
        number = " ";
    }

    @FXML
    protected void Evaluate() {
        if (!box.getText().equals("")) {
            try {
                Calculator calculator = new Calculator(box.getText(), type);
                history.setText(calculator.mem + "=");
                answer.setText("" + calculator.findAnswers());
            } catch (Exception e) {
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
        number = " ";
    }

    @FXML
    protected void MathFunction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (button.getText().equals("n!")) {
            arrayList.add("!");
            box.setText(box.getText() + "!");
            expression = box.getText();
        }
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
            box.setText(box.getText() + "√(");
            expression = box.getText();
        }
        number = " ";
    }
    @FXML
    public void rational(){
        if (!answer.getText().isEmpty()){
            Rational rational=new Rational(answer.getText());
            answer.setText(rational.P_by_QForm());
        }
    }
     @FXML
     public void showPopUp(){
         Popup popup=new Popup();
         popup.setOpacity(0.80);
         popup.setX(Main.stage.getX()+70);
         popup.setY(Main.stage.getY()+80);
         popup.getContent().add(Main.pop);
         popup.setAutoHide(true);
         if (!popup.isShowing()){
             popup.show(Main.stage);
         }
     }
    @FXML
    protected void cut() {
        if (arrayList.size() != 0) {
            expression = "";
            arrayList.remove(arrayList.size() - 1);
            for (String s : arrayList) expression = String.format("%s%s", expression, s);
            box.setText(expression);
        }
    }

    @FXML
    protected void InverseFunction(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (!button.isDefaultButton()) {
            log.setText("10^x");
            ln.setText("e^x");
            sin.setText("asin");
            cos.setText("acos");
            tan.setText("atan");
            button.setDefaultButton(true);
            button.setStyle("-fx-background-color:#0bade0;-fx-text-fill:white");
        } else {
            button.setDefaultButton(false);
            button.setStyle("-fx-background-color:white");
            log.setText("log");
            ln.setText("ln");
            sin.setText("sin");
            cos.setText("cos");
            tan.setText("tan");
        }
    }

    @FXML
    protected void Enable(ActionEvent actionEvent) {
        number = " ";
        if (((RadioButton) actionEvent.getSource()).getText().equals("Scientific")) {
            Standard.setSelected(false);
            standard_item.setSelected(false);
            scientific_item.setSelected(true);
            Select();
        }
        if (((RadioButton) actionEvent.getSource()).getText().equals("Standard")) {
            Scientific.setSelected(false);
            scientific_item.setSelected(false);
            standard_item.setSelected(true);
            DeSelect();
        }

    }
    void Select(){
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
    void DeSelect(){
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
    @FXML
    protected void measureSystem(ActionEvent actionEvent) {
        if (((RadioButton) actionEvent.getSource()).getText().equals("Degree")) {
            Radian.setSelected(false);
            type = 'D';
        }
        if (((RadioButton) actionEvent.getSource()).getText().equals("Radian")) {
            type = 'R';
            Degree.setSelected(false);
        }
    }

    @FXML
    protected void Menu_items(ActionEvent actionEvent) {
        RadioMenuItem radioMenuItem = (RadioMenuItem) actionEvent.getSource();
        if (radioMenuItem.getText().equals("Conversion")) {
            if(radioMenuItem.isSelected())
            Main.stage.setWidth(985 + 65);
            else Main.stage.setWidth(545 + 15);
        }
        if (radioMenuItem.getText().equals("Scientific"))
        {
            if(radioMenuItem.isSelected())
            {
                standard_item.setSelected(false);
                Standard.setSelected(false);
                Scientific.setSelected(true);
                Select();
            }
            else {
                standard_item.setSelected(true);
                Standard.setSelected(true);
                Scientific.setSelected(false);
                DeSelect();
            }
        }
        if (radioMenuItem.getText().equals("Standard")){
            if(radioMenuItem.isSelected())
            {
                Scientific.setSelected(false);
                Standard.setSelected(true);
                scientific_item.setSelected(false);
                DeSelect();
            }
            else {
                scientific_item.setSelected(true);
                Standard.setSelected(false);
                Scientific.setSelected(true);
                Select();
            }
        }
    }

    @FXML
    protected void back_to_Calc() {
        Main.stage.setWidth(545 + 15);
        converter_item.setSelected(false);
    }

    @FXML
    protected void Select_Type(ActionEvent actionEvent) {
        CheckMenuItem menuItem = (CheckMenuItem) actionEvent.getSource();
        //length conversion
        int x = 557;
        int y = 80;
        if (menuItem.getText().equals("Length")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_length_32px_1.png").toString()));
            menu_butt.setGraphic(imag);
            if (!select_menu.getText().equals("Length"))
                select_menu.setSelected(false);
            menu_butt.setText("Length");
            Main.length_converter.setLayoutX(x);
            Main.length_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.length_converter);
            currentPane = Main.length_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //area converter;
        if (menuItem.getText().equals("Area")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_area_chart_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Area");
            if (!select_menu.getText().equals("Area"))
                select_menu.setSelected(false);
            Main.area_converter.setLayoutX(x);
            Main.area_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.area_converter);
            currentPane = Main.area_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //volume converter
        if (menuItem.getText().equals("Volume")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_sugar_cube_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Volume");
            if (!select_menu.getText().equals("Volume"))
                select_menu.setSelected(false);
            Main.volume_converter.setLayoutX(x);
            Main.volume_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.volume_converter);
            currentPane = Main.volume_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //weight converter
        if (menuItem.getText().equals("Weight & Mass")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_weight_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Weight & Mass");
            if (!select_menu.getText().equals("Weight & Mass"))
                select_menu.setSelected(false);
            Main.weight_converter.setLayoutX(x);
            Main.weight_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.weight_converter);
            currentPane = Main.weight_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //speed converter
        if (menuItem.getText().equals("Speed")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_speed_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Speed");
            if (!select_menu.getText().equals("Speed"))
                select_menu.setSelected(false);
            Main.speed_converter.setLayoutX(x);
            Main.speed_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.speed_converter);
            currentPane = Main.speed_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //energy converter
        if (menuItem.getText().equals("Energy/Power")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_bang_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Energy/Power");
            if (!select_menu.getText().equals("Energy/Power"))
                select_menu.setSelected(false);
            Main.energy_converter.setLayoutX(x);
            Main.energy_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.energy_converter);
            currentPane = Main.energy_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //temperature converter
        if (menuItem.getText().equals("Temperature")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_temperature_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Temperature");
            if (!select_menu.getText().equals("Temperature"))
                select_menu.setSelected(false);
            Main.temperature_converter.setLayoutX(x);
            Main.temperature_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.temperature_converter);
            currentPane = Main.temperature_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //force converter
        if (menuItem.getText().equals("Force")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_fight_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Force");
            if (!select_menu.getText().equals("Force"))
                select_menu.setSelected(false);
            Main.force_converter.setLayoutX(x);
            Main.force_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.force_converter);
            currentPane = Main.force_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //density converter
        if (menuItem.getText().equals("Density")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_atmospheric_pressure_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Density");
            if (!select_menu.getText().equals("Density"))
                select_menu.setSelected(false);
            Main.density_conversion.setLayoutX(x);
            Main.density_conversion.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.density_conversion);
            currentPane = Main.density_conversion;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //angle converter
        if (menuItem.getText().equals("Angle")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_inclination_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Angle");
            if (!select_menu.getText().equals("Angle"))
                select_menu.setSelected(false);
            Main.angle_converter.setLayoutX(x);
            Main.angle_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.angle_converter);
            currentPane = Main.angle_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //viscosity converter
        if (menuItem.getText().equals("Viscosity")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_mu_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Viscosity");
            if (!select_menu.getText().equals("Viscosity"))
                select_menu.setSelected(false);
            Main.viscosity_converter.setLayoutX(x);
            Main.viscosity_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.viscosity_converter);
            currentPane = Main.viscosity_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //pressure converter
        if (menuItem.getText().equals("Pressure")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_pressure_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Pressure");
            if (!select_menu.getText().equals("Pressure"))
                select_menu.setSelected(false);
            Main.pressure_converter.setLayoutX(x);
            Main.pressure_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.pressure_converter);
            currentPane = Main.pressure_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }
        //time converter
        if (menuItem.getText().equals("Time")) {
            imag.setImage(new Image(Controller.class.getResource("icons8_time_32px.png").toString()));
            menu_butt.setGraphic(imag);
            menu_butt.setText("Time");
            if (!select_menu.getText().equals("Time"))
                select_menu.setSelected(false);
            Main.time_converter.setLayoutX(x);
            Main.time_converter.setLayoutY(y);
            Main.parent.getChildren().remove(currentPane);
            Main.parent.getChildren().add(Main.time_converter);
            currentPane = Main.time_converter;
            menuItem.setSelected(true);
            select_menu = menuItem;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        select_menu = len;
        currentPane = Main.length_converter;
    }
}
