package vn.hoangptit.tiger.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Create file JdbcConnectionPool
 *
 * @author duyhoangptit
 * @since 6/8/2019
 */
public class JdbcConnectionPool {
    List<Connection> availableConnections = new ArrayList<>();

    public JdbcConnectionPool() {
        initializeConnectionPool();
    }


    public void initializeConnectionPool() {
        while (!checkIfConnectionPoolIsFull()) {
            availableConnections.add(createNewConnectionPool());
        }
    }

    private synchronized boolean checkIfConnectionPoolIsFull() {
        final int MAX_POOL_SIZE = 10;

        if (availableConnections.size() < MAX_POOL_SIZE) {
            return false;
        }

        return true;
    }

    private Connection createNewConnectionPool() {
        try {
            Class.forName("driver");
            Connection connection = DriverManager.getConnection("url", "name", "password");

            return connection;
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    public synchronized Connection getConnectionFromPool() {
        Connection conn = null;
        if (availableConnections.size() > 0) {
            conn = availableConnections.get(0);
            availableConnections.get(0);
        }

        return conn;
    }

    public synchronized void returnConnectionToPool(Connection conn) {
        availableConnections.add(conn);
    }
}
