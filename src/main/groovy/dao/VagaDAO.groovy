package dao

import model.Vaga

class VagaDAO {
    void salvar(Vaga vaga) {
        def db = Conexao.getConexao()
        if (db != null) {
            try {
                String query = "INSERT INTO vagas (nome, descricao, empresa_id) VALUES (?, ?, ?)"

                db.executeInsert(query, [
                        vaga.nome,
                        vaga.descricao,
                        vaga.idEmpresa
                ])
                println "💼 Vaga cadastrada com sucesso no banco!"
            } catch (Exception e) {
                println "🚨 Erro ao salvar vaga: ${e.message}"
            } finally {
                db.close()
            }
        }
    }
}