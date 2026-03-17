import { cadastrarCandidato } from "./controllers/candidatoController";
import { cadastrarEmpresa } from "./controllers/empresaController";
import { cadastrarVaga } from "./controllers/vagaController";
import { listarVagas, listarCandidatosAnonimo, deletarVaga } from "./controllers/listagem";
import { gerarGrafico } from "./charts/chart";

// Conectando com o HTML
(window as any).cadastrarCandidato = cadastrarCandidato;
(window as any).cadastrarEmpresa = cadastrarEmpresa;
(window as any).cadastrarVaga = cadastrarVaga;
(window as any).deletarVaga = deletarVaga;
(window as any).gerarGrafico = gerarGrafico;

// Isso faz com que as listas sejam carregadas assim que você entra na página de Perfil
window.onload = () => {
    listarVagas();
    listarCandidatosAnonimo();
};