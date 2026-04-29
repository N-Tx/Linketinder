package service

import model.User
import model.Enterprise

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static org.mockito.Mockito.*

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


    //  USUÁRIO - SUCESSO

    @Test
    void deveCadastrarNovoUsuario() {
        def user = new User(
                nome: "Pedro",
                email: "pedro@gmail.com",
                cpf: "999999",
                skills: ["Java"]
        )

        when(candidatoDAOMock.salvar(user)).thenReturn(1)
        when(competenciaDAOMock.salvarOuBuscarId("Java")).thenReturn(10)

        service.cadastrarUsuario(user)

        verify(candidatoDAOMock, times(1)).salvar(user)
        verify(competenciaDAOMock, times(1)).salvarOuBuscarId("Java")
        verify(candidatoDAOMock, times(1)).vincularCompetencia(1, 10)
    }


    // USUÁRIO - ERRO

    @Test
    void naoDeveVincularCompetenciaSeFalharAoSalvarUsuario() {
        def user = new User(
                nome: "Erro",
                skills: ["Java"]
        )

        when(candidatoDAOMock.salvar(user)).thenReturn(-1)

        service.cadastrarUsuario(user)

        verify(candidatoDAOMock, times(1)).salvar(user)
        verify(competenciaDAOMock, never()).salvarOuBuscarId(any())
        verify(candidatoDAOMock, never()).vincularCompetencia(anyInt(), anyInt())
    }


    //  MÚLTIPLAS SKILLS
    @Test
    void deveCadastrarUsuarioComMultiplasSkills() {
        def user = new User(
                nome: "João",
                skills: ["Java", "SQL"]
        )

        when(candidatoDAOMock.salvar(user)).thenReturn(1)
        when(competenciaDAOMock.salvarOuBuscarId("Java")).thenReturn(10)
        when(competenciaDAOMock.salvarOuBuscarId("SQL")).thenReturn(20)

        service.cadastrarUsuario(user)

        verify(competenciaDAOMock).salvarOuBuscarId("Java")
        verify(competenciaDAOMock).salvarOuBuscarId("SQL")
        verify(candidatoDAOMock).vincularCompetencia(1, 10)
        verify(candidatoDAOMock).vincularCompetencia(1, 20)
    }

    //  EMPRESA

    @Test
    void deveCadastrarEmpresa() {
        def empresa = new Enterprise(
                nome: "Pastelsoft",
                email: "pastel@gmail.com",
                cnpj: "10000323"
        )

        service.cadastrarEmpresa(empresa)

        verify(empresaDAOMock, times(1)).salvar(empresa)
    }


    //  LISTAR USUÁRIOS

    @Test
    void deveListarUsuarios() {
        def listaMock = [new User(nome: "Pedro")]

        when(candidatoDAOMock.listar()).thenReturn(listaMock)

        def resultado = service.buscarUser()

        assert resultado.size() == 1
        assert resultado[0].nome == "Pedro"
    }


    // LISTAR EMPRESAS

    @Test
    void deveListarEmpresas() {
        def listaMock = [new Enterprise(nome: "Empresa X")]

        when(empresaDAOMock.listar()).thenReturn(listaMock)

        def resultado = service.buscarEmpresa()

        assert resultado.size() == 1
        assert resultado[0].nome == "Empresa X"
    }


    // LISTAR COMPETÊNCIAS

    @Test
    void deveListarCompetencias() {
        def listaMock = []

        when(competenciaDAOMock.listar()).thenReturn(listaMock)

        def resultado = service.buscarCompetencias()

        assert resultado.isEmpty()
    }
}