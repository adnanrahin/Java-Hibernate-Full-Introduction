import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManagerTest {

    public static void main(String[] args) {

        try {

            String url = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false";
            String userName = "hbstudent";
            String password = "hbstudent";

            Connection connection = DriverManager.getConnection(url, userName, password);

            System.out.println(connection.getMetaData());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }

    }
}
