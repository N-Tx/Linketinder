package controller

import model.*
import service.CadastroService
import service.CandidatoService
import service.CompetenciaService
import service.EmpresaService
import service.VagaService

class MenuController {

    CandidatoService candidatoService
    EmpresaService empresaService
    CompetenciaService competenciaService
    VagaService vagaService

    MenuController(
            CandidatoService candidatoService,
            EmpresaService empresaService,
            CompetenciaService competenciaService,
            VagaService vagaService
    ) {

        this.candidatoService = candidatoService
        this.empresaService = empresaService
        this.competenciaService = competenciaService
        this.vagaService = vagaService
    }

    // Métodos de Listagem (Retornam listas para a View exibir)
    List<User> listarCandidatos() {
        return service.buscarUser()
    }

    List<Enterprise> listarEmpresas() {
        return service.buscarEmpresa()
    }

    List<Competencia> listarCompetencias() {
        return service.buscarCompetencias()
    }

    // Métodos de Cadastro (Recebem objetos prontos da View)
    void cadastrarUsuario(User usuario) {
        service.cadastrarUsuario(usuario)
    }

    void cadastrarEmpresa(Enterprise empresa) {
        service.cadastrarEmpresa(empresa)
    }

    void cadastrarVaga(Vaga vaga) {
        service.cadastrarVaga(vaga)
    }

    void cadastrarCompetencia(Competencia competencia) {
        service.salvarCompetencia(competencia)
    }
}