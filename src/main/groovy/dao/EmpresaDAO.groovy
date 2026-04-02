package dao

import model.Enterprise

class EmpresaDAO {


    void salvar(Enterprise empresa){
        def db = Conexao.getConexao()


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

                println "💾 Cadastro salvo diretamente no banco de dados!"

            } catch (Exception e){
                println "🚨 Erro ao tentar salvar no banco: ${e.message}"
            } finally {
                db.close()
            }
        }



    }
}
