/*
Create a new class StudentSpecialty that holds specialty name and faculty number.
Create a Student class that holds student name and  faculty number. Create a list of
student specialties, where each specialty corresponds to a certain student
(via the faculty number). Print all student names alphabetically along with their
faculty number and specialty name.

You will recieve several specialties in format :
 {specialty name} {specialty name} {faculty number}

Until you reach "Students:" , you should add specialties to the collection. After you
reach "Students:", you should start reading students in format :
	{faculty number} {student's first name} {student's second name}
You should add the students untill you recieve "END" command.

 */
package javaadvanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StudentsJoinedSpecialties {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = "";
        List<StudentSpecialty> listSpecialties = new ArrayList<>();
        List<Student> listStudents = new ArrayList<>();

        while (!(input = sc.nextLine()).equals("Students:")) {
            String[] tokens = input.split("\\s+");

            String specialty = tokens[0] + " " + tokens[1];
            String facultyNum = tokens[2];
            StudentSpecialty stSpec = new StudentSpecialty(specialty, facultyNum);

            listSpecialties.add(stSpec);
        }

        while (!(input = sc.nextLine()).equals("END")) {
            String[] tokens = input.split("\\s+");

            String facultyNum = tokens[0];
            String studentName = tokens[1] + " " + tokens[2];
            Student student = new Student(studentName, facultyNum);

            listStudents.add(student);
        }

        Map<String, List<StudentSpecialty>> bySpecialty
                = listSpecialties.stream()
                .collect(Collectors.groupingBy(StudentSpecialty::getFacultyNumber));

        Map<String, List<Student>> byStudent
                = listStudents.stream()
                .collect(Collectors.groupingBy(Student::getFacultyNumber));

        byStudent.entrySet().stream() // stream of student fac.num.
                .sorted((person1, person2) -> person1.getValue().get(0).getStudentName().compareTo(person2.getValue().get(0).getStudentName()))
                .forEach(entry -> {
                    String facultyNumber = entry.getKey();
                    List<Student> students = entry.getValue();
                    List<StudentSpecialty> specialties = bySpecialty.get(facultyNumber);       //get the list of specialties for the corresponding fac. num.
                    String studentName = students.get(0).getStudentName();

                    if (specialties == null) {
                        return;
                    }

                    specialties.stream()
                            .forEach(specialty -> {
                                String specialtyName = specialty.getSpecialtyName();
                                System.out.printf("%s %s %s%n", studentName, facultyNumber, specialtyName);

                            });
                });
    }
}

class Student {

    private String studentName;
    private String facultyNumber;

    public Student(String studentName, String facultyNumber) {
        this.studentName = studentName;
        this.facultyNumber = facultyNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

}

class StudentSpecialty {

    private String specialtyName;
    private String facultyNumber;

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

}
