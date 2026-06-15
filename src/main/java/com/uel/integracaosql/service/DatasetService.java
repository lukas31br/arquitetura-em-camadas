package com.uel.integracaosql.service;

import com.uel.integracaosql.model.Dataset;
import java.util.List;
import java.util.Optional;

public interface DatasetService {
    List<Dataset> findAll();
    Optional<Dataset> findById(Long id);
    Dataset save(Dataset dataset);
    void deleteById(Long id);
}