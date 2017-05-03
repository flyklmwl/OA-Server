
import java.sql.*;

public class ConnectSQL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getAll();
	}
	public static Connection getConn () {
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";  
		String dbURL="jdbc:sqlserver://192.168.1.8:1433;DatabaseName=ecology";  
		String userName="sa";  
		String userPwd="usc@201605"; 
		Connection conn = null;
		  
		try {  
			Class.forName(driverName);  
			conn = (Connection)DriverManager.getConnection(dbURL,userName,userPwd);  
		    System.out.println("连接成功");  
		}  
		catch(Exception e) {  
		   e.printStackTrace();  
		   System.out.print("连接失败");  
		}  
		return conn;
	}
	
	public static ResultSet getRs() {  
	    Connection conn = getConn();  
	    String sql = "select t1.id,t1.loginid,t2.id from (select HrmResource.id,loginid,departmentmark,managerid,seclevel from HrmResource inner join hrmdepartment on HrmResource.departmentid=hrmdepartment.id where len(HrmResource.loginid) <> 0) t1 left join (select * from HrmResource) t2 on t1.managerid = t2.id order by t1.id";  
	    PreparedStatement pstmt;  
	    ResultSet rs = null;
	    try {  
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);  
	        rs = pstmt.executeQuery();  
	    } catch (SQLException e) {  
	        e.printStackTrace();  
	    }  
	    
	    return rs;  
	}  
	
	public static void getAll() {  
	    Connection conn = getConn();  
	    String sql = "select t1.id,t1.loginid,t2.id from (select HrmResource.id,loginid,departmentmark,managerid,seclevel from HrmResource inner join hrmdepartment on HrmResource.departmentid=hrmdepartment.id where len(HrmResource.loginid) <> 0) t1 left join (select * from HrmResource) t2 on t1.managerid = t2.id order by t1.id";  
	    PreparedStatement pstmt;  
	    ResultSet rs = null;
	    try {  
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);  
	        rs = pstmt.executeQuery();  
	        int col = rs.getMetaData().getColumnCount();  	        
	        System.out.println("============================");  
	        while (rs.next()) {  
	            for (int i = 1; i <= col; i++) {  
	                System.out.print(rs.getString(i) + "\t");  
	                if ((i == 2) && (rs.getString(i).length() < 8)) {  
	                    System.out.print("\t");  
	                }  
	             }  
	            System.out.println("");  
	        }  
	            System.out.println("============================");
	      
	    } catch (SQLException e) {  
	        e.printStackTrace();  
	    } 
	}
}
