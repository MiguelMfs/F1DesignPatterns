# F1DesignPatterns
Projeto demonstrativo de Padrões de Projeto 

---

## 🏆 Domínio: Corrida de Fórmula 1.

---

## 👥 Integrantes 
- MIGUEL FERREIRA SANTOS - Matrícula: 202310207760 
- MATHEUS PATEL AMIN DE AZEVEDO - Matrícula: 202310207519 

---

## 🗂️ Estrutura 
- src/ : código-fonte Java
- doc/DesignPatterns_F1.md : Documento com explicação dos padrões e justificativas

---

## 🧩 Padrões de Projeto Usados 

### **1. Builder Pattern (Criacional)**  
Usado para construir objetos complexos de forma organizada e flexível.  
Arquivos:  
- `CarBuilder.java`  
- `DriverBuilder.java`

### **2. Singleton Pattern (Criacional)**  
Garante que exista apenas uma instância do gerenciador principal da corrida.  
Arquivo:  
- `RaceManager.java`

### **3. Facade Pattern (Estrutural)**  
Simplifica o uso do sistema ao expor métodos práticos para iniciar e gerenciar a corrida.  
Arquivo:  
- `RaceFacade.java`

### **4. Observer Pattern (Comportamental)**  
Permite monitorar e reagir a eventos da corrida.  
Arquivos:  
- `RaceObserver.java`  
- `ConsoleObserver.java`  
- `RaceEvent.java`  
- `RaceEventManager.java`

---

## 📽️ Link do vídeo de apresentação
- https://youtu.be/hfjqqEGGL8c?si=yH13WloqmBEJHicM
