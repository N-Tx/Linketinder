package controller

import service.*
import model.*

class MenuController {
    private CandidatoService candidatoService
    private EmpresaService empresaService
    private VagaService vagaService
    private CompetenciaService competenciaService

    MenuController(CandidatoService candidatoservice, EmpresaService empresaservice, VagaService vagaservice, CompetenciaService competenciaservice) {
        this.candidatoService = candidatoservice
        this.empresaService = empresaservice
        this.vagaService = vagaservice
        this.competenciaService = competenciaservice
    }

    void cadastrarUsuario(User user) {
        candidatoService.cadastrarUsuario(user)
    }

    void cadastrarEmpresa(Enterprise enterprise) {
        empresaService.cadastrarEmpresa(enterprise)
    }

    void cadastrarVaga(Vaga vaga) {
        vagaService.cadastrarVaga(vaga)
    }

    void cadastrarCompetencia(Competencia comp) {
        competenciaService.salvarCompetencia(comp)
    }

    List<User> listarCandidatos() {
        return candidatoService.buscarUsuarios()
    }

    List<Enterprise> listarEmpresas() {
        empresaService.buscarEmpresas()
    }

    List<Competencia> listarCompetencias() {
        competenciaService.buscarCompetencias()
    }
}