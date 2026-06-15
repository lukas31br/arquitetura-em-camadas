package com.uel.integracaosql.service.Impl;

import com.uel.integracaosql.model.Dataset;
import com.uel.integracaosql.repository.DatasetsDAO;
import com.uel.integracaosql.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatasetServiceImpl implements DatasetService {

    private final DatasetsDAO datasetsDAO;

    @Autowired
    public DatasetServiceImpl(DatasetsDAO datasetsDAO) {
        this.datasetsDAO = datasetsDAO;
    }

    @Override
    public List<Dataset> findAll() {
        return datasetsDAO.findAll();
    }

    @Override
    public Optional<Dataset> findById(Long id) {
        return datasetsDAO.findById(id);
    }

    @Override
    public Dataset save(Dataset dataset) {
        return datasetsDAO.save(dataset);
    }

    @Override
    public void deleteById(Long id) {
        datasetsDAO.deleteById(id);
    }
}
