package com.example.okeeeeeyletsgo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ListController extends MainController implements Initializable {

    @FXML
    public Button btnAddNewHaircut;

    @FXML
    public Button btnOpenListOFHaircuts;

    @FXML
    private ScrollPane scrollListOfHaircutsBox;

    @FXML
    private VBox listOfHaircutsBox;

    @FXML
    public Button addNewHaircut;

    @FXML
    public Button openListOFHaircuts;



    public ListController() throws Exception {
        super();
        MainController.ParseCSV(MainController.pathCSV);
    }

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        generateList(listOfHaircuts);
    }

    public void createChildrenAnchorElement(AnchorPane haircut, int i) {
        Haircut currentHaircut = listOfHaircuts.get(i);
        Label name_of_haircut = new Label("Name of Haircut");
        name_of_haircut.minWidth(100);
        name_of_haircut.minHeight(50);
        AnchorPane.setBottomAnchor(name_of_haircut, 10.0);
        AnchorPane.setLeftAnchor(name_of_haircut, 10.0);
        AnchorPane.setRightAnchor(name_of_haircut, 300.0);
        AnchorPane.setTopAnchor(name_of_haircut, 10.0);

        Label current_name_of_haircut = new Label(currentHaircut.getNameOfHaircut());
        current_name_of_haircut.minWidth(120);
        current_name_of_haircut.minHeight(50);
        AnchorPane.setBottomAnchor(current_name_of_haircut, 10.0);
        AnchorPane.setLeftAnchor(current_name_of_haircut, 110.0);
        AnchorPane.setRightAnchor(current_name_of_haircut, 300.0);
        AnchorPane.setTopAnchor(current_name_of_haircut, 10.0);

        /*Label name_of_colour = new Label("Colour");
        name_of_haircut.minWidth(100);
        name_of_haircut.minHeight(50);
        AnchorPane.setBottomAnchor(name_of_colour, 10.0);
        AnchorPane.setLeftAnchor(name_of_colour, 10.0);
        AnchorPane.setRightAnchor(name_of_colour, 800.0);
        AnchorPane.setTopAnchor(name_of_colour, 30.0);*/

        /*Label current_name_of_colour = new Label(currentHaircut.getColourOfHaircut());
        current_name_of_haircut.minWidth(120);
        current_name_of_haircut.minHeight(50);
        AnchorPane.setBottomAnchor(current_name_of_colour, 10.0);
        AnchorPane.setLeftAnchor(current_name_of_colour, 110.0);
        AnchorPane.setRightAnchor(current_name_of_colour, 600.0);
        AnchorPane.setTopAnchor(current_name_of_colour, 30.0);*/

        Button info = new Button("info");
        Button delete = new Button("delete");


        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setMinHeight(200);
        hBox.setMinWidth(300);
        hBox.setMaxHeight(200);
        hBox.setMaxWidth(350);
        hBox.setSpacing(20);
        AnchorPane.setBottomAnchor(hBox, 10.0);
        AnchorPane.setLeftAnchor(hBox, 350.0);
        AnchorPane.setRightAnchor(hBox, 20.0);
        AnchorPane.setTopAnchor(hBox, 10.0);

        info.setStyle("-fx-background-color: rgb(222,221,221); -fx-text-fill: #070707;");
        delete.setStyle("-fx-background-color: rgb(222,221,221); -fx-text-fill: #070707;");
        hBox.getChildren().addAll(info, delete);

        haircut.getChildren().addAll(name_of_haircut, current_name_of_haircut, hBox);

        info.setOnAction(event -> {
            try {
                infoAboutHaircut(i);
            } catch (Exception e) {
                System.err.println(e.getLocalizedMessage());
            }
        });
        delete.setOnAction(event -> deleteHaircut(i));
    }

    private void generateList(LinkedList<Haircut> list) {
        final int countOfHaircuts = list.size();
        final int heightElement = 60;
        listOfHaircutsBox.minHeight(heightElement * countOfHaircuts);
        for (int i = 0; i < countOfHaircuts; i++) {
            AnchorPane pane = new AnchorPane();
            pane.setMinHeight(40);
            pane.setMaxHeight(heightElement);
            pane.prefWidth(800);
            pane.prefHeight(heightElement);
            pane.minWidth(Region.USE_COMPUTED_SIZE);
            pane.maxWidth(Region.USE_COMPUTED_SIZE);
            listOfHaircutsBox.getChildren().add(pane);
            createChildrenAnchorElement(pane, i);
        }
    }

    public void infoAboutHaircut(int index) throws Exception {
        Stage stage = (Stage) listOfHaircutsBox.getScene().getWindow();
        FXMLLoader root = new FXMLLoader(getClass().getResource("info-view.fxml"));
        ViewController controller = new ViewController(
                listOfHaircuts.get(index).getNameOfHaircut(),
                listOfHaircuts.get(index).getColourOfHaircut(),
                listOfHaircuts.get(index).getHairLength(),
                listOfHaircuts.get(index).getFacialHair(),
                listOfHaircuts.get(index).getReview(),
                listOfHaircuts.get(index).getCutePhoto(),
                listOfHaircuts.get(index).getRate()

        );
        root.setController(controller);
        BorderPane viewPane = root.load();

        Scene scene = new Scene(viewPane, 600, 400);
        stage.setScene(scene);
        stage.show();

    }

    public void deleteHaircut(int index) {
        listOfHaircuts.remove(index);
        addInCSV();
        try {
            clickOnListOfHaircuts();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}