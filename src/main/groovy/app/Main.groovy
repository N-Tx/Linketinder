package app

import dao.Conexao
import service.CadastroService
import service.Menu

class Main {

    static void main(String[] args) {

        def db = Conexao.getConexao()
        if (db) {
            println "✅ Conexão Groovy com o banco 'linketinder' estabelecida com sucesso!"
            db.close()
        }

        def service = new CadastroService()
        def menu = new Menu(service)

        menu.iniciar()

    }
}