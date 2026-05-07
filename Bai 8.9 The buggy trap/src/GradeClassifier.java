public class GradeClassifier {
    public static String classifyGrade(double gpa) {
        if (gpa < 0.0 || gpa > 10.0) {
            throw new IllegalArgumentException("GPA khong hop le: " + gpa);
        }
        if (gpa < 5.0)  return "Yeu";
        if (gpa < 6.5)  return "Trung binh";
        if (gpa < 8.0)  return "Kha";
        return "Gioi";
    }
}