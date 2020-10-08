package org.example.sequence;

public class StudentSequence {

    private static int studentSequence;

    public static int nextStudentId() {
        return ++ studentSequence;
    }
    public static int getStudentSequence() {
        return studentSequence;
    }
}
