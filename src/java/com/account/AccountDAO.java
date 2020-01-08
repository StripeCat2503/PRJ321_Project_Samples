package com.account;

import com.db.DBConfig;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

public class AccountDAO implements Serializable {

    private String lastname;
    
    public String getLastname(){
        return this.lastname;
    }
    
    public boolean checkLogin(String username, String password) throws SQLException, NamingException {
        // 1. Open connection
        Connection connection = null;
        PreparedStatement prepareStm = null;
        ResultSet resultSet = null;

        try {
            connection = DBConfig.makeConnection();
            if (connection != null) {
                // 2. Create SQL query String
                String sql = "select username, password, lastname, isAdmin from tblaccount"
                        + " where username = ? and password = ?";

                // 3. Create statement and set value to parameter
                prepareStm = connection.prepareStatement(sql);
                prepareStm.setString(1, username);
                prepareStm.setString(2, password);

                // 4. Execute query
                resultSet = prepareStm.executeQuery();

                // 5. Process result
                if (resultSet.next()) {
                    this.lastname = resultSet.getString("lastname");
                    return true;
                }
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (prepareStm != null) {
                prepareStm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return false;
    }

    private List<AccountDTO> accountList;

    public List<AccountDTO> getAccountList() {
        return accountList;
    }

    public void searchLastName(String searchValue)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement preStm = null;
        ResultSet rs = null;

        try {
            con = DBConfig.makeConnection();
            if (con != null) {
                String sql = "select username, password, lastname, isAdmin "
                        + "from tblaccount where lastname like ?";

                preStm = con.prepareStatement(sql);
                preStm.setString(1, "%" + searchValue + "%");

                rs = preStm.executeQuery();

                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");

                    AccountDTO dto = new AccountDTO(username, password, lastname, role);
                    if (this.accountList == null) {
                        this.accountList = new ArrayList<>();
                    }
                    this.accountList.add(dto);
                }
            }
        } finally {

        }
    }

    public boolean deleteAccount(String username) throws SQLException, NamingException {
        // 1. Open connection
        Connection connection = null;
        PreparedStatement prepareStm = null;

        try {
            connection = DBConfig.makeConnection();
            if (connection != null) {
                // 2. Create SQL query String
                String sql = "Delete from tblAccount "
                        + "where username = ?";

                // 3. Create statement and set value to parameter
                prepareStm = connection.prepareStatement(sql);
                prepareStm.setString(1, username);

                int row = prepareStm.executeUpdate();
                if (row > 0) {
                    return true;
                }
            }
        } finally {

            if (prepareStm != null) {
                prepareStm.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return false;
    }

    public boolean updateAccount(String username, String password, boolean role)
            throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement preStm = null;

        try {
            con = DBConfig.makeConnection();
            if (con != null) {
                String sql = "Update tblAccount "
                        + "set password = ?, isAdmin = ? "
                        + "where username = ?";

                preStm = con.prepareStatement(sql);

                preStm.setString(1, password);
                preStm.setBoolean(2, role);
                preStm.setString(3, username);

                int result = preStm.executeUpdate();

                if (result > 0) {
                    return true;
                }
            }
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (con != null) {
                con.close();
            }
        }

        return false;
    }

    public boolean createAccount(String username, String password, String lastname, boolean role) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBConfig.makeConnection();
            if (con != null) {
                String sql = "insert into tblAccount(username, password, lastname, isAdmin) "
                        + "values(?,?,?,?)";

                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, lastname);
                stm.setBoolean(4, role);

                int result = stm.executeUpdate();

                if (result > 0) {
                    return true;
                }

            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return false;
    }
}
