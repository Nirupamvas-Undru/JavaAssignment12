import java.util.*;
import java.util.stream.Collectors;

public class Student
{
    int id;
    String name;
    int age;
    String gender;
    String engDepartment;
    int yearOfEnrollment;
    double perTillDate;

    public Student(int id, String name, int age, String gender, String engDepartment, int yearOfEnrollment, double perTillDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.engDepartment = engDepartment;
        this.yearOfEnrollment = yearOfEnrollment;
        this.perTillDate = perTillDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEngDepartment() {
        return engDepartment;
    }

    public int getYearOfEnrollment() {
        return yearOfEnrollment;
    }

    public double getPerTillDate() {
        return perTillDate;
    }

    @Override
    public String toString()
    {
        return "Id : "+id
                +", Name : "+name
                +", age : "+age
                +", Gender : "+gender
                +", engDepartment : "+engDepartment
                +", Year Of Joining : "+yearOfEnrollment
                +", perTillDate : "+perTillDate;
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        studentList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        studentList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        studentList.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        studentList.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        studentList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        studentList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        studentList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        studentList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        studentList.add(new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        studentList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        studentList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        studentList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        studentList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        studentList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        studentList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        studentList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

        System.out.println("1. Print the name of all departments in the college?");
        studentList.stream().map(Student::getEngDepartment).distinct().forEach(System.out::println);


        System.out.println("2.Get the names of all students who have enrolled after 2018?");
        studentList.stream().filter(e -> e.getYearOfEnrollment() > 2018).map(Student::getName).forEach(System.out::println);


        System.out.println("3. Get the details of all male student in the computer sci department?");
        Optional<Student> MaleStudentInComputerDepartmentWrapper=
                studentList.stream()
                        .filter(e -> e.getGender()=="Male" && e.getEngDepartment()=="Computer Science")
                        .min(Comparator.comparingInt(Student::getAge));

        Student MaleStudentInComputerDepartment = MaleStudentInComputerDepartmentWrapper.get();

        System.out.println("Details Of Male Student In Computer Science Department");

        System.out.println("----------------------------------------------");

        System.out.println("ID : "+MaleStudentInComputerDepartment.getId());

        System.out.println("Name : "+MaleStudentInComputerDepartment.getName());

        System.out.println("Age : "+MaleStudentInComputerDepartment.getAge());

        System.out.println("Year Of Enrollment : "+MaleStudentInComputerDepartment.getYearOfEnrollment());

        System.out.println("Percentage till date : "+MaleStudentInComputerDepartment.getPerTillDate());


        System.out.println("4. How many male and female student are there ? (HINT:use Collectors.groupingBy() for grouping based on gender)");
        Map<String, Long> countMaleFemaleStudents=
                studentList.stream().filter(e -> e.getEngDepartment()=="").collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));
        System.out.println(countMaleFemaleStudents);


        System.out.println("5.What is the average age of male and female students?");
        Map<String, Double> avgAgeOfMaleAndFemaleStudent=
                studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
        System.out.println(avgAgeOfMaleAndFemaleStudent);


        System.out.println("6.Get the details of highest student having highest percentage ?");
        Optional<Student> highestPercentageStudentWrap=
                studentList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Student::getPerTillDate)));
        Student highestPercentageStudent = highestPercentageStudentWrap.get();

        System.out.println("Details Of Highest Paid Employee : ");

        System.out.println("==================================");

        System.out.println("ID : "+highestPercentageStudent.getId());

        System.out.println("Name : "+highestPercentageStudent.getName());

        System.out.println("Age : "+highestPercentageStudent.getAge());

        System.out.println("Gender : "+highestPercentageStudent.getGender());

        System.out.println("Engineering Department : "+highestPercentageStudent.getEngDepartment());

        System.out.println("Year Of Joining : "+highestPercentageStudent.getYearOfEnrollment());

        System.out.println("Percentage till date : "+highestPercentageStudent.getPerTillDate());


        System.out.println("7.Count the number of students in each department? (Hint :use Collectors.groupingBy())");
        Map<String, Long> studentCountByDepartment=
                studentList.stream().collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.counting()));

        Set<Map.Entry<String, Long>> entrySet = studentCountByDepartment.entrySet();

        for (Map.Entry<String, Long> entry : entrySet)
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }


        System.out.println("8. What is the average percentage achieved in each department?");
        Map<String, Double> avgSalaryOfDepartments=
                studentList.stream().collect(Collectors.groupingBy(Student::getEngDepartment, Collectors.averagingDouble(Student::getPerTillDate)));

        Set<Map.Entry<String, Double>> entrySetAvg = avgSalaryOfDepartments.entrySet();

        for (Map.Entry<String, Double> entry : entrySetAvg)
        {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }


        System.out.println("9. Get the details of youngest male student in the Electronic department?(Hint :Use Collectors.minBy)");
        Optional<Student> youngestMaleStudentInElectronicDevelopmentWrapper=
                studentList.stream()
                        .filter(e -> e.getGender()=="Male" && e.getEngDepartment()=="Electronic")
                        .min(Comparator.comparingInt(Student::getAge));

        Student youngestMaleStudentInElectronicDevelopment = youngestMaleStudentInElectronicDevelopmentWrapper.get();

        System.out.println("Details Of Youngest Male Student In Product Development");

        System.out.println("----------------------------------------------");

        System.out.println("ID : "+youngestMaleStudentInElectronicDevelopment.getId());

        System.out.println("Name : "+youngestMaleStudentInElectronicDevelopment.getName());

        System.out.println("Age : "+youngestMaleStudentInElectronicDevelopment.getAge());

        System.out.println("Year Of Enrollment : "+youngestMaleStudentInElectronicDevelopment.getYearOfEnrollment());

        System.out.println("Percentage till date : "+youngestMaleStudentInElectronicDevelopment.getPerTillDate());

        System.out.println("10.How many male and female students are there in the computer science department?");

        Map<String, Long> countMaleFemaleStudentComputerScience=
                studentList.stream()
                        .filter(e -> e.getEngDepartment()=="Computer Science")
                        .collect(Collectors.groupingBy(Student::getGender, Collectors.counting()));

        System.out.println(countMaleFemaleStudentComputerScience);
    }
}
