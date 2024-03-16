package build;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class Student {
    private String name;
    private long id;
    private double score;

    public Student(String name, long id, double score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public long getId() {
        return this.id;
    }

    public double getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.id + "\t" + this.score;
    }
}

class NameSorter implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        String name1 = student1.getName();
        String name2 = student2.getName();
        return name1.compareTo(name2);
    }
}

class ScoreSorter implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        Double score1 = student1.getScore();
        Double score2 = student2.getScore();
        return score1.compareTo(score2);
    }
}

public class DemoComparator {

    private static void showList(List<Student> studentList) {
        for(int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            System.out.println("Index#" + i + ": " + student);
        }
    }
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Thomas", 1, 3.8));
        studentList.add(new Student("John", 2, 3.9));
        studentList.add(new Student("George", 3, 3.4));

        System.out.println("\n--- Original ------------------");
        showList(studentList);

        System.out.println("\n--- Sort by name --------------");
        Comparator<Student> sortName = new NameSorter();
        Collections.sort(studentList, sortName);
        showList(studentList);

        System.out.println("\n--- Sort by score -------------");
        Comparator<Student> sortScore = new ScoreSorter();
        Collections.sort(studentList, sortScore);
        showList(studentList);
    }
}
