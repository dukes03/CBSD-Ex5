package studentdatabasewithdbclass;


public class student {
    
    private int id;
    private String name;
    private double gpa;
    
    public student() {
        
    }
    public student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    
    public double getgpa() {
        return gpa;
    }

    public void setgpa(double gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}