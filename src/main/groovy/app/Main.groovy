package app

import dao.*
import service.*
import controller.*
import view.Menu

class Main {
    static void main(String[] args) {

        CandidatoDAO cDAO = new CandidatoDAO()
        EmpresaDAO eDAO = new EmpresaDAO()
        CompetenciaDAO compDAO = new CompetenciaDAO()
        VagaDAO vDAO = new VagaDAO()

        CandidatoService cSrv = new CandidatoService(cDAO, compDAO)
        EmpresaService eSrv = new EmpresaService(eDAO)
        VagaService vSrv = new VagaService(vDAO)
        CompetenciaService compSrv = new CompetenciaService(compDAO)

        CandidatoController cCtrl = new CandidatoController(cSrv)
        EmpresaController eCtrl = new EmpresaController(eSrv)
        VagaController vCtrl = new VagaController(vSrv)
        CompetenciaController compCtrl = new CompetenciaController(compSrv)

        Menu menu = new Menu(cCtrl, eCtrl, vCtrl, compCtrl)
        menu.iniciar()
    }
}