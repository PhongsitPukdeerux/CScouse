package ui;

import data.DataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Subject;
import model.SubjectSimpleProperty;

import java.io.IOException;
import java.util.ArrayList;

public class MainPage {

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Button allCourseBtn, selectBtn;

    @FXML
    private TableView<Subject> tableViewEasy, tableViewNormal, tableViewHard;

    @FXML
    private TableColumn<SubjectSimpleProperty, String> idEasy, idNormal, idHard;

    @FXML
    private TableColumn<SubjectSimpleProperty, String> nameEasy, nameNormal, nameHard;

    @FXML
    private TableColumn<SubjectSimpleProperty, String> creditEasy, creditNormal, creditHard;

    @FXML
    private TableColumn<SubjectSimpleProperty, String> comeFromEasy, comeFromNormal, comeFromHard;

    private ArrayList<Subject> courses;
    private DataSource dataSource;
    private ArrayList<Subject> easySubject = new ArrayList<>();
    private ArrayList<Subject> normalSubject = new ArrayList<>();
    private ArrayList<Subject> hardSubject = new ArrayList<>();
    private ObservableList<Subject> subjectObservableListEasy, subjectObservableListNormal, subjectObservableListHard;
    private String path = "doc/year1-1.txt"; // to set tha first path

    public void initialize() {
        this.readFile(path);
        this.checkForDifficulty();
        choiceBox.getItems().add("year1-1");
        choiceBox.getItems().add("year1-2");
        choiceBox.getItems().add("year2-1");
        choiceBox.getItems().add("year2-2");
        choiceBox.getItems().add("year3-1");
        choiceBox.getItems().add("year3-2");
        choiceBox.getItems().add("year4-1");
        choiceBox.getItems().add("year4-2");
        choiceBox.setValue("year1-1");

        idEasy.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameEasy.setCellValueFactory(new PropertyValueFactory<>("name"));
        creditEasy.setCellValueFactory(new PropertyValueFactory<>("credit"));
        comeFromEasy.setCellValueFactory(new PropertyValueFactory<>("comeFrom"));
        idNormal.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameNormal.setCellValueFactory(new PropertyValueFactory<>("name"));
        creditNormal.setCellValueFactory(new PropertyValueFactory<>("credit"));
        comeFromNormal.setCellValueFactory(new PropertyValueFactory<>("comeFrom"));
        idHard.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameHard.setCellValueFactory(new PropertyValueFactory<>("name"));
        creditHard.setCellValueFactory(new PropertyValueFactory<>("credit"));
        comeFromHard.setCellValueFactory(new PropertyValueFactory<>("comeFrom"));


        subjectObservableListEasy = FXCollections.observableArrayList(easySubject);
        subjectObservableListNormal = FXCollections.observableArrayList(normalSubject);
        subjectObservableListHard = FXCollections.observableArrayList(hardSubject);
        tableViewEasy.setItems(subjectObservableListEasy);
        tableViewNormal.setItems(subjectObservableListNormal);
        tableViewHard.setItems(subjectObservableListHard);
    }

    @FXML
    private void handleAllCourseButton(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) allCourseBtn.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("ComputerScienceCourse.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSelectButton(ActionEvent event) {
        this.reset();
        path = "doc/" + choiceBox.getValue() + ".txt";
        System.out.println("in " + path);
        // to read and add it into table again
        this.readFile(path);
        this.checkForDifficulty();
        subjectObservableListEasy = FXCollections.observableArrayList(easySubject);
        subjectObservableListNormal = FXCollections.observableArrayList(normalSubject);
        subjectObservableListHard = FXCollections.observableArrayList(hardSubject);
        tableViewEasy.setItems(subjectObservableListEasy);
        tableViewNormal.setItems(subjectObservableListNormal);
        tableViewHard.setItems(subjectObservableListHard);
    }

    private void reset() {
        easySubject = new ArrayList<>();
        normalSubject = new ArrayList<>();
        hardSubject = new ArrayList<>();
        tableViewEasy.getItems().removeAll(tableViewEasy.getItems());
    }

    private void readFile(String path) {
        dataSource = new DataSource(path);
        System.out.println(path);
        try {
            courses = dataSource.read();
        } catch (IOException e) {
            System.out.println("Error reading account data.");
            return;
        }
    }

    private void checkForDifficulty() {
        for (Subject course : courses) {
            if (course.getDifficulty().equals("easy")) {
                easySubject.add(course);
            } else if (course.getDifficulty().equals("normal")) {
                normalSubject.add(course);
            } else {
                hardSubject.add(course);
            }
        }
    }
}
