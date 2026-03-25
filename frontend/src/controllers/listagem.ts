export function listarVagas() {
    const ul = document.getElementById("listaVagas");
    // Se não achar o elemento (porque estamos em outra página), ele ignora e não quebra o código
    if (!ul) return; 

    ul.innerHTML = ""; 

    // Lê do localStorage
    const vagasSalvas = JSON.parse(localStorage.getItem("vagas") || "[]");

    vagasSalvas.forEach((v: any, index: number) => {
        const li = document.createElement("li");
        li.title = `Descrição: ${v.descricao}`; 
        
        li.innerHTML = `
            ${v.titulo} - Skills: ${v.skills.join(", ")}
            <button onclick="deletarVaga(${index})" style="margin-left: 10px; color: red;">X</button>
        `;
        ul.appendChild(li);
    });
}

export function listarCandidatosAnonimo() {
    const tabela = document.getElementById("tabelaCandidatos");
    if (!tabela) return; 

    tabela.innerHTML = ""; 

    // Lê do localStorage
    const candidatosSalvos = JSON.parse(localStorage.getItem("candidatos") || "[]");

    candidatosSalvos.forEach((c: any) => {
        const tr = document.createElement("tr");
        tr.title = `Estado: ${c.estado} | CEP: ${c.cep}`; 
        tr.innerHTML = `
            <td>Candidato Anônimo</td>
            <td>${c.skills.join(", ")}</td>
            <td>${c.descricao}</td>
        `;
        tabela.appendChild(tr);
    });
}

// Função de deletar vaga
export function deletarVaga(index: number) {
    const vagasSalvas = JSON.parse(localStorage.getItem("vagas") || "[]");
    vagasSalvas.splice(index, 1);
    localStorage.setItem("vagas", JSON.stringify(vagasSalvas));
    listarVagas(); // Atualiza a lista na tela na mesma hora
}