package Code;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class TemperatureLayout implements Initializable {
    CheckMenuItem select_Item_1 = new CheckMenuItem();
    CheckMenuItem select_Item_2 = new CheckMenuItem();
    @FXML
    MenuButton menu_butt_1, menu_butt_2;
    @FXML
    TextField Unit_1, Unit_2;

    @FXML
    protected void numbers(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        if (button.getText().equals("+/-") && !Unit_1.getText().isEmpty())
            Unit_1.setText("" + (-1 * Double.parseDouble(Unit_1.getText())));
        if (!button.getText().equals("+/-") )Unit_1.setText(Unit_1.getText() + button.getText());
        applyConversion();
    }

    @FXML
    protected void cut() {
        if (!Unit_1.getText().isEmpty()) {
            Unit_1.setText(Unit_1.getText().substring(0, Unit_1.getText().length() - 1));
            applyConversion();
        }
    }

    @FXML
    protected void clear() {
        Unit_1.setText("");
        Unit_2.setText("");
    }

    @FXML
    protected void decimal() {
        if (!Unit_1.getText().contains("."))
            Unit_1.setText(Unit_1.getText() + ".");
    }

    @FXML
    protected void select_unit_1(ActionEvent actionEvent) {
        CheckMenuItem checkMenuItem = (CheckMenuItem) actionEvent.getSource();
        menu_butt_1.setText(checkMenuItem.getText());
        if (!select_Item_1.getText().equals(checkMenuItem.getText()))
            select_Item_1.setSelected(false);
        checkMenuItem.setSelected(true);
        select_Item_1 = checkMenuItem;
        applyConversion();
    }

    @FXML
    protected void select_unit_2(ActionEvent actionEvent) {
        CheckMenuItem checkMenuItem = (CheckMenuItem) actionEvent.getSource();
        menu_butt_2.setText(checkMenuItem.getText());
        if (!select_Item_2.getText().equals(checkMenuItem.getText()))
            select_Item_2.setSelected(false);
        checkMenuItem.setSelected(true);
        select_Item_2 = checkMenuItem;
        applyConversion();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        select_Item_1 = (CheckMenuItem) menu_butt_1.getItems().get(2);
        select_Item_2 = (CheckMenuItem) menu_butt_2.getItems().get(2);
    }

    void applyConversion() {
        if (!Unit_1.getText().isEmpty()) {
            if (select_Item_1.getText().equals("Celsius") && select_Item_2.getText().equals("Kelvin")) {
                Unit_2.setText("" + (Double.parseDouble(Unit_1.getText()) + 273));
            } else if (select_Item_1.getText().equals("Celsius") && select_Item_2.getText().equals("Fahrenheit")) {
                Unit_2.setText("" + ((Double.parseDouble(Unit_1.getText()) - 32) * 9 / 5));
            } else if (select_Item_1.getText().equals("Fahrenheit") && select_Item_2.getText().equals("Celsius")) {
                Unit_2.setText("" + ((Double.parseDouble(Unit_1.getText()) - 32) * 5 / 9));
            } else if (select_Item_1.getText().equals("Fahrenheit") && select_Item_2.getText().equals("Kelvin")) {
                Unit_2.setText("" + (((Double.parseDouble(Unit_1.getText()) - 32) * 9 / 5) + 273));
            } else if (select_Item_1.getText().equals("Kelvin") && select_Item_2.getText().equals("Celsius")) {
                Unit_2.setText("" + (Double.parseDouble(Unit_1.getText()) - 273));
            } else if (select_Item_1.getText().equals("Kelvin") && select_Item_2.getText().equals("Fahrenheit")) {
                double v = (Double.parseDouble(Unit_1.getText()) - 273);
                Unit_2.setText("" + (v - 32) * 9 / 5);
            }
            else
                Unit_2.setText(Unit_1.getText());
        }
    }
}
