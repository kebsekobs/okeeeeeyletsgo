package com.example.okeeeeeyletsgo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AddController extends MainController implements Initializable {
    private String cutePhoto;

    @FXML
    TextField nameOfHaircutField;

    @FXML
    TextField colourOfHaircutField;

    @FXML
    TextField hairLengthField;

    @FXML
    TextField facialHairField;

    @FXML
    TextArea reviewArea;

    @FXML
    Button btnCutePhoto;

    @FXML
    TextField rate;

    @FXML
    Button btn;

    public AddController() throws Exception {super();}

    @Override
    public void initialize(URL location, ResourceBundle resource)
    {
        btnCutePhoto.setOnAction(event ->  addImg());
    }

    public void addImg()
    {
        final FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(btnCutePhoto.getScene().getWindow());
        if (file != null)
        {
            if (cutePhoto == null || cutePhoto.equals("") ) cutePhoto = file.getAbsolutePath();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("File is empty!");
            alert.setHeaderText(null);
            alert.setContentText("File is empty!");
        }
    }

    public void addHaircut()
    {
        try{
            int r = Integer.parseInt(rate.getText());
            Haircut haircut = new Haircut(
                    nameOfHaircutField.getText(),colourOfHaircutField.getText(),
                    hairLengthField.getText(),facialHairField.getText(),
                    reviewArea.getText(),
                    cutePhoto,
                    r
            );
            listOfHaircuts.add(haircut);
            addInCSV();
            btn.setDisable(true);
            clickOnListOfHaircuts();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Wrong info");
            alert.setHeaderText(null);
            alert.setContentText("In rate wrote not number!");
        }
    }
}