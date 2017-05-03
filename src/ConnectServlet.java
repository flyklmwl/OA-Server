import java.io.IOException;
import java.io.PrintWriter;  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

public class ConnectServlet extends HttpServlet {  
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();  
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");  
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");  
        out.println("  <BODY>");  
        //�����й�jdbc�ķ���  
        try {  
            doSometing(out);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
          
        out.println("  </BODY>");  
        out.println("</HTML>");  
        out.flush();  
        out.close();  
    }  
    public void doSometing(PrintWriter out) throws SQLException,  
            ClassNotFoundException {  
        /* 
         * ��ݿ����ӵ�һ���� 
         *      1.����JDBC����� 
         *      2.��������URL  
         *      3.��������  
         *      4.����Statement���� 
         *      5.ִ�в�ѯ����� 
         *      6.�����  
         *      7.�ر����� 
         */  
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");// 1  
        String dbURL="jdbc:sqlserver://192.168.1.8:1433;DatabaseName=ecology";
        //String url = "jdbc:odbc:odbcYuan";// 2 ����odbc��ϵͳdsn�е����Դ���  
        Connection connection = DriverManager.getConnection(dbURL, "sa","usc@201605");// 3  
        Statement statement = connection.createStatement();// 4  
        fun(statement, out);// 5,6  
        statement.close();// 7  
        connection.close();// 7  
    }  
    private void fun(Statement statement, PrintWriter out) throws SQLException {  
          
        // ����һ���?����Ϊ Users�����ֶ�name��password��email  
        //String command = "create table Users (name varchar(16) not null,password varchar(8) not null,email varchar(40) null)";  
        //statement.execute(command);  
        //�ڱ�Users�в���3����¼  
        //statement.executeUpdate("insert into Users values('ZhangSan','1234','ZhangSan@qq.com')");  
        //statement.executeUpdate("insert into Users values('ZhangXinqiang','lloveyou','barryhappy@gmail.com')");  
        //statement.executeUpdate("insert into Users values('LiuErgou','dogdog','dogliu@163.com')");  
        //���ұ�Users�����м�¼�����ÿ����¼���ֶΡ�email����ֵ  
        ResultSet result = statement.executeQuery("select t1.id,t1.loginid,t1.departmentmark,t1.seclevel,t2.loginid,t1.mobile from (select HrmResource.id,loginid,departmentmark,managerid,seclevel,HrmResource.mobile from HrmResource inner join hrmdepartment on HrmResource.departmentid=hrmdepartment.id where len(HrmResource.loginid) <> 0) t1 left join (select * from HrmResource) t2 on t1.managerid = t2.id order by seclevel desc,departmentmark");  
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>");
        out.println("���");
        out.println("</th>");
        out.println("<th>");
        out.println("����");
        out.println("</th>");
        out.println("<th>");
        out.println("����");
        out.println("</th>");
        out.println("<th>");
        out.println("��ȫ����");
        out.println("</th>");
        out.println("<th>");
        out.println("ֱ���ϼ�");
        out.println("</th>");
        out.println("<th>");
        out.println("�绰����");
        out.println("</th>");
        out.println("</tr>");
        while (result.next()) {  
            //out.println("<h4>" + result.getString("email") + "</h4>");         	
            out.println("<tr>" + "<td>" + result.getString("id") + "</td>" + "<td>" + result.getString("loginid") + "</td>" + "<td>" + result.getString("departmentmark") + "</td>" + "<td>" + result.getString("seclevel") + "</td>" + "<td>" + result.getString(5) + "</td>" + "<td>" + result.getString(6) + "</td>" + "</tr>");      
        }  
        out.println("</table>");
        result.close();// 7  
    }  
}  