package Code;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class ViscosityLayout implements Initializable
{
    Double []dynamicConversionData={9806.6501248*9.807,9806.6501248,1488.164435,100.0,1.0,0.4133789,1488.1639328,47880.2595148,6894757.0,47880.25898};
    Double []KinematicConversionData={1.0,0.001,100.0,1000000.0,92903.04,645.16};
    LinkedHashMap<String,Double> hashMap=new LinkedHashMap<>();
    LinkedHashMap<String,Double> hashMap1=new LinkedHashMap<>();
    CheckMenuItem select_Item_1=new CheckMenuItem();
    CheckMenuItem select_Item_2=new CheckMenuItem();
    CheckMenuItem select_Item_11=new CheckMenuItem();
    CheckMenuItem select_Item_22=new CheckMenuItem();
    @FXML
    MenuButton menu_butt_1,menu_butt_2,menu_butt_3,menu_butt_4;
    @FXML
    TextField Unit_1,Unit_2,Unit_3,Unit_4;
    @FXML
    protected void numbers(ActionEvent actionEvent){
        Button button=(Button)actionEvent.getSource();
        Unit_1.setText(Unit_1.getText()+button.getText());
        Unit_3.setText(Unit_3.getText()+button.getText());
        applyConversion();
    }
    @FXML
    protected void cut(){
        if (!Unit_1.getText().isEmpty()&&!Unit_3.getText().isEmpty()){
            Unit_1.setText(Unit_1.getText().substring(0,Unit_1.getText().length()-1));
            Unit_3.setText(Unit_3.getText().substring(0,Unit_3.getText().length()-1));
            applyConversion();
        }
    }
    @FXML
    protected void clear(){
        Unit_1.setText("");
        Unit_2.setText("");
        Unit_3.setText("");
        Unit_4.setText("");
    }
    @FXML
    protected void decimal(){
        if (!Unit_1.getText().contains(".")){
            Unit_1.setText(Unit_1.getText()+".");
        }
        if (!Unit_3.getText().contains(".")){
            Unit_3.setText(Unit_3.getText()+".");
        }
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
        menu_butt_3.setText(checkMenuItem.getText());
        if (!select_Item_2.getText().equals(checkMenuItem.getText()))
            select_Item_2.setSelected(false);
        checkMenuItem.setSelected(true);
        select_Item_2=checkMenuItem;
        applyConversion();
    }
    @FXML
    protected void select_unit_11(ActionEvent actionEvent){
        CheckMenuItem checkMenuItem=(CheckMenuItem)actionEvent.getSource();
        menu_butt_2.setText(checkMenuItem.getText());
        if (!select_Item_11.getText().equals(checkMenuItem.getText()))
            select_Item_11.setSelected(false);
        checkMenuItem.setSelected(true);
        select_Item_11=checkMenuItem;
        applyConversion();
    }
    @FXML
    protected void select_unit_22(ActionEvent actionEvent){
        CheckMenuItem checkMenuItem=(CheckMenuItem)actionEvent.getSource();
        menu_butt_4.setText(checkMenuItem.getText());
        if (!select_Item_22.getText().equals(checkMenuItem.getText()))
            select_Item_22.setSelected(false);
        checkMenuItem.setSelected(true);
        select_Item_22=checkMenuItem;
        applyConversion();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<MenuItem> observableList1=menu_butt_1.getItems();
        ObservableList<MenuItem> observableList3=menu_butt_3.getItems();
        select_Item_1=(CheckMenuItem)menu_butt_1.getItems().get(4);
        select_Item_11=(CheckMenuItem)menu_butt_2.getItems().get(4);
        select_Item_2=(CheckMenuItem)menu_butt_3.getItems().get(0);
        select_Item_22=(CheckMenuItem)menu_butt_4.getItems().get(0);
        for (int x=0;x<observableList1.size();x++) hashMap.put(observableList1.get(x).getText(),dynamicConversionData[x]);
        for (int x=0;x<observableList3.size();x++) hashMap1.put(observableList3.get(x).getText(),KinematicConversionData[x]);
    }
    void applyConversion(){
        if (!Unit_1.getText().isEmpty())
            Unit_2.setText(""+Double.parseDouble(Unit_1.getText())*hashMap.get(menu_butt_1.getText())/hashMap.get(menu_butt_2.getText()));
        if (!Unit_3.getText().isEmpty())
            Unit_4.setText(""+Double.parseDouble(Unit_3.getText())*hashMap1.get(menu_butt_3.getText())/hashMap1.get(menu_butt_4.getText()));
    }
}
