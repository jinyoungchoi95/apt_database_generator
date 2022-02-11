package dao;

import domain.Apt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.db.DBClose;
import util.db.DBConnection;

public class AptJdbcRepository implements AptRepository {

    @Override
    public void save(Apt apt) {
        PreparedStatement pstmt = null;
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "insert into apt "
                + "(sido_name, gungu_name, dong_name, road_name, road_apt_num, apt_number, zip_code, apt_name) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, apt.getSidoName());
            pstmt.setString(2, apt.getGunguName());
            pstmt.setString(3, apt.getDongName());
            pstmt.setString(4, apt.getRoadName());
            pstmt.setString(5, apt.getRoadAptNum());
            pstmt.setString(6, apt.getAptNumber());
            pstmt.setInt(7, apt.getZipCode());
            pstmt.setString(8, apt.getAptName());
            pstmt.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            DBClose.close(pstmt);
        }
    }
}
