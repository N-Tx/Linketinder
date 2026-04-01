package dao

import model.User

class CandidatoDAO {

    void salvar(User candidato) {
        def db = Conexao.getConexao()

        if (db != null) {
            try {
                // 1. Usamos '?' como marcadores de posição (placeholders)
                String query = "INSERT INTO candidato (nome, sobrenome, email, cpf, cep, descricao) VALUES (?, ?, ?, ?, ?, ?)"

                // 2. Passamos os dados em uma lista como segundo argumento.
                // O Groovy coloca as aspas e limpa os dados automaticamente!
                db.executeInsert(query, [
                        candidato.nome,
                        candidato.sobrenome,
                        candidato.email,
                        candidato.cpf,
                        candidato.cep,
                        candidato.descricao

                ])

                println "💾 Cadastro salvo diretamente no banco de dados!"

            } catch (Exception e) {
                println "🚨 Erro ao tentar salvar no banco: ${e.message}"
            } finally {
                db.close()
            }
        }
    }
}