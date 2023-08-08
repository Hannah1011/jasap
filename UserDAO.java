package users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DatabaseUtil;

public class UserDAO {
    Connection conn = DatabaseUtil.getConnection();

    public int join(String studentID, String nickname) {
        String SQL = "INSERT INTO users VALUES (?, ?)";
        try {
            // ������ �����͸� ������ �־��ش�.
            PreparedStatement pstmt = conn.prepareStatement(SQL);

            // �������� ?�ȿ� ������ �����͸� �־��ش�.
            pstmt.setString(1, studentID);
            pstmt.setString(2, nickname);

            // ��ɾ ������ ��� ��ȯ, ��ȯ��: insert�� �� �������� ����
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                // ������ ������ ������ ���
                return 1;
            } else {
                // ������ ������ ������ ���
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // ���� �߻� ��
        }
    }

    public String getNicknameByStudentID(String studentID) {
        String SQL = "SELECT nickname FROM users WHERE studentID = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, studentID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("nickname");
            }
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
