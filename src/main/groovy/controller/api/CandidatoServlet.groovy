package controller.api

import dao.CandidatoDAO
import dao.CompetenciaDAO
import model.User
import service.CandidatoService

// Importando o Gson
import com.google.gson.Gson

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet("/candidatos")
class CandidatoServlet extends HttpServlet {

    private CandidatoService candidatoService

    private Gson gson = new Gson()

    @Override
    void init() {
        this.candidatoService = new CandidatoService(new CandidatoDAO(), new CompetenciaDAO())
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {


        User novo = gson.fromJson(req.getReader(), User.class)

        candidatoService.cadastrarUsuario(novo)

        resp.setStatus(HttpServletResponse.SC_CREATED) // 201
        resp.setContentType("application/json")
        resp.setCharacterEncoding("UTF-8")


        def resposta = [mensagem: "Candidato cadastrado com sucesso!"]
        resp.getWriter().write(gson.toJson(resposta))
    }
}