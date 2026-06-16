package com.uel.integracaosql.service;

import com.uel.integracaosql.model.Dataset;
import java.util.List;

public interface DatasetService {
    List<Dataset> findAll();
    Dataset findById(int id);
}