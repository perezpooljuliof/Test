package mx.com.example.test.dto;

public class Student {
	private int studentId;
    private String studentName;
    
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public String toString() {
    	return studentName + "[" + studentId + "]";
    }
}
