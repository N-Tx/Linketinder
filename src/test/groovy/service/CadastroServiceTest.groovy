package service

import model.User
import model.Enterprise

import org.mockito.Mockito
import static org.mockito.Mockito.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

import dao.CandidatoDAO
import dao.EmpresaDAO

class CadastroServiceTest {

    CadastroService service
    CandidatoDAO candidatoDAOMock
    EmpresaDAO empresaDAOMock

    @BeforeEach
    void setup() {

        service = new CadastroService()


        candidatoDAOMock = Mockito.mock(CandidatoDAO.class)
        empresaDAOMock = Mockito.mock(EmpresaDAO.class)


        service.candidatoDAO = candidatoDAOMock
        service.empresaDAO = empresaDAOMock
    }

    @Test
    void deveCadastrarNovoUsuario() {
        def novoUser = new User(
                nome: "Pedro",
                email: "pedro@gmail.com",
                cpf: "999999",
        )

        service.cadastrarUsuario(novoUser)

        verify(candidatoDAOMock, times(1)).inserir(novoUser)
    }

    @Test
    void DeveCadastrarEmpresa(){
        def novaEnterprise = new Enterprise(
                nome: "Pastelsoft",
                email: "Pastel@gmail.com",
                cnpj: "10000323"
        )

        service.cadastrarEmpresa(novaEnterprise)

        verify(empresaDAOMock, times(1)).inserir(novaEnterprise)
    }
}