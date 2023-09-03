package br.com.fiap.gff.application.web.config;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bson.Document;
import org.springframework.core.io.ClassPathResource;
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
            MigrateCollection("migrations/categorias.txt",
                    "categorias");
            MigrateCollection("migrations/clientes.txt",
                    "clientes");
            MigrateCollection("migrations/produtos.txt",
                    "produtos");
            MigrateCollection("migrations/pedidos.txt",
                    "pedidos");
        } catch (Exception e) {
            log.warn("The migration has failed.");
            log.warn(e.getMessage());
        }
    }

    private void MigrateCollection(String path, String collection) throws Exception {
        log.info("Migrating collection >> " + collection);
        InputStream file = new ClassPathResource(path).getInputStream();
        List<String> fileLines = lines(file);
        String result = importTo(collection, fileLines);
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

    private static List<String> lines(InputStream file) throws Exception {
        List<String> fileLines = new ArrayList<>();
        new BufferedReader(new InputStreamReader(file)).lines().forEach(fileLines::add);
        return fileLines;
    }

}
