package dbHelpers;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_URL = "jdbc:mariadb://104.237.9.33/dbkoel";
    private static final String USER = "dbuser03";
    private static final String PASSWORD = "pa$$03";

    static java.sql.Connection connection = null;
    static Statement statement = null;

    public static ResultSet makeConnectionAndExecuteQuery(String query) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);//starts the driver

        connection = DriverManager.getConnection(DB_URL,USER,PASSWORD);//make connection
        statement = connection.createStatement();//make connection a statement,
        //connection is a pipe, statement is a parcel travelling in the pipe

        ResultSet result = statement.executeQuery(query);
        return result;
    }

    public static void checkAndCloseConnection(){
        if(connection!=null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
