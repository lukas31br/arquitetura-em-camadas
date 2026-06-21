package com.uel.integracaosql.service;

import com.uel.integracaosql.model.Dataset;
import java.util.List;

/**
 * Interface que define as operações permitidas sobre a entidade Dataset.
 */
public interface DatasetService {

    // Contrato para retornar a lista global de datasets
    List<Dataset> findAll();

    // Contrato para buscar um dataset único filtrado pelo seu ID numérico
    Dataset findById(int id);

    void save(Dataset dataset);
}