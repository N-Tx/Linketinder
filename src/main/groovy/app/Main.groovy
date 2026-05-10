package app

import dao.*
import service.*
import controller.MenuController
import view.Menu

class Main {

    static void main(String[] args) {
        // Iniciar DAOs com tipos explícitos
        CandidatoDAO candidatoDAO = new CandidatoDAO()
        EmpresaDAO empresaDAO = new EmpresaDAO()
        CompetenciaDAO competenciaDAO = new CompetenciaDAO()
        VagaDAO vagaDAO = new VagaDAO()

        // Iniciar Novos Services com tipos explícitos
        CandidatoService candidatoService = new CandidatoService(candidatoDAO, competenciaDAO)
        EmpresaService empresaService = new EmpresaService(empresaDAO)
        VagaService vagaService = new VagaService(vagaDAO)
        CompetenciaService competenciaService = new CompetenciaService(competenciaDAO)

        // Montar Controller
        MenuController controller = new MenuController(
                candidatoService,
                empresaService,
                vagaService,
                competenciaService
        )

        // Iniciar Menu
        Menu menu = new Menu(controller)
        menu.iniciar()
    }
}