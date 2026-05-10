package controller

import model.Competencia
import service.CompetenciaService

class CompetenciaController {
    private CompetenciaService competenciaService

    CompetenciaController(CompetenciaService service) {
        this.competenciaService = service
    }

    void cadastrar(Competencia comp) {
        competenciaService.salvarCompetencia(comp)
    }

    List<Competencia> listar() {
        competenciaService.buscarCompetencias()
    }
}