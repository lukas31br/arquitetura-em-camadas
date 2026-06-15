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

    // Injeção de dependência via construtor do Spring
    public DatasetController(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    // Exemplo de Endpoint para buscar todos os conjuntos de dados (GET /api/datasets)
    @GetMapping
    public ResponseEntity<List<Dataset>> getAllDatasets() {
        // Altere o método de chamada do serviço de acordo com o nome que você definiu na sua DatasetService
        List<Dataset> datasets = datasetService.findAll();
        return ResponseEntity.ok(datasets);
    }
}