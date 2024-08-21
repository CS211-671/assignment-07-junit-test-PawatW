package ku.cs.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class StudentTest {
    Student s;
    @BeforeEach
    void setUp() {
        s = new Student("6610451036", "Pawat", 75.0);
    }
    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 45.15 คะแนน")
    void testAddScore(){
        assertEquals(0, s.getScore());
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
        s.addScore(10.15);
        assertEquals(55.30, s.getScore());

    }
    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        s.addScore(70);
        assertEquals("B", s.grade());
    }
    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testId(){
        s.addScore(70);
        assertEquals("B", s.grade());
    }
    @Test
    public void testStudentConstructor() {
        assertEquals("6610451036", s.getId());
        assertEquals("Pawat", s.getName());
        assertEquals(75.0, s.getScore());
    }

    @Test
    public void testChangeName() {
        s.changeName(" John  ");
        assertEquals("John", s.getName());
    }

    @Test
    public void testIsId() {
        Student s = new Student("6610451036", "Pawat", 75.0);
        assertTrue(s.isId("6610451036"));
    }
}