import java.sql.*;

public class AccountDAO {

	public static void main(String[] args) {
		
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "root");
				Statement statement = connection.createStatement();){
			System.out.println(connection);
			//int result = statement.executeUpdate("insert into account values(1,'sonawane','darshan',1000000)");
			//System.out.println(result);
			//int result = statement.executeUpdate("update account set bal=5000000 where accno=1");
			//int result = statement.executeUpdate("delete from account where accno=1");
			//System.out.println(result);
			statement.executeUpdate("insert into account values(1,'sonawane','darshan',1000000)");
			statement.executeUpdate("insert into account values(1,'sonawane','divyesh',2000000)");
			ResultSet rs = statement.executeQuery("select * from account");
			while(rs.next()) {
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString(3)+" ");
				System.out.print(rs.getInt(4)+ " ");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
