
package program;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {


    public static void main (String[] args) {
        launch(args);
    }

    public static void showResults(ResultSet set) throws SQLException {
        ResultSetMetaData setMetaData = set.getMetaData();
        int columns = setMetaData.getColumnCount();
        String resultString = null;
        if(columns > 0){
            resultString = "\n\nStudents enrolled in CSC211 in the Fall 2019 semester and their GPAs\n" +
                    "============================================================================\n";
            for(int num = 1; num <= columns; num++){
                resultString += setMetaData.getColumnLabel(num) + "     ";
            }
            System.out.println(resultString);
            System.out.println("============================================================================");
            while(set.next()){
                resultString = "";
                for(int num = 1; num <= columns; num++){
                    String columnString = set.getString(num);
                    if(columnString!=null){
                        resultString += columnString + "    ";
                    }
                }
                System.out.println(resultString + '\n' +
                        "----------------------------------------------------------------------------");
            }
            set.beforeFirst();
        }


    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","Curupirahorse11235");
            System.out.println("Database Connection Succesfull");
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }
        catch(SQLException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }


        Statement studentStatement = conn.createStatement();
        studentStatement.execute("DROP TABLE IF EXISTS Students");
        boolean studentResult = studentStatement.execute("CREATE TABLE Students " +
                " (studentID int UNSIGNED NOT NULL, " +
                " PRIMARY KEY (studentID), firstName varchar(255), " +
                " lastName varchar(255), sex char(1))");

        Statement courseStatement = conn.createStatement();
        courseStatement.execute("DROP TABLE IF EXISTS Courses");
        boolean courseResult = courseStatement.execute("CREATE TABLE Courses " +
                " (courseID char(6), " +
                " PRIMARY KEY (courseID), courseTitle varchar(255), " +
                " department varchar(255))");

        Statement classesStatement = conn.createStatement();
        classesStatement.execute("DROP TABLE IF EXISTS Classes");
        boolean classesResult = classesStatement.execute("CREATE TABLE Classes " +
                " (classCode char(6), " +
                " PRIMARY KEY (classCode,StudentID), courseId char(6), " +
                " studentID int UNSIGNED NOT NULL, " +
                " year int UNSIGNED NOT NULL, " +
                " semester varchar(10), " +
                " GPA char(1))");

        boolean result = studentResult && courseResult && classesResult;
        System.out.print("Table creation result: " + !result + " (true is expected result)");

        Statement insert = conn.createStatement();
        // Inserting entries into the Students table (20)
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (23572639,'David','Balaban','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (19635214,'John','Smith','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (81275645,'Michael','Stone','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (35572639,'Lisa','Smith','F')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (61142341,'Marina','Tieko','F')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (91824612,'Isabelle','Amorim','F')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (18923791,'Alessandra','Balaban','F')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (98298424,'Daniel','Balaban','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (65782354,'Yuri','Balaban','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (78623842,'Tomas','Balaban','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (24236729,'Carol','Abreu','F')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (40958871,'Lourdes','Silva','F')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (90879324,'Laura','Pinto','F')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (51823741,'Diego','Spanish','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (38761231,'Kyle','Monster','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (23817628,'Stuart','Little','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (89676712,'Ariana','Grande','F')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (17653513,'Jose','Aldo','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (41236472,'Charlie','Days','M')");
        insert.execute("INSERT students (studentID,firstName,lastName,sex) VALUES (71562431,'Deandra','Reynolds','F')");

        // Inserting entries into the Courses table (3)
        insert.execute("INSERT courses (courseID,courseTitle,department) VALUES ('CSC210','Assembly Language','CSC')");
        insert.execute("INSERT courses (courseID,courseTitle,department) VALUES ('CSC211','Fund of Computer Systems','CSC')");
        insert.execute("INSERT courses (courseID,courseTitle,department) VALUES ('CSC221','Software Design Lab','CSC')");

        // Inserting entries into the Courses table
        //CSC210
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S18','CSC210',23572639,2018,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S18','CSC210',19635214,2018,'Spring','C')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S18','CSC210',24236729,2018,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S18','CSC210',81275645,2018,'Spring','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S18','CSC210',78623842,2018,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S18','CSC210',41236472,2018,'Spring','F')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S18','CSC210',90879324,2018,'Spring','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S19','CSC210',51823741,2019,'Spring','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S19','CSC210',23817628,2019,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S19','CSC210',89676712,2019,'Spring','C')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210S19','CSC210',61142341,2019,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210F18','CSC210',40958871,2018,'Fall','D')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210F18','CSC210',35572639,2018,'Fall','C')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210F18','CSC210',71562431,2018,'Fall','F')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210F18','CSC210',41236472,2018,'Fall','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210F18','CSC210',19635214,2018,'Fall','D')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210F19','CSC210',71562431,2019,'Fall','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210F19','CSC210',98298424,2019,'Fall','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210F19','CSC210',18923791,2019,'Fall','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210F19','CSC210',38761231,2019,'Fall','C')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('210F19','CSC210',89676712,2019,'Fall','D')");

        //CSC211
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S18','CSC211',23572639,2018,'Spring','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S18','CSC211',19635214,2018,'Spring','D')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S18','CSC211',24236729,2018,'Spring','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S18','CSC211',81275645,2018,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S18','CSC211',78623842,2018,'Spring','F')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S18','CSC211',41236472,2018,'Spring','W')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S18','CSC211',90879324,2018,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S19','CSC211',51823741,2019,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S19','CSC211',23817628,2019,'Spring','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S19','CSC211',89676712,2019,'Spring','D')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211S19','CSC211',61142341,2019,'Spring','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211F18','CSC211',40958871,2018,'Fall','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211F18','CSC211',35572639,2018,'Fall','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211F18','CSC211',71562431,2018,'Fall','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211F19','CSC211',41236472,2019,'Fall','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211F19','CSC211',19635214,2019,'Fall','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211F19','CSC211',71562431,2019,'Fall','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211F19','CSC211',98298424,2019,'Fall','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211F19','CSC211',18923791,2019,'Fall','C')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211F19','CSC211',38761231,2019,'Fall','C')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('211F19','CSC211',89676712,2019,'Fall','F')");

        //CSC221
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S18','CSC221',23572639,2018,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S18','CSC221',19635214,2018,'Spring','C')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S18','CSC221',24236729,2018,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S18','CSC221',81275645,2018,'Spring','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S18','CSC221',78623842,2018,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S18','CSC221',41236472,2018,'Spring','F')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S18','CSC221',90879324,2018,'Spring','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S19','CSC221',51823741,2019,'Spring','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S19','CSC221',23817628,2019,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S19','CSC221',89676712,2019,'Spring','C')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221S19','CSC221',61142341,2019,'Spring','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221F18','CSC221',40958871,2018,'Fall','D')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221F18','CSC221',35572639,2018,'Fall','C')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221F18','CSC221',71562431,2018,'Fall','F')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221F18','CSC221',41236472,2018,'Fall','A')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221F18','CSC221',19635214,2018,'Fall','D')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221F19','CSC221',71562431,2019,'Fall','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221F19','CSC221',98298424,2019,'Fall','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221F19','CSC221',18923791,2019,'Fall','B')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221F19','CSC221',38761231,2019,'Fall','C')");
        insert.execute("INSERT classes (classCode,courseID,studentID,year,semester,GPA) VALUES ('221F19','CSC221',89676712,2019,'Fall','D')");

        // Getting set from specified querry

        Statement returnStatement = conn.createStatement();
        ResultSet set = returnStatement.executeQuery("SELECT Students.StudentID as EMPLID, Students.firstName as Name, Classes.GPA FROM students INNER JOIN classes ON students.studentID = classes.studentID WHERE classes.courseID = 'CSC211' AND classes.semester = 'Fall' AND year = '2019' ORDER BY classes.GPA");

        showResults(set);

        ResultSet set2 = returnStatement.executeQuery("SELECT GPA, COUNT(*) FROM classes WHERE courseID = 'CSC211' AND semester = 'Fall' AND year = '2019' GROUP BY GPA ORDER BY GPA");

        double total = 0;
        int rows = 0;
        while(set2.next()){
            double value = set2.getDouble(2);
            total = total + value;
            rows++;
        }
        set2.beforeFirst();

        String[] letters = new String[rows];
        double[] frequency = new double[rows];
        int index = 0;
        while(set2.next()){
            String str = set2.getString(1);
            letters[index] = str;
            double freq = (set2.getDouble(2))/total;
            frequency[index] = freq;
            index++;
        }


        Scene scene;
        primaryStage.setTitle("CSC221 - Final Project; David Balaban");
        StackPane pane = new StackPane();
        scene = new Scene(pane,800,500);
        Canvas canvas = new Canvas(800,500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        pane.getChildren().add(canvas);
        MyPieChart chart = new MyPieChart(400,250,rows,frequency,letters);
        chart.draw(gc);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
