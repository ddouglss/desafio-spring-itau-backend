package desafio.itau.springboot.service;

// Importa a classe Transaction que você criou (modelo dos dados)
import desafio.itau.springboot.model.Transaction;

// Define que essa classe é um componente de serviço no Spring (injeção automática)
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class TransactionService {

    // Fila thread-safe para armazenar transações na memória (ordem de chegada)
    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    // Adiciona uma nova transação na fila
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction); // Corrigido: não deve usar o mesmo nome da variável como parâmetro
    }

    // Limpa todas as transações da fila
    public void clerTrasactions() {
        transactions.clear();
    }

    // Calcula estatísticas com base nas transações dos últimos 60 segundos
    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now(); // Marca o momento atual

        // Explicação da linha abaixo:
        return transactions.stream()                            // 1. Cria um stream com a fila de transações
                .filter(t -> t.getDataHora()          // 2. Filtra transações que ocorreram nos últimos 60s
                        .isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor)            // 3. Transforma cada transação em um valor double (valor da transação)
                .summaryStatistics();                          // 4. Gera um resumo com: count, sum, min, average e max
    }

}
