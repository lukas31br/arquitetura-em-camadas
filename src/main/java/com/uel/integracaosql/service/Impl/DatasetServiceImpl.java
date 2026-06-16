package com.uel.integracaosql.service.Impl;

import com.uel.integracaosql.model.Dataset;
import com.uel.integracaosql.repository.DatasetsDAO;
import com.uel.integracaosql.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DatasetServiceImpl implements DatasetService {

    @Autowired
    private DatasetsDAO datasetsDAO;

    @Override
    public List<Dataset> findAll() {
        return datasetsDAO.listar_datasets();
    }

    @Override
    public Dataset findById(int id) {
        // Faz a ponte exata para a busca com filtro por id
        return datasetsDAO.buscar_identificador(id);
    }
}