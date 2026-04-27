package database

import groovy.sql.Sql

class PostgresConnectionProvider implements ConnectionProvider {

    private static Sql instance

    private PostgresConnectionProvider() {}

    @Override
    Sql getConnection() {
        if (instance == null) {
            def url = 'jdbc:postgresql://localhost:5432/linketinder'
            def user = 'tx'
            def password = 'nathantx'
            def driver = 'org.postgresql.Driver'

            instance = Sql.newInstance(url, user, password, driver)
        }
        return instance
    }
}