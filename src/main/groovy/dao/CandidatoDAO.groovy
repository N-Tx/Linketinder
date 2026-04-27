package dao

import model.Competencia
import model.User
import database.DatabaseConnectionProvider
class CandidatoDAO {


    int salvar(User candidato) {
        def provider = DatabaseConnectionProvider.getProvider("postgres")
        def db = provider.getConnection()
        int idGerado = -1

        if (db != null) {
            try {
                String query = "INSERT INTO candidato (nome, sobrenome, email, telefone, data_nascimento, pais, cpf, cep, descricao) VALUES (?, ?, ?, ?, ?::date, ?, ?, ?, ?) RETURNING id"

                def row = db.firstRow(query, [
                        candidato.nome,
                        candidato.sobrenome,
                        candidato.email,
                        candidato.telefone,
                        candidato.data_nascimento,
                        candidato.pais,
                        candidato.cpf,
                        candidato.cep,
                        candidato.descricao

                ])

                if (row != null) {
                    idGerado = row.id
                    println "Candidato salvo com sucesso! ID: ${idGerado}"
                }
            } catch (Exception e) {
                println " Erro ao salvar candidato no banco: ${e.message}"
            }
        }
        return idGerado
    }

    List<User> listar() {
        def provider = DatabaseConnectionProvider.getProvider("postgres")
        def db = provider.getConnection()
        List<User> lista = []
        if (db != null) {
            try {
                db.eachRow("SELECT * FROM candidato ORDER BY id") { row ->
                    lista << new User (id: row.id, nome: row.nome)
                }
            } catch (Exception e) {
                println " Erro ao listar usuarios: ${e.message}"
            } finally {
                db.close()
            }
        }
        return lista
    }


    void vincularCompetencia(int idCandidato, int idCompetencia) {
        def provider = DatabaseConnectionProvider.getProvider("postgres")
        def db = provider.getConnection()
        if (db != null) {
            try {
                String query = "INSERT INTO candidato_competencia (candidato_id, competencia_id) VALUES (?, ?)"
                db.executeInsert(query, [idCandidato, idCompetencia])
            } catch (Exception e) {
                println "Erro ao vincular competência: ${e.message}"
            }
        }
    }
}