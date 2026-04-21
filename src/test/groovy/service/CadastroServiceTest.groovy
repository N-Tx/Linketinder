package service

import model.User
import model.Enterprise

import org.mockito.Mockito
import static org.mockito.Mockito.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import dao.CandidatoDAO
import dao.EmpresaDAO
import dao.CompetenciaDAO
import dao.VagaDAO

class CadastroServiceTest {

    CadastroService service
    CandidatoDAO candidatoDAOMock
    EmpresaDAO empresaDAOMock
    CompetenciaDAO competenciaDAOMock
    VagaDAO vagaDAOMock

    @BeforeEach
    void setup() {

        candidatoDAOMock = mock(CandidatoDAO)
        empresaDAOMock = mock(EmpresaDAO)
        competenciaDAOMock = mock(CompetenciaDAO)
        vagaDAOMock = mock(VagaDAO)

        service = new CadastroService(
                candidatoDAOMock,
                empresaDAOMock,
                competenciaDAOMock,
                vagaDAOMock
        )
    }

    @Test
    void deveCadastrarNovoUsuario() {
        def novoUser = new User(
                nome: "Pedro",
                email: "pedro@gmail.com",
                cpf: "999999",
                skills: ["Java"]
        )


        when(candidatoDAOMock.salvar(novoUser)).thenReturn(1)
        when(competenciaDAOMock.salvarOuBuscarId("Java")).thenReturn(10)

        service.cadastrarUsuario(novoUser)

        verify(candidatoDAOMock, times(1)).salvar(novoUser)
        verify(competenciaDAOMock, times(1)).salvarOuBuscarId("Java")
        verify(candidatoDAOMock, times(1)).vincularCompetencia(1, 10)
    }

    @Test
    void deveCadastrarEmpresa() {
        def novaEmpresa = new Enterprise(
                nome: "Pastelsoft",
                email: "pastel@gmail.com",
                cnpj: "10000323"
        )

        service.cadastrarEmpresa(novaEmpresa)

        verify(empresaDAOMock, times(1)).salvar(novaEmpresa)
    }
}