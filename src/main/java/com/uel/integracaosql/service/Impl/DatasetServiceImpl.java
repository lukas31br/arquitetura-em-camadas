package com.uel.integracaosql.service.Impl;

import com.uel.integracaosql.model.Dataset;
import com.uel.integracaosql.repository.DatasetsDAO;
import com.uel.integracaosql.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Registra o serviço de Datasets dentro do container de Inversão de Controle do Spring
public class DatasetServiceImpl implements DatasetService {

    @Autowired // Localiza o DatasetsDAO que possui a conexão com o banco e o injeta aqui
    private DatasetsDAO datasetsDAO;

    @Override
    public List<Dataset> findAll() {
        // Repassa a responsabilidade para a consulta "SELECT * FROM datasets" contida no DatasetsDAO
        return datasetsDAO.listar_datasets();
    }

    @Override
    public Dataset findById(int id) {
        // Aciona o método de busca parametrizada por ID (PreparedStatement.setInt) no seu DAO
        return datasetsDAO.buscar_identificador(id);
    }

    @Override 
    public void save(Dataset dataset) {
        datasetsDAO.inserir_dataset(dataset);
    }
}