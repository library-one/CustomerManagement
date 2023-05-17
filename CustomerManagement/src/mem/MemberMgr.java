package mem;
import db.DBConnectionMgr;
import java.sql.*;
import java.util.Vector;

public class MemberMgr {
    private DBConnectionMgr pool = null;

    public MemberMgr(){
        try {
            pool = DBConnectionMgr.getInstance();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public Vector<MemberBean> getMemberList(){
        Connection conn = null;
        PreparedStatement pstmt =null;
        ResultSet rs = null;
        Vector<MemberBean> vlist = new Vector<MemberBean>();
        try{
            conn = pool.getConnection();
            String strQuery = "select * from member";
            pstmt = conn.prepareStatement(strQuery);
            rs = pstmt.executeQuery();
            while(rs.next()){
                MemberBean bean = new MemberBean();
                bean.setId(rs.getString("id"));
                bean.setPwd(rs.getString("pwd"));
                bean.setName(rs.getString("name"));
                bean.setBirthday(rs.getString("birthday"));
                bean.setEmail(rs.getString("email"));
                vlist.addElement(bean);
            }
        }catch (Exception ex){
            System.out.println("Exception" + ex);
        }finally {
            pool.freeConnection(conn);
        }
        return vlist;
    }
}
