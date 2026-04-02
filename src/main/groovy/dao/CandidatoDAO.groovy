package dao

import model.User

class CandidatoDAO {

    void salvar(User candidato) {
        def db = Conexao.getConexao()

        if (db != null) {
            try {

                String query = "INSERT INTO candidato (nome, sobrenome, email, telefone, data_nascimento, pais, cpf, cep, descricao) VALUES (?, ?, ?, ?, ?::date, ?, ?, ?, ?)"

                // 2. Passamos os dados em uma lista como segundo argumento.
                // O Groovy coloca as aspas e limpa os dados automaticamente!
                db.executeInsert(query, [
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

                println "💾 Cadastro salvo diretamente no banco de dados!"

            } catch (Exception e) {
                println "🚨 Erro ao tentar salvar no banco: ${e.message}"
            } finally {
                db.close()
            }
        }
    }
}


