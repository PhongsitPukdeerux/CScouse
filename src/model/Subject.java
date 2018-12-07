package model;

public class Subject {
    String year;
    String id;
    String name;
    String credit;
    String comeFrom;
    String difficulty;

    public Subject(String year, String id, String name, String credit, String comeFrom, String difficulty) {
        this.year = year;
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.comeFrom = comeFrom;
        this.difficulty = difficulty;
    }

    public String getYear() {
        return year;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCredit() {
        return credit;
    }

    public String getComeFrom() {
        return comeFrom;
    }

    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public String toString() {
        return year + " ID " + id + "  " + name + " credit " + credit;
    }
}
