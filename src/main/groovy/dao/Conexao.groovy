package dao

import groovy.sql.Sql
import java.sql.SQLException

class Conexao {

    static Sql getConexao() {
        def url= 'jdbc:postgresql://localhost:5432/linketinder'
        def user = 'tx'
        def password = 'nathantx'
        def driver = 'org.postgresql.Driver'

        try {
            return Sql.newInstance(url, user, password, driver)
        } catch (SQLException e) {
            println "🚨 Erro ao conectar com o banco de dados: ${e.message}"
            return null
        }
    }
}