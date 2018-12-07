package ui;

import data.DataSource;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Subject;

import java.io.IOException;
import java.util.ArrayList;

public class ComputerScienceCourse {
    @FXML
    TextArea textArea;

    @FXML
    Button btn1;

    private ArrayList<Subject> subjectArrayList;

    public void initialize() {
        this.initializeReadFile();
        this.initializeTextArea();
    }

    public void initializeReadFile() {
        DataSource dataSource = new DataSource();
        try {
            subjectArrayList = dataSource.read();
        } catch (IOException e) {
            System.out.println("Error reading account data.");
            return;
        }
    }

    public void initializeTextArea() {
        String s = "";
        for (int i = 0; i < getSubjectArrayList().size(); i++) {
            s += String.valueOf(getSubjectArrayList().get(i));
            s += "\n";
        }
        textArea.setText(s);
    }

    public ArrayList<Subject> getSubjectArrayList() {
        return subjectArrayList;
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws Exception {
        Stage stage;
        Parent root;
        stage = (Stage) btn1.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}