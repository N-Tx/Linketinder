package service

import dao.EmpresaDAO
import model.Enterprise

class EmpresaService {

    private EmpresaDAO empresaDAO

    EmpresaService(EmpresaDAO empresaDAO) {
        this.empresaDAO = empresaDAO
    }

    void cadastrarEmpresa(Enterprise enterprise) {
        empresaDAO.salvar(enterprise)
    }

    List<Enterprise> buscarEmpresas() {
        return empresaDAO.listar()
    }
}