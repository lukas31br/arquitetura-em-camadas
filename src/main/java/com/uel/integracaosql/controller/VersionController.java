package com.uel.integracaosql.controller;

import com.uel.integracaosql.model.Version;
import com.uel.integracaosql.service.VersionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/versions") // Rota base que o Frontend chamará no Tomcat
@CrossOrigin(origins = "*")      // Liberação de CORS necessária para o seu Frontend conseguir ler
public class VersionController {

    private final VersionService versionService;

    // Injeção de dependência via construtor
    public VersionController(VersionService versionService) {
        this.versionService = versionService;
    }

    // Endpoint para Listar Todas as Versões: GET http://localhost:8080/api/versions
    @GetMapping
    public ResponseEntity<List<Version>> getAllVersions() {
        List<Version> versions = versionService.findAll();
        return ResponseEntity.ok(versions); // Retorna 200 OK com a lista em JSON
    }

    // Endpoint para Buscar por ID: GET http://localhost:8080/api/versions/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Version> getVersionById(@PathVariable int id) {
        Version version = versionService.findById(id);

        // Trata a incoerência do retorno nulo do DAO: se não achar, envia 404 Not Found
        if (version == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(version); // Retorna 200 OK se achar
    }

    // Endpoint para Criar uma Versão: POST http://localhost:8080/api/versions
    @PostMapping
    public ResponseEntity<String> createVersion(@RequestBody Version version) {
        versionService.save(version);
        // Como a rotina JDBC nativa do insert é void, retornamos uma mensagem de sucesso textual
        return ResponseEntity.ok("Versão cadastrada com sucesso no banco de dados!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVersion(@PathVariable int id) {
        versionService.delete(id);
        return ResponseEntity.ok("Versão deletada com sucesso!");
    }
}