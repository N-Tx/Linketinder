package database

import groovy.sql.Sql

class PostgresConnectionProvider implements ConnectionProvider {

    @Override
    Sql getConnection() {
        try {
            String url = 'jdbc:postgresql://localhost:5432/linketinder'
            String user = 'tx'
            String password = 'nathantx'
            String driver = 'org.postgresql.Driver'

            // Retorna sempre uma nova instância
            return Sql.newInstance(url, user, password, driver)
        } catch (Exception e) {
            println "Erro ao conectar ao banco: ${e.message}"
            return null
        }
    }
}