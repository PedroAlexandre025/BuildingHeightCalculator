# Simulador de Queda Livre com Java Swing

## 📌 Sobre o projeto

Este projeto foi desenvolvido em Java utilizando Java Swing com o objetivo de simular o movimento de uma bola em queda livre ao lado de um prédio.

A aplicação recebe dados fornecidos pelo usuário, realiza validações físicas e matemáticas e calcula automaticamente a altura do prédio com base:

* na altura da janela;
* no tempo em que a bola permanece atravessando a janela;
* no tempo entre a bola passar pela janela, atingir o solo e retornar.

Além do cálculo, o sistema também possui uma simulação gráfica animada utilizando `JPanel`, `Graphics` e `Timer`.

---
# Problema base para o projeto

<img width="1357" height="612" alt="image" src="https://github.com/user-attachments/assets/27effe2a-bf68-43ba-9f1e-992f92a97445" />

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

<img width="274" height="135" alt="image" src="https://github.com/user-attachments/assets/49ea48b7-2c74-4617-ba76-fd0b0033eeab" />


---

## Distância percorrida em queda livre

<img width="167" height="109" alt="image" src="https://github.com/user-attachments/assets/bbb25741-16f4-4fbf-9018-884ced81a4d1" />


---

## Velocidade final em queda livre

<img width="140" height="59" alt="image" src="https://github.com/user-attachments/assets/183f0059-34bf-451f-9381-4df0c93d273d" />

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

Foi definido um limite máximo de velocidade baseado em estimativas reais de velocidade terminal de uma bola de aço de 5kg.

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

Como diz o problema, a bola não perde energia quando bate chega ao chão após a primeira queda, logo, ela foi animada retornando ao ponto de origem.
Quando cai novamente, ao bater no chão, fiz com que ela suba somente metade da distancia inicial, simulando uma perda de energia.

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
