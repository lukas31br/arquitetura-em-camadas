package com.uel.integracaosql.controller;

import com.uel.integracaosql.model.Dataset;
import com.uel.integracaosql.service.DatasetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/datasets")
public class DatasetController {

    private final DatasetService datasetService;

    // Injeção de dependência recomendada via construtor
    public DatasetController(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @GetMapping
    public ResponseEntity<List<Dataset>> getAllDatasets() {
        List<Dataset> datasets = datasetService.findAll();
        return ResponseEntity.ok(datasets);
    }

    // NOVO: Endpoint para buscar um conjunto de dados específico (Ex: GET /api/datasets/2)
    @GetMapping("/{id}")
    public ResponseEntity<Dataset> getDatasetById(@PathVariable int id) {
        Dataset dataset = datasetService.findById(id);
        if (dataset != null) {
            return ResponseEntity.ok(dataset);
        }
        return ResponseEntity.notFound().build(); // Retorna HTTP 404 caso o dado não exista
    }
}