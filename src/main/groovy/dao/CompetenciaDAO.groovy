package dao

import model.Competencia

class CompetenciaDAO {

    void salvar(Competencia comp) {
        def db = Conexao.getConexao()
        if (db != null) {
            try {
                String query = "INSERT INTO competencias (nome) VALUES (?)"
                db.executeInsert(query, [comp.nome])
                println "Competência '${comp.nome}' cadastrada no banco!"
            } catch (Exception e) {
                println "Erro ao salvar competência: ${e.message}"
            } finally {
                db.close()
            }
        }
    }

    List<Competencia> listar() {
        def db = Conexao.getConexao()
        List<Competencia> lista = []
        if (db != null) {
            try {
                db.eachRow("SELECT * FROM competencias ORDER BY id") { row ->
                    lista << new Competencia(id: row.id, nome: row.nome)
                }
            } catch (Exception e) {
                println " Erro ao listar competências: ${e.message}"
            } finally {
                db.close()
            }
        }
        return lista
    } //...

    int salvarOuBuscarId(String nomeSkill) {
        def db = Conexao.getConexao()
        int idCompetencia = -1

        if (db != null) {
            try {

                def row = db.firstRow("SELECT id FROM competencias WHERE nome ILIKE ?", [nomeSkill])

                if (row != null) {
                    idCompetencia = row.id // Achou no banco, pega o ID
                } else {

                    def insertRow = db.firstRow("INSERT INTO competencias (nome) VALUES (?) RETURNING id", [nomeSkill])
                    if (insertRow != null) {
                        idCompetencia = insertRow.id
                    }
                }
            } catch (Exception e) {
                println " Erro ao buscar/salvar competência automática: ${e.message}"
            } finally {
                db.close()
            }
        }
        return idCompetencia
    }

}