package app

import dao.*
import service.*
import view.Menu

class Main {

    static void main(String[] args) {

        def service = new CadastroService(
                new CandidatoDAO(),
                new EmpresaDAO(),
                new CompetenciaDAO(),
                new VagaDAO()
        )

        def menu = new Menu(service)
        menu.iniciar()
    }
}