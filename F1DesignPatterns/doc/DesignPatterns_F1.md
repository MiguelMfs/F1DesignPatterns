
---

## doc/DesignPatterns_F1.md  (DOCUMENTO — máximo ~2 páginas)
```markdown
# Aplicação de Padrões - Corrida de Fórmula 1

## Contexto do domínio
Domínio: Corrida de Fórmula 1. Objetos centrais: Pilotos (nome, número), Carros (equipe, potência, downforce), Corrida (número de voltas, posições). O sistema simula uma corrida simples, registra eventos e exibe atualizações ao usuário.

---

## Padrões escolhidos e justificativa

### 1) **Singleton** — `RaceManager`
**Aplicabilidade:** garante uma única instância responsável pelo estado global da corrida (lista de pilotos, número de voltas).  
**Justificativa:** no domínio de corrida existe um único contexto global da corrida em execução; múltiplas instâncias poderiam causar inconsistência (por exemplo: duas listas de pilotos). O Singleton torna o acesso simples e controlado.

### 2) **Builder** — `CarBuilder` e `DriverBuilder`
**Aplicabilidade:** construção passo-a-passo de objetos `Car` e `Driver` que têm parâmetros numerosos/opcionais.  
**Justificativa:** ao cadastrar pilotos via input do usuário, o Builder permite montar `Car` e `Driver` de forma legível e evitar construtores com muitos parâmetros; aceita valores padrão e validação antes do `build()`.

(Imagem: diagrama simples — DriverBuilder -> Driver, CarBuilder -> Car)

### 3) **Estrutural — Facade** — `RaceFacade`
**Aplicabilidade:** oferece uma interface simplificada para a sequência de ações necessárias (capturar input, construir objetos, configurar observadores, iniciar simulação).  
**Justificativa:** esconde a complexidade de vários subsistemas (builders, RaceManager, RaceEventManager, RaceSimulator) e fornece um ponto único de uso para o usuário/app. Facilita o uso por quem integra o módulo (ex.: UI).

### 4) **Comportamental — Observer** — `RaceEventManager` / `RaceObserver`
**Aplicabilidade:** notificação de eventos (mudança de líder, incidentes) para inscritos (console, UI).  
**Justificativa:** em tempo de execução, diversos componentes podem querer reagir a eventos da corrida (painel de informações, telemetria, logs). O Observer desacopla quem gera eventos de quem os consome, permitindo múltiplos observadores (ex.: `ConsoleObserver`).

---

## Fluxo de execução (resumo)
1. `Main` cria `RaceFacade`.
2. `RaceFacade` solicita ao usuário: número de pilotos, dados de cada piloto/carros e número de voltas.
3. `DriverBuilder` e `CarBuilder` constroem objetos que são adicionados ao `RaceManager` (Singleton).
4. `RaceFacade` configura observadores em `RaceEventManager`.
5. `RaceSimulator` executa a corrida por `n` voltas, produzindo eventos que são enviados a todos os observadores (Observer).
6. Resultado final é exibido no console.

---

## Considerações finais
- Arquitetura simples e modular: cada padrão tem responsabilidade bem definida.
- Fácil extensão: novos observadores (por ex. UI gráfica, logger para arquivo) podem ser adicionados sem alterar o simulador.
- O uso do Builder evita problemas com construtores longos e melhora viabilidade para inputs do usuário.
