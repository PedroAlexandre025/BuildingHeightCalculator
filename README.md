# Simulador de Queda Livre com Java Swing

## 📌 Sobre o projeto

Este projeto foi desenvolvido em Java utilizando Java Swing com o objetivo de simular o movimento de uma bola em queda livre ao lado de um prédio.

A aplicação recebe dados fornecidos pelo usuário, realiza validações físicas e matemáticas e calcula automaticamente a altura do prédio com base:

* na altura da janela;
* no tempo em que a bola permanece atravessando a janela;
* no tempo entre a bola passar pela janela, atingir o solo e retornar.

Além do cálculo, o sistema também possui uma simulação gráfica animada utilizando `JPanel`, `Graphics` e `Timer`.

---

# 🎯 Objetivos do projeto

* Aplicar conceitos de:

  * Física (queda livre e MRUV);
  * Programação Orientada a Objetos;
  * Interfaces gráficas com Swing;
  * Máquinas de estados;
  * Validação de entradas.

* Desenvolver uma simulação visual simples baseada em conceitos físicos.

---

# 🧮 Conceitos físicos utilizados

O projeto utiliza equações da cinemática para calcular:

## Velocidade da bola ao atravessar a janela

[
v = \frac{\Delta y - \frac{1}{2}gt^2}{t}
]

---

## Distância percorrida em queda livre

[
\Delta y = \frac{1}{2}gt^2
]

---

## Velocidade final em queda livre

[
v = gt
]

---

## Altura total do prédio

A altura do prédio é calculada a partir:

* do tempo total da trajetória;
* do movimento da bola;
* do intervalo de queda e retorno.

---

# 🖥️ Funcionalidades

## ✅ Interface gráfica

* Campos para inserção dos dados;
* Botão de cálculo;
* Botão de reset;
* Exibição da altura calculada;
* Botão para iniciar a simulação.


<img width="401" height="503" alt="image" src="https://github.com/user-attachments/assets/857a9129-cb8a-4e09-9c11-1f49a0cc1a2e" />


---

## ✅ Validação de entradas

O sistema impede:

* alturas inválidas;
* tempos negativos ou nulos;
* velocidades fisicamente absurdas;
* combinações impossíveis de valores.

Foi definido um limite máximo de velocidade baseado em estimativas reais de velocidade terminal de uma bola de boliche.

---

## ✅ Simulação gráfica

A simulação desenha:

* o prédio;
* a janela;
* o chão;
* a bola em movimento.

A animação foi implementada utilizando:

* `JPanel`;
* `paintComponent()`;
* `Graphics`;
* `javax.swing.Timer`.

---

# ⚙️ Estrutura do projeto

```text
src/
 ├── core/
 │    └── Main.java
 │
 └── classes/
      ├── Interface.java
      ├── Calculator.java
      └── InputsValidation.java
```

---

# 📂 Descrição das classes

## `Main`

Responsável por iniciar a aplicação.

---

## `Interface`

Classe principal da interface gráfica.

Responsável por:

* criação da janela;
* gerenciamento dos componentes Swing;
* eventos dos botões;
* inicialização da simulação.

---

## `Calculator`

Responsável pelos cálculos físicos e matemáticos.

---

## `InputsValidation`

Responsável pelas validações de entrada.

---

## `Simulation`

Classe interna utilizada para:

* desenhar os elementos gráficos;
* animar a bola;
* controlar os estados da simulação.

---

# 🎨 Recursos gráficos utilizados

* desenho com `Graphics`;
* renderização de formas geométricas;
* animação por frames;
* escala dinâmica em pixels;
* painel customizado;
* fundo colorido;
* atualização em tempo real com `repaint()`.

---

# 🚀 Tecnologias utilizadas

* Java
* Java Swing
* IntelliJ IDEA

---

# ▶️ Como executar

## 0. Certifique de ter instalado no local da execução java 17 ou posterior.


## 1. Clone o repositório


git clone https://github.com/PedroAlexandre025/BuildingHeightCalculator.git


---

## 2. Abra o projeto no seu editor

---

## 3. Execute a classe `Main`

---

# 📸 Demonstração


<img width="397" height="718" alt="image" src="https://github.com/user-attachments/assets/744f2ba1-8b23-4270-8022-4319563e74ef" />


---

# 👨‍💻 Autor

PedroAlexandre025
