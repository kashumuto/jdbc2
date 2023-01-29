import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            String URL = "jdbc:postgresql://localhost:5432/jdbc2";
            String USER = "postgres";
            String PASSWORD = "postgres";

            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from orders where cafe_id = 2");
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String descript = resultSet.getString(3);
                    System.out.printf("%d %s - %s \n",id,name,descript);
                }
            } catch (Exception ex) {
                System.out.println("Connection failed...");
                System.out.println(ex);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
