package service

import dao.VagaDAO
import model.Vaga

class VagaService {

    private VagaDAO vagaDAO

    VagaService(VagaDAO vagaDAO) {
        this.vagaDAO = vagaDAO
    }

    void cadastrarVaga(Vaga vaga) {
        vagaDAO.salvar(vaga)
    }
}