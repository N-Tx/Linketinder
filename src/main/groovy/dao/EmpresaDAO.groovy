package dao


import model.Competencia
import model.Enterprise
import model.User
import database.DatabaseConnectionProvider

class EmpresaDAO {


    void salvar(Enterprise empresa){
        def provider = DatabaseConnectionProvider.getProvider("postgres")
        def db = provider.getConnection()

        if (db != null){
            try{
                String query = "INSERT INTO empresa (nome, cnpj, email, telefone, pais, cep, descricao) VALUES (?,?,?,?,?,?,?)"

                db.executeInsert(query,[
                empresa.nome,
                empresa.cnpj,
                empresa.email,
                empresa.telefone,
                empresa.pais,
                empresa.cep,
                empresa.descricao
                ])

                println "Cadastro salvo diretamente no banco de dados!"

            } catch (Exception e){
                println "Erro ao tentar salvar no banco: ${e.message}"
            }
        }

    }

    List<Enterprise> listar() {
        def provider = DatabaseConnectionProvider.getProvider("postgres")
        def db = provider.getConnection()
        List<Enterprise> lista = []
        if (db != null) {
            try {
                db.eachRow("SELECT * FROM empresa ORDER BY id") { row ->
                    lista << new Enterprise(id: row.id, nome: row.nome)
                }
            } catch (Exception e) {
                println " Erro ao listar usuarios: ${e.message}"
            }
        }
        return lista
    }
}
