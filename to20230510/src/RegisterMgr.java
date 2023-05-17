import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Vector;

public class RegisterMgr {
    private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String JDBC_URL = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
    private final String USER = "jaewon";
    private final String PASS = "aq@97524123";

    public RegisterMgr() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR: JDBC 드라이버 로딩 실패");
            e.printStackTrace();
        }
    }

    public Vector<MemberBean> getRegisterList() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        Vector<MemberBean> mlist = new Vector<MemberBean>();

        try{
            conn = DriverManager.getConnection(JDBC_URL,USER,PASS);
            stmt = conn.createStatement();
            String strQuery = "select * from member";
            rs = stmt.executeQuery(strQuery);

            while(rs.next()){
                MemberBean bean = new MemberBean();
                bean.setId(rs.getString("id"));
                bean.setPwd(rs.getString("pwd"));
                bean.setName(rs.getString("name"));
                bean.setBirthday(rs.getString("birthday"));
                bean.setEmail(rs.getString("email"));
                mlist.add(bean);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            if(rs != null){try {rs.close();} catch (SQLException e) {throw new RuntimeException(e);}}
            if(stmt != null){try {stmt.close();} catch (SQLException e) {throw new RuntimeException(e);}}
            if(conn != null){try {conn.close();} catch (SQLException e) {throw new RuntimeException(e);}}
        }

        return mlist;
    }
    public static void main(String[] args) {
        new RegisterMgr();
    }
}
