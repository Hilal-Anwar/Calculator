package Code;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class AngleLayout implements Initializable {
    Double []angleConversionData={0.01745,0.0002909,4.848E-6,1.0,6.283};
    LinkedHashMap<String,Double> hashMap=new LinkedHashMap<>();
    CheckMenuItem select_Item_1=new CheckMenuItem();
    CheckMenuItem select_Item_2=new CheckMenuItem();
    @FXML
    MenuButton menu_butt_1,menu_butt_2;
    @FXML
    TextField Unit_1,Unit_2;
    @FXML
    protected void numbers(ActionEvent actionEvent){
        Button button=(Button)actionEvent.getSource();
        Unit_1.setText(Unit_1.getText()+button.getText());
        applyConversion();
    }
    @FXML
    protected void cut(){
        if (!Unit_1.getText().isEmpty()){
            Unit_1.setText(Unit_1.getText().substring(0,Unit_1.getText().length()-1));
            applyConversion();
        }
    }
    @FXML
    protected void clear(){
        Unit_1.setText("");
        Unit_2.setText("");
    }
    @FXML
    protected void decimal(){
        if (!Unit_1.getText().contains("."))
            Unit_1.setText(Unit_1.getText()+".");
    }
    @FXML
    protected void select_unit_1(ActionEvent actionEvent){
        CheckMenuItem checkMenuItem=(CheckMenuItem)actionEvent.getSource();
        menu_butt_1.setText(checkMenuItem.getText());
        if (!select_Item_1.getText().equals(checkMenuItem.getText()))
            select_Item_1.setSelected(false);
        checkMenuItem.setSelected(true);
        select_Item_1=checkMenuItem;
        applyConversion();
    }
    @FXML
    protected void select_unit_2(ActionEvent actionEvent){
        CheckMenuItem checkMenuItem=(CheckMenuItem)actionEvent.getSource();
        menu_butt_2.setText(checkMenuItem.getText());
        if (!select_Item_2.getText().equals(checkMenuItem.getText()))
            select_Item_2.setSelected(false);
        checkMenuItem.setSelected(true);
        select_Item_2=checkMenuItem;
        applyConversion();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<MenuItem> observableList=menu_butt_1.getItems();
        select_Item_1=(CheckMenuItem)menu_butt_1.getItems().get(3);
        select_Item_2=(CheckMenuItem)menu_butt_2.getItems().get(3);
        for (int x=0;x<observableList.size();x++) {
            hashMap.put(observableList.get(x).getText(),angleConversionData[x]);
        }
    }
    void applyConversion(){
        if (!Unit_1.getText().isEmpty())
            Unit_2.setText(""+Double.parseDouble(Unit_1.getText())*hashMap.get(menu_butt_1.getText())/hashMap.get(menu_butt_2.getText()));
    }
}
