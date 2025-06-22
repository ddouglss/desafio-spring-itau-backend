# 🚀 desafio-itau-backend

**Desafio técnico proposto pelo Itaú Unibanco** para avaliação de habilidades em desenvolvimento e engenharia de software.  
Este projeto consiste em uma **API REST construída com Spring Boot** para **registrar transações e calcular estatísticas** dos últimos 60 segundos, com **armazenamento em memória** e **sem uso de banco de dados**.

---

## 📌 Tecnologias Utilizadas

- Java 17  
- Spring Boot  
- API REST  
- Java Time API (`OffsetDateTime`)  
- `DoubleSummaryStatistics`  
- Concurrent Collections (`ConcurrentLinkedDeque`)  
- Validação com Bean Validation  
- [Lombok](https://projectlombok.org/)  
- JUnit (testes)  
- Maven  

---

## 📦 Funcionalidades da API

### ✅ `POST /transacao`

Registra uma nova transação com `valor` e `dataHora`.

#### 📥 Request Body (JSON)

```json
{
  "valor": 123.45,
  "dataHora": "2025-06-22T03:20:00Z"
}
```
### ✅ Regras de validação
valor deve ser maior ou igual a 0

dataHora não pode estar no futuro

valor e dataHora são obrigatórios

### 📤 Respostas
201 Created – Transação registrada com sucesso

422 Unprocessable Entity – Transação inválida

400 Bad Request – JSON inválido

### 🗑️ `DELETE /transacao`
Remove todas as transações armazenadas na memória.

### 📤 Resposta
200 OK – Todas as transações foram apagadas com sucesso

### 📊 `GET /estatistica`
Retorna estatísticas das transações ocorridas nos últimos 60 segundos.

### 📤 Response Body (JSON)
```json
{
  "count": 5,
  "sum": 250.00,
  "avg": 50.00,
  "min": 20.00,
  "max": 80.00
}
```
Se nenhuma transação for registrada nos últimos 60 segundos, os valores retornados são todos 0.

📝 Como rodar localmente
1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/desafio-itau-backend.git
cd desafio-itau-backend
```
2. Compile e execute
```bash
Copiar
Editar
./mvnw spring-boot:run
```
3. Acesse a API
```arduino
Copiar
Editar
http://localhost:8080/
```
### 📬 Contato
Desenvolvido por <h3>Douglas Muniz</h3>
