import { Empresa } from "../models/Empresa";
import { RegexPadroes } from "../services/validador";

export function cadastrarEmpresa(event: Event) {
    event.preventDefault(); 

    const nome = (document.getElementById("nome") as HTMLInputElement).value;
    const email = (document.getElementById("email") as HTMLInputElement).value;
    const cnpj = (document.getElementById("cnpj") as HTMLInputElement).value;
    const cep = ((document.getElementById("cep") as HTMLInputElement).value);

    if (nome.length < 3) {
        alert("O nome deve ter pelo menos 3 caracteres.");
        return;
    }
    if (nome.length < 3) {
        alert("O nome deve ter pelo menos 3 caracteres.");
        return;
    }

    if (!RegexPadroes.email.test(email)) {
        alert("E-mail inválido! Ex: usuario@email.com");
        return;
    }

    if (!RegexPadroes.cep.test(cep)) {
        alert("CEP inválido! Use o formato 00000-000.");
        return;
    }


    const estado = (document.getElementById("estado") as HTMLInputElement).value;
    const descricao = (document.getElementById("descricao") as HTMLInputElement).value;
    const skills = (document.getElementById("skills") as HTMLInputElement).value.split(",");

    const nova = new Empresa(nome, email, cnpj, estado, Number(cep), descricao, skills);

    // Pega as empresas que já existem no navegador (ou cria um array vazio)
    const empresasSalvas = JSON.parse(localStorage.getItem("empresas") || "[]");
    empresasSalvas.push(nova);
    
    // Salva o array atualizado de volta no navegador
    localStorage.setItem("empresas", JSON.stringify(empresasSalvas));

    alert("Empresa cadastrada com sucesso!");
    (event.target as HTMLFormElement).reset(); // Limpa o formulário
}