package app

import dao.*
import service.*
import view.Menu

class Main {

    static void main(String[] args) {

        CadastroService service = new CadastroService(
                new CandidatoDAO(),
                new EmpresaDAO(),
                new CompetenciaDAO(),
                new VagaDAO()
        )

        Menu menu = new Menu(service)
        menu.iniciar()
    }
}