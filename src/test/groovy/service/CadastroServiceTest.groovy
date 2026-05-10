package service

import model.User
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import static org.mockito.Mockito.*

import dao.CandidatoDAO
import dao.CompetenciaDAO

class CandidatoServiceTest {

    CandidatoService service
    CandidatoDAO candidatoDAOMock
    CompetenciaDAO competenciaDAOMock

    @BeforeEach
    void setup() {
        candidatoDAOMock = mock(CandidatoDAO)
        competenciaDAOMock = mock(CompetenciaDAO)

        service = new CandidatoService(candidatoDAOMock, competenciaDAOMock)
    }

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

    @Test
    void deveListarUsuarios() {
        def listaMock = [new User(nome: "Pedro")]
        when(candidatoDAOMock.listar()).thenReturn(listaMock)

        def resultado = service.buscarUsuarios() // Atualizado para o nome correto do seu service

        assert resultado.size() == 1
        assert resultado[0].nome == "Pedro"
    }
}