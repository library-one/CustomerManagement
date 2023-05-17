import java.sql.*;
import java.util.ArrayList;


public class phoneDBO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;

    connectDB db = new connectDB();

    phoneDBO() {conn = db.connect();}

    public ArrayList<PhoneMathod> phoneList(){
        ArrayList<PhoneMathod> list = new ArrayList();
        String sql = "select * from user";
        try {
            stmt = conn.createStatement();
            ResultSet rs = this.stmt.executeQuery(sql);

            while(rs.next()) {
                PhoneMathod bean = new PhoneMathod(
                        rs.getString("name"),
                        rs.getString("phone"));
                list.add(bean);
            }
        } catch (SQLException var5) {
            var5.printStackTrace();
            System.out.println("쿼리 출력 오류 : " + var5);
        }

        return list;
    }
    public boolean insertPhone(PhoneMathod bean) {
        boolean success = false;
        String sql = "insert into user(name, phone) values(?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getName());
            pstmt.setString(2, bean.getPhone());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                success = true;
            } else {
                success = false;
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return success;
    }
    public boolean updatePhone(PhoneMathod bean) {
        boolean success = false;
        String sql = "update user set phone=? where name=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getPhone());
            pstmt.setString(2, bean.getName());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                success = true;
            } else {
                success = false;
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return success;
    }
    public boolean deletePhone(PhoneMathod bean) {
        boolean success = false;
        String sql = "delete from user where name=?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bean.getName());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                success = true;
            } else {
                success = false;
            }
        } catch (SQLException var6) {
            var6.printStackTrace();
        }

        return success;
    }
}
