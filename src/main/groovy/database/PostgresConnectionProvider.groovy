package database

import groovy.sql.Sql
import java.sql.Connection
import java.util.Properties
import org.postgresql.Driver

class PostgresConnectionProvider implements ConnectionProvider {

    @Override
    Sql getConnection() {
        try {
            String url = 'jdbc:postgresql://localhost:5432/linketinder'

            // 1. Instanciamos o Driver do Postgres diretamente
            Driver pgDriver = new Driver()

            // 2. Colocamos o usuário e senha nas Propriedades
            Properties props = new Properties()
            props.setProperty("user", "tx")
            props.setProperty("password", "nathantx")

            // 3. Pedimos a conexão DIRETO pro driver, ignorando o DriverManager teimoso
            Connection conn = pgDriver.connect(url, props)

            // 4. Entregamos a conexão pronta e estabelecida para o Groovy SQL
            return new Sql(conn)

        } catch (Exception e) {
            println "====== ERRO NO BANCO DE DADOS ======"
            println "Erro detalhado: ${e.message}"
            println "===================================="
            throw e
        }
    }
}