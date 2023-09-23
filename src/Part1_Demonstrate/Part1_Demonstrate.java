package Part1_Demonstrate;

import java.util.Calendar;

class Student {

    public Student(int num){
        System.out.printf("Part1_Demonstrate.Student %d : \n", num);
    }

    public String name;
    public String surname;

    private String program;

    private int enrolmentYear;

    //Assignments
    private int numberOfAssignments;
    public int getNumberOfAssignments(){
        return numberOfAssignments;
    }
    public void setNumberOfAssignments(int numberOfAssignments){
        this.numberOfAssignments = numberOfAssignments;
    }

    //Grades
    private double[] grades = new double[100];
    public void setGrade(int assignmentIndex, double assignmentPoints){
        grades[assignmentIndex] = assignmentPoints;
    }
    public double getGrade(int assignmentIndex){
        return grades[assignmentIndex];
    }

    //getTotalPoints
    public double getTotalPoints(){
        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return sum;
    }



    //get-set program
    public String getProgram(){
        return program;
    }
    public void setProgram(String program){
        this.program = program;
    }

    //get-set enrolmentYear
    public int getEnrolmentYear(){
        return enrolmentYear;
    }
    public void setEnrolmentYear(int enrolmentYear){
        this.enrolmentYear = enrolmentYear;
    }

    //printStudentInfo
    public void printStudentInfo(){
        System.out.printf("%s %s %s\n%d-%d %d\nTotal : %.2f",name,surname, program, enrolmentYear,getGraduationYear(),getYearOfStudy(getEnrolmentYear()), getTotalPoints());
    }

    //getYearOfStudy
    public int getYearOfStudy(int enrolmentYear){
        int year = Calendar.getInstance().get(Calendar.YEAR) - enrolmentYear + 1;
        return year;
    }

    //getGraduationYear
    public int getGraduationYear(){
        int year = getEnrolmentYear() + 3;
        return year;
    }
}

public class Part1_Demonstrate {
    public static void main(String[] args) {
        Student std = new Student(37);
        std.name = "Taras";
        std.surname = "Khanas";
        std.setProgram("BDS");
        std.setEnrolmentYear(2023);
        std.setNumberOfAssignments(3);
        std.setGrade(1, 5);
        std.setGrade(2, 7);
        std.setGrade(3, 10);


        std.printStudentInfo();

    }
}
