package Code;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    static Stage stage = new Stage();
    static AnchorPane parent, length_converter, weight_converter,
            temperature_converter, area_converter, volume_converter,
            speed_converter, force_converter, pressure_converter,
            viscosity_converter,density_conversion,time_converter,
            angle_converter, energy_converter,pop;
    static Scene scene;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        pop=FXMLLoader.load(Main.class.getResource("PopUpPane.fxml"));
        speed_converter = FXMLLoader.load(getClass().getResource("speed_layout.fxml"));
        force_converter = FXMLLoader.load(getClass().getResource("force_layout.fxml"));
        pressure_converter = FXMLLoader.load(getClass().getResource("pressure_layout.fxml"));
        time_converter=FXMLLoader.load(getClass().getResource("time_layout.fxml"));
        density_conversion=FXMLLoader.load(getClass().getResource("density_layout.fxml"));
        weight_converter = FXMLLoader.load(getClass().getResource("weight_&_mass.fxml"));
        temperature_converter = FXMLLoader.load(getClass().getResource("temperature_layout.fxml"));
        volume_converter = FXMLLoader.load(getClass().getResource("volume_layout.fxml"));
        viscosity_converter = FXMLLoader.load(getClass().getResource("viscosity_layout.fxml"));
        angle_converter = FXMLLoader.load(getClass().getResource("angle_layout.fxml"));
        area_converter = FXMLLoader.load(getClass().getResource("area_layout.fxml"));
        energy_converter = FXMLLoader.load(getClass().getResource("energy_layout.fxml"));
        length_converter = FXMLLoader.load(getClass().getResource("length_layout.fxml"));
        parent = FXMLLoader.load(getClass().getResource("calculator_layout.fxml"));
        length_converter.setLayoutX(577);
        length_converter.setLayoutY(80);
        parent.getChildren().add(length_converter);
        scene = new Scene(parent, 545, 395);
        stage.setScene(scene);
        stage.setOpacity(0.95);
        stage.setTitle("Calculator");
        stage.getIcons().addAll(new Image(Main.class.getResource("icon.png").toString()));
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
