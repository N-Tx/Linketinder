package dao

import database.DatabaseConnectionProvider
import model.Vaga
import groovy.sql.Sql

class VagaDAO {

    void salvar(Vaga vaga) {

        def provider = DatabaseConnectionProvider.getProvider("postgres")
        Sql db = provider.getConnection()

        if (db != null) {
            try {
                db.executeInsert("""
                    INSERT INTO vagas (nome, descricao, empresa_id) 
                    VALUES (${vaga.nome}, ${vaga.descricao}, ${vaga.idEmpresa})
                """)
            } catch (Exception e) {
                println "Erro ao salvar vaga: ${e.message}"
            } finally {
                db.close()
            }
        }
    }

    List<Vaga> listar() {

        def provider = DatabaseConnectionProvider.getProvider("postgres")
        Sql db = provider.getConnection()
        List<Vaga> lista = []

        if (db != null) {
            try {
                db.eachRow("SELECT * FROM vagas ORDER BY id") { row ->
                    Vaga vagaObj = new Vaga(
                            id: row.id,
                            nome: row.nome,
                            descricao: row.descricao,
                            idEmpresa: row.empresa_id
                    )
                    lista << vagaObj
                }
            } catch (Exception e) {
                println "Erro ao listar vagas: ${e.message}"

            } finally {
                db.close()
            }
        }
        return lista
    }
}