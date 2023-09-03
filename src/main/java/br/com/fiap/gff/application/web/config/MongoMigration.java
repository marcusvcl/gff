package br.com.fiap.gff.application.web.config;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bson.Document;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.MongoBulkWriteException;

import br.com.fiap.gff.domain.gateway.ClienteGateway;
import br.com.fiap.gff.domain.model.entities.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class MongoMigration {

    private final MongoTemplate mongoTemplate;
    private final ClienteGateway clienteGateway;

    public void Start() {
        log.info("Migrations started");
        try {
            Collection<Cliente> clientes = clienteGateway.obterTodosClientes();
            if (clientes.size() != 0)
                return;
            MigrateCollection("src/main/java/br/com/fiap/gff/application/web/config/migrations/categorias.txt",
                    "categorias");
            MigrateCollection("src/main/java/br/com/fiap/gff/application/web/config/migrations/clientes.txt",
                    "clientes");
            MigrateCollection("src/main/java/br/com/fiap/gff/application/web/config/migrations/produtos.txt",
                    "produtos");
            MigrateCollection("src/main/java/br/com/fiap/gff/application/web/config/migrations/pedidos.txt",
                    "pedidos");
        } catch (Exception e) {
            log.warn("The migration has failed.");
            e.getStackTrace();
        }
    }

    private void MigrateCollection(String path, String collection) throws Exception {
        log.info("Migrating collection >> " + collection);
        File clientes = new File(path);
        List<String> linhasCliente = lines(clientes);
        String result = importTo(collection, linhasCliente);
        log.info("Imported " + result + " lines into " + collection);
    }

    private List<Document> generateMongoDocuments(List<String> lines) {
        List<Document> docs = new ArrayList<>();
        for (String line : lines) {
            docs.add(Document.parse(line));
        }
        return docs;
    }

    private int insertInto(String collection, List<Document> mongoDocs) {
        try {
            Collection<Document> inserts = mongoTemplate.insert(mongoDocs, collection);
            return inserts.size();
        } catch (DataIntegrityViolationException e) {
            if (e.getCause() instanceof MongoBulkWriteException) {
                return ((MongoBulkWriteException) e.getCause()).getWriteResult().getInsertedCount();
            }
            return 0;
        }
    }

    private String importTo(String collection, List<String> jsonLines) {
        List<Document> mongoDocs = generateMongoDocuments(jsonLines);
        int inserts = insertInto(collection, mongoDocs);
        return inserts + "/" + jsonLines.size();
    }

    private static List<String> lines(File file) throws Exception {
        return Files.readAllLines(file.toPath());
    }

}
