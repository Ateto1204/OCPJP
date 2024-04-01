package build;

import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student> {
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

    public String toString() {
        return this.name + "\t" + this.id + "\t" + this.score;
    }

    @Override
    public int compareTo(Student student) {
        
        Long thisObjectId = Long.valueOf(this.id);
        Long objectId = Long.valueOf(student.id);
        int sortById = thisObjectId.compareTo(objectId);

        int sortByName = this.name.compareTo(student.name);

        Double thisObjectScore = Double.valueOf(this.score);
        Double objectScore = Double.valueOf(student.score);
        int sortByScore = thisObjectScore.compareTo(objectScore);

        return sortById;
    }
}


public class ComparableDemo {
    public static void main(String[] args) {
        Set<Student> sortedStudentList = new TreeSet<>();
        sortedStudentList.add(new Student("John", 2, 3.9));
        sortedStudentList.add(new Student("Thomas", 1, 3.8));
        sortedStudentList.add(new Student("George", 3, 3.4));
        for(Student student : sortedStudentList) {
            System.out.println(student);
        }
    }
}