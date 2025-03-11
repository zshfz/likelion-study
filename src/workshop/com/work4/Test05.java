package workshop.com.work4;

public class Test05 {

    public static void main(String[] args) {
        Student s1 = new Student("Kim", 100, 90, 95, 89);
        Student s2 = new Student("Lee", 60, 70, 99, 98);
        Student s3 = new Student("Park", 68, 86, 60, 40);
        
        System.out.println(s1.getName() + " 평균: " + s1.getAvg() + " 학점: " + s1.getGrade());
        System.out.println(s2.getName() + " 평균: " + s2.getAvg() + " 학점: " + s2.getGrade());
        System.out.println(s3.getName() + " 평균: " + s3.getAvg() + " 학점: " + s3.getGrade());
    }
}

class Student {
    private String name;
    private int korean;
    private int english;
    private int math;
    private int science;
    
    public Student() {
        super();
    }

    public Student(String name, int korean, int english, int math, int science) {
        super();
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
        this.science = science;
    }

    public String getName() {
        return name;
    }

    // 평균 계산
    public double getAvg() {
        return (korean + english + math + science) / 4.0;
    }
    
    // 학점 계산
    public String getGrade() {
        double avg = getAvg();
        
        if (avg >= 90) {
            return "A";
        } else if (avg >= 70) {
            return "B";
        } else if (avg >= 50) {
            return "C";
        } else if (avg >= 30) {
            return "D";
        } else {
            return "F";
        }
    }
}
