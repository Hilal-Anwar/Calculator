package Code;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class LengthLayout implements Initializable
{
    Double []lengthConversionData={1.E-15,1.E-9,0.001,0.01,1.0,1000.0,0.0254,0.3048,1609.0,3*0.3048,1.E-10,9.461E15,1852.0,6*0.3048,5.292E-11,3.084E15,16.5*0.3048};
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
        select_Item_1=(CheckMenuItem)menu_butt_1.getItems().get(4);
        select_Item_2=(CheckMenuItem)menu_butt_2.getItems().get(4);
        for (int x=0;x<observableList.size();x++) hashMap.put(observableList.get(x).getText(),lengthConversionData[x]);
    }
    void applyConversion(){
        if (!Unit_1.getText().isEmpty())
        Unit_2.setText(""+Double.parseDouble(Unit_1.getText())*hashMap.get(menu_butt_1.getText())/hashMap.get(menu_butt_2.getText()));
    }
}
