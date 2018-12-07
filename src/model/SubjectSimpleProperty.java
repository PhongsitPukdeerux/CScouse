package model;

import javafx.beans.property.SimpleStringProperty;

public class SubjectSimpleProperty {

    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty credit;
    private SimpleStringProperty comeFrom;

    public SubjectSimpleProperty(String id, String name, String credit, String comefrom) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.credit = new SimpleStringProperty(credit);
        this.comeFrom = new SimpleStringProperty(comefrom);
    }

    public String getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public String getCredit() {
        return credit.get();
    }

    public String getComeFrom() {
        return comeFrom.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setCredit(String credit) {
        this.credit.set(credit);
    }

    public void setComeFrom(String comeFrom) {
        this.comeFrom.set(comeFrom);
    }
}
