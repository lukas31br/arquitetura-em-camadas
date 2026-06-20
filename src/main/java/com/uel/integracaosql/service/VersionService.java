package com.uel.integracaosql.service;

import com.uel.integracaosql.model.Version;
import java.util.List;

public interface VersionService {
    // Contrato contendo as operações que a API Web poderá solicitar
    void save(Version version);
    List<Version> findAll();
    Version findById(int id);
}