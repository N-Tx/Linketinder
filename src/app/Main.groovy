package app

import service.CadastroService
import service.Menu

class Main {

    static void main(String[] args) {

        def service = new CadastroService()
        def menu = new Menu(service)

        menu.iniciar()

    }
}