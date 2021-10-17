package studentdatabasewithdbclass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DatabaseHandler;


public class studentTable {
    public static int updatestudent(DatabaseHandler dbHandler, student emp) {
        String sql = "update student set name=?, gpa=? where id=?";
        int rowUpdated;
        try {
            rowUpdated = dbHandler.update(sql, emp.getName(), emp.getgpa(), emp.getId());
        }
        catch (SQLException ex ) {
            
            rowUpdated = 0;
        }
        
        return rowUpdated;
    }
     public static int removestudent(DatabaseHandler dbHandler, student emp) {
         String sql ="delete from student where id = ?";
         
         int rowDeleted;
         try {
            rowDeleted = dbHandler.update(sql, emp.getId());
         }
         catch (SQLException ex ) {
             rowDeleted = 0;
         }
        return rowDeleted;
    }
    public static int insertstudent(DatabaseHandler dbHandler, student emp) {
         String sql = "insert into student (id, name, gpa)" + 
               " values (?,?,?)";
         
         int rowInserted;
         try {
             rowInserted = dbHandler.update(sql, emp.getId(), emp.getName(), emp.getgpa());
         }
         catch(SQLException ex ) {
             rowInserted = 0;
         }
         return rowInserted;
    } 
     public static student findstudentById(DatabaseHandler dbHandler, int id) throws SQLException {
        String sql = "select * from student where id = ?";
        ResultSet rs;
        student emp = null;
        rs = dbHandler.query(sql, id);
        if (rs.next()) {
           emp = new student();
           emp.setId(rs.getInt("id"));
           emp.setName(rs.getString("name"));
           emp.setgpa(rs.getDouble("gpa"));
       }
        return emp;
        
    }
    public static ArrayList<student> findstudentByName(DatabaseHandler dbHandler, String name) throws SQLException {
        String sql = "select * from student where name = ?";
        ResultSet rs;
        ArrayList<student> empList = null;
        rs = dbHandler.query(sql, name);
        empList = extractstudent(rs);
        return empList;
        
    } 
    public static ArrayList<student> findAllstudent(DatabaseHandler dbHandler) throws SQLException {
        String sql = "select * from student order by id";
        ResultSet rs; 
        ArrayList<student> empList = null;
        rs = dbHandler.query(sql);
        empList = extractstudent(rs);
        return empList;
    }
    private static ArrayList<student> extractstudent(ResultSet rs) {
        ArrayList<student> empList = new ArrayList<>();
        try {
            while(rs.next()) {
                student student = new student();
                try {
                    student.setId(rs.getInt("id"));
                    student.setName(rs.getString("name"));
                    student.setgpa(rs.getDouble("gpa"));
                } catch (SQLException ex) {
                    Logger.getLogger(studentTable.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                empList.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(studentTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(empList.size() == 0) {
            empList = null;
        }
        return empList;
    }
}