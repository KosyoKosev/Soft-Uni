package Students;

public class Student {

    public static Integer counter = 0;

    private String name;

    public Student(String name) {
        this.name = name;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
