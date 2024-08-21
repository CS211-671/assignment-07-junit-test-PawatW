package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class StudentListTest {

    @Test
    public void testAddNewStudentWithoutScore() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6610451036", "Pawat");

        Student student = studentList.findStudentById("6610451036");
        assertNotNull(student);
        assertEquals("6610451036", student.getId());
        assertEquals("Pawat", student.getName());
    }
    @Test
    public void testAddNewStudentWithScore() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6610451037", "nunez", 85.5);

        Student student = studentList.findStudentById("6610451037");
        assertNotNull(student);
        assertEquals("6610451037", student.getId());
        assertEquals("nunez", student.getName());
        assertEquals(85.5, student.getScore());
    }

    @Test
    public void testFindStudentById() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6610451036", "Pawat");
        studentList.addNewStudent("6610451037", "nunez");

        Student student = studentList.findStudentById("6610451037");
        assertNotNull(student);
        assertEquals("nunez", student.getName());
    }

    @Test
    public void testFindStudentByIdNotFound() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6610451036", "Pawat");

        Student student = studentList.findStudentById("6610451040");
        assertNull(student);
    }

    @Test
    @DisplayName("Should give score to existing student")
    public void testGiveScoreToId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6610451036", "Pawat");

        studentList.giveScoreToId("6610451036", 50.0);
        Student student = studentList.findStudentById("6610451036");
        assertEquals(50.0, student.getScore());
    }

    @Test
    @DisplayName("Should not give score to non-existing student")
    public void testGiveScoreToIdNotFound() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6610451036", "Pawat");

        studentList.giveScoreToId("6610451040", 50.0);
        Student student = studentList.findStudentById("6610451040");
        assertNull(student);
    }

    @Test
    @DisplayName("Should view grade of a student by id")
    public void testViewGradeOfId() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6610451036", "Pawat", 85.0);

        String grade = studentList.viewGradeOfId("6610451036");
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("Should return null if viewing grade for non-existing student")
    public void testViewGradeOfIdNotFound() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6610451036", "Pawat", 85.0);

        String grade = studentList.viewGradeOfId("6610451040");
        assertNull(grade);
    }

    @Test
    @DisplayName("Should return list of students")
    public void testGetStudents() {
        StudentList studentList = new StudentList();
        studentList.addNewStudent("6610451036", "Pawat");
        studentList.addNewStudent("6610451037", "John");

        ArrayList<Student> students = studentList.getStudents();
        assertEquals(2, students.size());
    }
}
