package service

import dao.CompetenciaDAO
import model.Competencia

class CompetenciaService {

    private CompetenciaDAO competenciaDAO

    CompetenciaService(CompetenciaDAO competenciaDAO) {
        this.competenciaDAO = competenciaDAO
    }

    void salvarCompetencia(Competencia competencia) {
        competenciaDAO.salvar(competencia)
    }

    List<Competencia> buscarCompetencias() {
        return competenciaDAO.listar()
    }
}