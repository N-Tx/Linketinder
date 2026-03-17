// Importando a biblioteca que acabamos de instalar
import Chart from 'chart.js/auto';

// Variável para guardar o gráfico e não deixar ele duplicar se clicar 2 vezes
let chartInstance: Chart | null = null;

export function gerarGrafico() {
    // 1. Puxar os candidatos do localStorage
    const candidatosSalvos = JSON.parse(localStorage.getItem("candidatos") || "[]");

    // 2. Contar quantas pessoas têm cada skill
    const contagemSkills: { [key: string]: number } = {};

    candidatosSalvos.forEach((candidato: any) => {
        candidato.skills.forEach((skill: string) => {
            // .trim() tira espaços vazios e .toUpperCase() deixa tudo maiúsculo
            // Assim "Java", " java" e "JAVA" contam como a mesma skill
            const nomeSkill = skill.trim().toUpperCase(); 
            
            if (contagemSkills[nomeSkill]) {
                contagemSkills[nomeSkill]++;
            } else {
                contagemSkills[nomeSkill] = 1;
            }
        });
    });

    // 3. Separar os nomes das skills (eixo X) e as quantidades (eixo Y)
    const nomesDasSkills = Object.keys(contagemSkills);
    const quantidades = Object.values(contagemSkills);

    // 4. Pegar o elemento <canvas> no HTML
    const canvas = document.getElementById("grafico") as HTMLCanvasElement;
    if (!canvas) {
        console.error("Canvas do gráfico não encontrado!");
        return;
    }

    // Se já existir um gráfico na tela, a gente destroi ele antes de criar o novo
    if (chartInstance) {
        chartInstance.destroy();
    }

    // 5. Criar a mágica do Chart.js
    chartInstance = new Chart(canvas, {
        type: 'bar', // Tipo: Gráfico de barras
        data: {
            labels: nomesDasSkills,
            datasets: [{
                label: 'Número de Candidatos por Competência',
                data: quantidades,
                backgroundColor: '#007BFF', // Cor da barra
                borderColor: '#0056b3', // Cor da borda
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    ticks: {
                        stepSize: 1 // Garante que o eixo Y mostre números inteiros (1, 2, 3...)
                    }
                }
            }
        }
    });
}