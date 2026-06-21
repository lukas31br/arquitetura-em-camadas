package com.uel.integracaosql.controller;

import com.uel.integracaosql.model.Dataset;
import com.uel.integracaosql.service.DatasetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Transforma a classe em uma API REST capaz de aceitar e processar requisições HTTP (JSON)
@RequestMapping("/api/datasets") // Define a rota HTTP base padrão para acessar este controlador
@CrossOrigin(origins = "*")
public class DatasetController {

    // Dependência da interface de negócio (Seguindo o princípio de inversão de dependências)
    private final DatasetService datasetService;

    // Injeção de dependência limpa via Construtor (Boa prática recomendada pelo Spring)
    public DatasetController(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @GetMapping // Mapeia requisições do tipo GET para a rota '/api/datasets'
    public ResponseEntity<List<Dataset>> getAllDatasets() {
        // Busca a lista vinda do banco através da camada de serviço
        List<Dataset> datasets = datasetService.findAll();
        // Retorna status HTTP 200 OK contendo a lista convertida automaticamente para JSON
        return ResponseEntity.ok(datasets);
    }

    @GetMapping("/{id}") // Mapeia consultas específicas por id dinâmico na URL (Ex: /api/datasets/4)
    public ResponseEntity<Dataset> getDatasetById(@PathVariable int id) { // @PathVariable captura o valor contido no {id}
        // Solicita ao serviço a busca filtrada no banco
        Dataset dataset = datasetService.findById(id);

        // Validação de segurança: se o banco retornou um objeto populado, exibe-o
        if (dataset != null) {
            return ResponseEntity.ok(dataset);
        }
        // Se o id não corresponder a nada e voltar null, devolve uma resposta limpa com HTTP 404 Not Found
        return ResponseEntity.notFound().build();
    }

    @PostMapping 
    public ResponseEntity<String> createDataset(@RequestBody Dataset dataset) {
        datasetService.save(dataset);
        return ResponseEntity.ok("Dataset cadastrado com sucesso no banco de dados!");
    }
}