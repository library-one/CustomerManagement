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
    public boolean insetMember(MemberBean bean){
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean success  =false;

        try{
            conn = pool.getConnection();
            String sql = "insert into member values (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getId());
            pstmt.setString(2, bean.getPwd());
            pstmt.setString(3, bean.getName());
            pstmt.setString(4, bean.getBirthday());
            pstmt.setString(5, bean.getEmail());
            int result = pstmt.executeUpdate();

            if(result >0){
                success = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            pool.freeConnection(conn,pstmt);
        }
        return success;
    }

}
