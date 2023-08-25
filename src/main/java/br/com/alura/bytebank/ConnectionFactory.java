package br.com.alura.bytebank;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() {
        try {

            return createDataSource().getConnection();
            /*return DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/teste?user=tiago&password=tiago");*/

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

}

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/teste");
        config.setUsername("tiago");
        config.setPassword("tiago");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}
