package service

import dao.CandidatoDAO
import dao.CompetenciaDAO
import model.User

class CandidatoService {

    private CandidatoDAO candidatoDAO
    private CompetenciaDAO competenciaDAO

    CandidatoService(CandidatoDAO candidatoDAO, CompetenciaDAO competenciaDAO) {
        this.candidatoDAO = candidatoDAO
        this.competenciaDAO = competenciaDAO
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

    List<User> buscarUsuarios() {
        return candidatoDAO.listar()
    }
}