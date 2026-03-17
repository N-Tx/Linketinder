import { Candidato } from "../models/Candidato";

export function cadastrarCandidato(event: Event) {
    event.preventDefault(); // Impede a página de recarregar

    const nome = (document.getElementById("nome") as HTMLInputElement).value;
    const email = (document.getElementById("email") as HTMLInputElement).value;
    const idade = Number((document.getElementById("idade") as HTMLInputElement).value);
    const estado = (document.getElementById("estado") as HTMLInputElement).value;
    const cep = Number((document.getElementById("cep") as HTMLInputElement).value);
    const descricao = (document.getElementById("descricao") as HTMLInputElement).value;
    const skills = (document.getElementById("skills") as HTMLInputElement).value.split(",");

    // O .map(s => s.trim()) serve para tirar os espaços das skills (ex: "Java, TS" vira "Java" e "TS")
    const novo = new Candidato(nome, email, idade, estado, cep, descricao, skills.map(s => s.trim()));

    // A MÁGICA: Busca os candidatos salvos ou cria lista vazia
    const candidatosSalvos = JSON.parse(localStorage.getItem("candidatos") || "[]");
    
    // Adiciona o novo e salva no navegador
    candidatosSalvos.push(novo);
    localStorage.setItem("candidatos", JSON.stringify(candidatosSalvos));

    alert("Candidato cadastrado com sucesso!");
    (event.target as HTMLFormElement).reset(); // Limpa a tela
}