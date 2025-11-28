import java.sql.*;

public class ConexaoDB {

    private static final String url = "jdbc:postgresql://localhost:5432/eventosdb";
    private static final String user = "postgres";
    private static final String password = "postgres";

        public static Connection getConnection()
        {
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Conectado ao banco de dados! \n");
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }

            return conn;
                
        }
        

    }

