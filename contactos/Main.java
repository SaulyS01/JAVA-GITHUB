import data.ConnectionBD;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT * FROM users";
        try {
            Statement st = ConnectionBD.connectSQLite().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}
