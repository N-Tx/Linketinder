package dao
import model.Competencia

class CompetenciaDAO {
    void salvar(Competencia competencia) {
        def db = Conexao.getConexao()
        if (db != null) {
            try {
                String query = "INSERT INTO competencias (nome) VALUES (?)"
                db.executeInsert(query, [competencia.nome])
                println "Competência salva no banco!"
            } catch (Exception e) {
                println "🚨 Erro ao salvar competência: ${e.message}"
            } finally {
                db.close()
            }
        }
    }
}