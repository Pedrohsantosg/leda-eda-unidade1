# LEDA / EDA – Unidade 1  
## Análise de Algoritmos de Ordenação e Busca em Java

Projeto acadêmico desenvolvido para a disciplina **Estrutura de Dados (LEDA/EDA – 2025.2)**  
**Universidade Estadual da Paraíba (UEPB)**

---

## 🎯 Objetivo

Este projeto tem como objetivo **ensinar, implementar e analisar o desempenho** de algoritmos clássicos de **ordenação** e **busca**, utilizando a linguagem **Java**.

O sistema foi projetado com foco **didático**, permitindo que **usuários sem conhecimento prévio** aprendam conceitos fundamentais de Estrutura de Dados por meio de um **menu interativo e guiado**, que explica cada etapa do funcionamento do projeto.

---

## 📘 Especificações da Atividade (Unidade 1)

### 🔹 Algoritmos de Ordenação
Implementados sobre arrays de objetos `Estudante`:

- **BubbleSort**
  - Versão simples
  - Versão otimizada
- **SelectionSort**
  - Versão simples
  - Versão estável
- **InsertionSort**
- **MergeSort** (clássico)
- **QuickSort**
  - Versão simples
  - Versão com shuffle
  - Implementação do Java (`Arrays.sort`)
- **CountingSort**
  - Utilizando o campo **nota** como chave

---

### 🔹 Algoritmos de Busca
Executados sobre vetores **previamente ordenados**:

- Busca Linear Iterativa  
- Busca Linear Recursiva  
- Busca Binária Iterativa  
- Busca Binária Recursiva  
- Busca Linear Iterativa Duas Pontas  

---

### 🔹 Análise de Performance (Benchmark)

- Medição de tempo com `System.nanoTime()`
- Warm-up da JVM (execuções iniciais descartadas)
- Execução repetida (média de 20 execuções)
- Diferentes tamanhos de vetor
- Cenários analisados:
  - Vetor aleatório
  - Vetor ordenado
  - Vetor inversamente ordenado
- Experimento extra com `int[]` utilizando o QuickSort do Java

---

## 🧱 Estrutura do Projeto

src/
├── benchmark/ # Menu interativo, benchmarks e medições de desempenho
├── model/ # Classe de domínio (Estudante)
├── sort/ # Algoritmos de ordenação
├── search/ # Algoritmos de busca
└── util/ # Geradores de dados e cenários


---

## 👤 Classe Estudante

A classe `Estudante` representa o elemento base do projeto e possui os seguintes atributos:

- matrícula (`int`)
- nome (`String`)
- nota (`int`)

Ela implementa a interface `Comparable<Estudante>` com a seguinte **regra de ordenação**:

1. **Nota** – ordem decrescente  
2. **Nome** – ordem crescente  
3. **Matrícula** – ordem crescente  

Essa regra garante consistência entre todos os algoritmos de ordenação implementados.

---

## 🎛️ Menu Interativo Didático

Ao executar o projeto, o usuário interage com um **menu textual guiado**, que explica conceitos e executa exemplos práticos.

### Opções do Menu

1. O que é este projeto?  
2. Aprender sobre algoritmos de **ordenação**  
3. Aprender sobre algoritmos de **busca**  
4. Executar benchmark de ordenação  
5. Executar benchmark de busca  
6. Créditos do projeto  
0. Sair  

Cada opção:
- explica o conceito teórico
- demonstra o funcionamento com exemplos
- executa o código correspondente

👉 Ideal para **aprendizado**, **apresentações orais** e **avaliação acadêmica**.

---

## ▶️ Como Executar o Projeto

### Pré-requisitos

- Java JDK 11 ou superior  
- IntelliJ IDEA (recomendado)  
- Git (opcional)

### Passos para Execução

1. Clone o repositório:
```bash
git clone https://github.com/Pedrohsantosg/leda-eda-unidade1.git
```
2. Abra o projeto no IntelliJ IDEA
3. Execute a classe principal:
4. benchmark.Main

## ⏱️ Como Utilizar os Benchmarks

- Selecione a opção de **benchmark** no menu interativo  
- Informe o tamanho do vetor (exemplos: `20000`, `100000`)  
- O sistema exibirá o **tempo médio de execução** de cada algoritmo  

Os resultados obtidos podem ser utilizados para:

- Construção de tabelas  
- Geração de gráficos  
- Análise comparativa de desempenho  

---

## 💡 Sugestões de Uso

- Utilizar o menu didático para **apresentação oral**  
- Comparar algoritmos simples versus algoritmos mais eficientes  
- Observar diferenças de desempenho entre:
  - **O(n²)**
  - **O(n log n)**
  - **O(n)**
- Exportar manualmente os resultados para ferramentas externas  
  (Excel, Python, etc.)

---

## 🚀 Possíveis Extensões

- Exportação automática dos resultados para **CSV**  
- Geração automática de **gráficos**  
- Implementação de **interface gráfica (GUI)**  
- Modo **passo a passo** para fins educacionais  
- Comparação com outros tipos de **estruturas de dados**

---

## 👥 Autores

Projeto desenvolvido em grupo para a disciplina  
**Estrutura de Dados (LEDA/EDA – 2025.2)** – UEPB

- **Pedro.hs0311** – Desenvolvimento do código, arquitetura do projeto e versionamento (GitHub)  
- **Julio_pedrw** – Organização do projeto e apoio na implementação  
- **Livia_denner** – Metodologia experimental e análise  
- **BeaMatss** – Análise e interpretação dos resultados  

---

## 📌 Considerações Finais

Este projeto integra **teoria e prática**, oferecendo uma base sólida para o estudo de algoritmos de **ordenação** e **busca**, com foco em **clareza**, **didática** e **rigor experimental**, atendendo integralmente às exigências da **Unidade 1 da disciplina LEDA/EDA**.

> Utilize o **menu interativo exibido no terminal** para explorar todas as funcionalidades do sistema.

