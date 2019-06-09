package vn.hoangptit.tiger.config;

import java.sql.Connection;

/**
 * Create file DataSource
 *
 * @author duyhoangptit
 * @since 6/8/2019
 */
public class DataSource {

    static JdbcConnectionPool pool = new JdbcConnectionPool();

    public static Connection getConnection() {
        Connection conn = pool.getConnectionFromPool();
        return conn;
    }

    public static void returnConnection(Connection conn) {
        pool.returnConnectionToPool(conn);
    }
}
