package service

import dao.CandidatoDAO
import dao.CompetenciaDAO
import dao.EmpresaDAO
import dao.VagaDAO
import model.Competencia
import model.User
import model.Enterprise
import model.Vaga

class CadastroService {

    private CandidatoDAO candidatoDAO
    private EmpresaDAO empresaDAO
    private CompetenciaDAO competenciaDAO
    private VagaDAO vagaDAO


    CadastroService(CandidatoDAO candidatoDAO, EmpresaDAO empresaDAO, CompetenciaDAO competenciaDAO, VagaDAO vagaDAO) {
        this.candidatoDAO = candidatoDAO
        this.empresaDAO = empresaDAO
        this.competenciaDAO = competenciaDAO
        this.vagaDAO = vagaDAO
    }

    void cadastrarUsuario(User user) {
        int id = candidatoDAO.salvar(user)

        if (id != -1) {
            user.skills?.each { skill ->
                int idSkill = competenciaDAO.salvarOuBuscarId(skill)
                candidatoDAO.vincularCompetencia(id, idSkill)
            }
        }
    }

    void cadastrarEmpresa(Enterprise enterprise){
        empresaDAO.salvar(enterprise)
    }


    void salvarCompetencia(Competencia competencia) {
        competenciaDAO.salvar(competencia)
    }

    void cadastrarVaga(Vaga vaga) {
        vagaDAO.salvar(vaga)
    }
    List<Competencia> buscarCompetencias() {
        return competenciaDAO.listar()
    }

    List<User> buscarUser() {
        return candidatoDAO.listar()
    }
    List<Enterprise> buscarEmpresa() {
        return empresaDAO.listar()
    }
}