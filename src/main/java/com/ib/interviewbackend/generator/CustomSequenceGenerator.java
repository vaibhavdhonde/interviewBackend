package com.ib.interviewbackend.generator;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomSequenceGenerator implements IdentifierGenerator {

    private static final String PREFIX = "RH";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        Connection connection = null;
        try {
            connection = session.getJdbcConnectionAccess().obtainConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT MAX(CAST(SUBSTRING(rh01, 3) AS UNSIGNED)) FROM interview");
            if (rs.next()) {
                int maxId = rs.getInt(1);
                return PREFIX + String.format("%02d", maxId + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    session.getJdbcConnectionAccess().releaseConnection(connection);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return PREFIX + "01";
    }
}
