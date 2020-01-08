
package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConfig {
    public static Connection makeConnection() 
        throws NamingException, SQLException{    
       
        Context context = new InitialContext(); // get current os info
        Context tomcatCtx = (Context) context.lookup("java:comp/env");
        
        DataSource ds = (DataSource) tomcatCtx.lookup("DS1999");
        
        Connection con = ds.getConnection();
        
        return con;
     
    }
}
