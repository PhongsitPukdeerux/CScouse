package data;

import model.Subject;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSource {

    private String filename;
    private String year;
    private String id;
    private String name;
    private String credit;
    private String status;
    private Subject c;
    private String comeFrom;

    public DataSource(String filename) {
        this.filename = filename;
    }

    public DataSource() {
        this.filename = "doc/CourseInformation.txt";
    }

    public ArrayList<Subject> read() throws IOException {
        ArrayList<Subject> subject = new ArrayList<>();

        Scanner in = new Scanner(new FileReader(filename));
        while (in.hasNext()) {
            year = in.next();
            id = in.next();
            name = in.next();
            credit = in.next();
            comeFrom = in.next();
            status = in.next();
            c = new Subject(year, id, name, credit, comeFrom,status);
            subject.add(c);
        }
        in.close();
        return subject;
    }
}
