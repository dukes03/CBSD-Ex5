package studentdatabasewithdbclass;

import java.sql.SQLException;
import java.util.ArrayList;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;


public class studentDatabaseWithDBClass {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/student";
        String user = "asdf";
        String passwd = "1234";
        DatabaseDriver dbDriver = new DatabaseDriver(driver, url, user, passwd);
        DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
        student emp1 = new student(1, "ma", 3);
        student emp2 = new student(2, "rin", 2);
        studentTable.insertstudent(dbHandler, emp1);
        studentTable.insertstudent(dbHandler, emp2);
        ArrayList<student> studentList = studentTable.findAllstudent(dbHandler);
        if (studentList != null) {
            printAllstudent(studentList);
        }
        dbHandler.closeConnection();
    }
    
    public static void printAllstudent(ArrayList<student> empList) {
        for(int i = 0; i < empList.size(); i++) {
            System.out.print(empList.get(i).getId() + " ");
            System.out.print(empList.get(i).getName() + " ");
            System.out.println(empList.get(i).getgpa() + " ");
        }
        
    }
}