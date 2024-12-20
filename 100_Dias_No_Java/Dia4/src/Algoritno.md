ALGORITMO JogoDoTigreSimulado

// Variáveis
rolos: ARRAY[3] DE INTEIRO // Representa os 3 rolos
linhasDePagamento: ARRAY[5] DE ARRAY[3] DE INTEIRO // Representa as 5 linhas de pagamento
simbolos: ARRAY[N] DE TEXTO // Lista de símbolos possíveis (ex: "Tigre", "Moeda", "Amuleto", etc.)
probabilidadesSimbolos: ARRAY[N] DE REAL // Probabilidade de cada símbolo aparecer (soma deve ser 1)
multiplicador: INTEIRO
saldo: REAL
aposta: REAL
RTP: REAL = 0.9681 // RTP teórico

// Função para gerar um número aleatório entre 0 e 1 
FUNÇÃO gerarNumeroAleatorio(): REAL
    // (Em uma implementação real, usaria um RNG robusto)
    RETORNE um número pseudoaleatório entre 0 e 1
FIM FUNÇÃO

// Função para gerar um símbolo aleatório com base nas probabilidades
FUNÇÃO gerarSimboloAleatorio(): TEXTO
    numeroAleatorio = gerarNumeroAleatorio()
    acumulado = 0
    PARA i DE 0 A N-1 FAÇA
        acumulado = acumulado + probabilidadesSimbolos[i]
        SE numeroAleatorio < acumulado ENTÃO
            RETORNE simbolos[i]
        FIM SE
    FIM PARA
FIM FUNÇÃO

// Função para gerar os rolos
FUNÇÃO gerarRolos(): ARRAY[3] DE INTEIRO
  PARA i DE 0 A 2 FAÇA
      rolos[i] = gerarSimboloAleatorio() // Atribui um símbolo aleatório a cada rolo
  FIM PARA
  RETORNE rolos
FIM FUNÇÃO

// Função para verificar se há ganhos em uma linha de pagamento
FUNÇÃO verificarLinhaDePagamento(linha: ARRAY[3] DE INTEIRO): BOOLEANO
    SE linha[0] = linha[1] E linha[1] = linha[2] ENTÃO
        RETORNE VERDADEIRO
    SENÃO
        RETORNE FALSO
    FIM SE
FIM FUNÇÃO

// Função principal do jogo
FUNÇÃO jogar(aposta: REAL)
    saldo = saldo - aposta
    rolos = gerarRolos()
    ganho = 0
    multiplicador = 1

    // Verifica as linhas de pagamento
    PARA i DE 0 A 4 FAÇA
        SE verificarLinhaDePagamento(linhasDePagamento[i]) ENTÃO
            ganho = ganho + (aposta * valorDoSimbolo(rolos[linhasDePagamento[i][0]])) //valorDoSimbolo seria uma função que retorna o valor do simbolo
        FIM SE
    FIM PARA
    // Verifica se ativa a rodada bônus (simulação)
    SE gerarNumeroAleatorio() < 0.1 ENTÃO // 10% de chance de ativar a rodada bônus (valor hipotético)
        multiplicador = gerarNumeroAleatorio() * 10 // Multiplicador aleatório até 10x
        ganho = ganho * multiplicador
    FIM SE

    saldo = saldo + ganho
    // Calcula o RTP simulado (apenas para análise a longo prazo)
    RTP_simulado = (saldo inicial - saldo)/saldo inicial
    IMPRIMA "Rolos: ", rolos
    IMPRIMA "Ganho: R$", ganho, " (Multiplicador: ", multiplicador, ")"
    IMPRIMA "Saldo: R$", saldo
    IMPRIMA "RTP Simulado: ", RTP_simulado
FIM FUNÇÃO

// Inicialização
saldo = 1000 // Saldo inicial
aposta = 10   //Aposta inicial
//Definição dos símbolos e probabilidades
simbolos = ["Tigre","Moeda","Amuleto","Sino"]
probabilidadesSimbolos = [0.1,0.3,0.4,0.2]
//Definição das linhas de pagamento
linhasDePagamento = [[0,0,0],[1,1,1],[2,2,2],[0,1,2],[2,1,0]]

// Loop principal do jogo
REPETIR 100 VEZES
jogar(aposta)
FIM REPETIR

FIM ALGORITMO