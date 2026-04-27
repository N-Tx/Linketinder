package dao
import database.DatabaseConnectionProvider
import model.Vaga

class VagaDAO {
    void salvar(Vaga vaga) {
        def provider = DatabaseConnectionProvider.getProvider("postgres")
        def db = provider.getConnection()
        if (db != null) {
            try {
                String query = "INSERT INTO vagas (nome, descricao, empresa_id) VALUES (?, ?, ?)"

                db.executeInsert(query, [
                        vaga.nome,
                        vaga.descricao,
                        vaga.idEmpresa
                ])
                println "SVaga cadastrada com sucesso no banco!"
            } catch (Exception e) {
                println "Erro ao salvar vaga: ${e.message}"
            }  }

    }
}