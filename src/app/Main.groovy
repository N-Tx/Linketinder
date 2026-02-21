package app

import service.CadastroService
import service.Menu

class Main {

    static void main(String[] args) {

        CadastroService service = new CadastroService()
        service.cadastrar()
        def menu = new Menu(service)
        menu.iniciar()
    }
}