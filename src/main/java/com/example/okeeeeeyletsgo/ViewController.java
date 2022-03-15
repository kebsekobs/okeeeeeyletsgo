package com.example.okeeeeeyletsgo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController extends MainController implements Initializable {
    StringProperty nameOfHaircut = new SimpleStringProperty();
    StringProperty colourOfHaircut = new SimpleStringProperty();
    StringProperty hairLength = new SimpleStringProperty();
    StringProperty facialHair = new SimpleStringProperty();
    StringProperty review = new SimpleStringProperty();
    StringProperty cutePhoto = new SimpleStringProperty();
    int rate;

    public ViewController(String nameOfHaircut, String colourOfHaircut, String hairLength, String facialHair, String review, String cutePhoto, int rate) throws Exception {
        super();
        this.nameOfHaircut.set(nameOfHaircut);
        this.colourOfHaircut.set(colourOfHaircut);
        this.hairLength.set(hairLength);
        this.facialHair.set(facialHair);
        this.review.set(review);
        this.cutePhoto.set(cutePhoto);
        this.rate = rate;
    }

    @FXML
    private Label nameOfHaircutLabel;

    @FXML
    private Label colourOfHaircutLabel;

    @FXML
    private Label hairLengthLabel;

    @FXML
    private Label facialHairLabel;

    @FXML
    private TextArea reviewArea;

    @FXML
    private ImageView cutePhotoImg;

    @FXML
    private Label rateLabel;

    @Override
    public void initialize(URL location, ResourceBundle resource)
    {
        Image cutePhotoImage = new Image(cutePhoto.get().substring(1, cutePhoto.get().length()-1));
        nameOfHaircutLabel.setText(nameOfHaircut.get());
        colourOfHaircutLabel.setText(colourOfHaircut.get());
        hairLengthLabel.setText(hairLength.get());
        facialHairLabel.setText(facialHair.get());
        reviewArea.setText(review.get());
        cutePhotoImg.setImage(cutePhotoImage);
        rateLabel.setText(String.valueOf(rate));
    }
}