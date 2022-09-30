package com.example.okeeeeeyletsgo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController{
    static LinkedList<Haircut> listOfHaircuts;
    static String localDir = System.getProperty("user.dir");
    public static String pathCSV = localDir + "\\src\\main\\resources\\data.csv";

    @FXML
    public Button btnAddNewHaircut;

    @FXML
    public Button btnOpenListOFHaircuts;


    public MainController() throws Exception  {
        listOfHaircuts = ParseCSV(pathCSV);
    }

    private static boolean CheckColumn(String text)
    {
        String trimText = text.trim();
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"");
    }

    private static String deleteQuotes(String text)
    {
        while (text.charAt(0) == '\"' && text.charAt(text.length()-1)=='\"')
        {
            text = text.replaceFirst("\"", "");
            text = text.substring(0,text.length()-1);
        }
        return text;
    }

    public static boolean addInCSV()
    {
        try (PrintWriter writer = new PrintWriter(pathCSV)){
            for (Haircut haircut : listOfHaircuts) {
                String line = "";
                line += "\"" + deleteQuotes(haircut.getNameOfHaircut()) + "\";";
                line += "\"" + deleteQuotes(haircut.getColourOfHaircut()) + "\";";
                line += "\"" + deleteQuotes(haircut.getHairLength()) + "\";";
                line += "\"" + deleteQuotes(haircut.getFacialHair()) + "\";";
                line += "\"" + deleteQuotes(haircut.getReview()) + "\";";
                line += "\"" + deleteQuotes(haircut.getCutePhoto()) + "\";";
                line += "\"" + deleteQuotes(String.valueOf(haircut.getRate())) + "\";";
                line += "\n";
                writer.write(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static LinkedList<Haircut> ParseCSV(String path) throws Exception
    {
        LinkedList<Haircut> haircuts = new LinkedList();
        List<String> lines = Files.readAllLines(Paths.get(path));
        for (String line : lines)
        {
            String[] splitted = line.split(";");
            ArrayList<String> column = new ArrayList<>();
            for (String s : splitted) {
                if (CheckColumn(s)) {
                    String lastText = column.get(column.size());
                    column.set(column.size() - 1, lastText + ";" + s);
                } else {
                    column.add(s);
                }
            }
            Haircut haircut = new Haircut(
                    column.get(0), column.get(1), column.get(2),column.get(3),
                    column.get(4), column.get(5),
                    Integer.parseInt(column.get(6).substring(1,column.get(6).length()-1))
            );
            haircuts.add(haircut);
        }
        return haircuts;
    }

    public void clickOnListOfHaircuts() throws Exception
    {
        Stage stage = (Stage) btnOpenListOFHaircuts.getScene().getWindow();
        FXMLLoader root = new FXMLLoader(getClass().getResource("list-view.fxml"));
        ListController controller = new ListController();
        root.setController(controller);
        BorderPane pane = root.load();
        Scene scene = new Scene(pane, 600, 400);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void clickOnAddHaircut() throws Exception
    {
        Stage stage = (Stage) btnAddNewHaircut.getScene().getWindow();
        FXMLLoader root = new FXMLLoader(getClass().getResource("add-view.fxml"));
        AddController controller = new AddController();
        root.setController(controller);
        BorderPane pane = root.load();
        Scene scene = new Scene(pane, 600, 400);
        stage.setScene(scene);
        stage.show();
    }
}