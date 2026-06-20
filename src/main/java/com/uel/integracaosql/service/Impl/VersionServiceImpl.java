package com.uel.integracaosql.service.Impl;

import com.uel.integracaosql.model.Version;
import com.uel.integracaosql.repository.VersionDAO;
import com.uel.integracaosql.service.VersionService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Registra a classe como um Bean de Serviço gerenciado pelo Spring
public class VersionServiceImpl implements VersionService {

    private final VersionDAO versionDAO;

    // Injeção de dependência recomendada via construtor
    public VersionServiceImpl(VersionDAO versionDAO) {
        this.versionDAO = versionDAO;
    }

    @Override
    public void save(Version version) {
        // Faz a ponte com o método de inserção do JDBC manual
        versionDAO.insert_version(version);
    }

    @Override
    public List<Version> findAll() {
        // Faz a ponte com o método de listagem do JDBC manual
        return versionDAO.list_version();
    }

    @Override
    public Version findById(int id) {
        // Faz a ponte com o método de busca por identificador do JDBC manual
        return versionDAO.buscarIdentificador(id);
    }
}