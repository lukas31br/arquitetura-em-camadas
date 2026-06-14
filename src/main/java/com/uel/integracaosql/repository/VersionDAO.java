package com.uel.integracaosql.repository;
import com.uel.integracaosql.model.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@SuppressWarnings("unused")

@Repository

public class VersionDAO {
    @Autowired

    DataSource dataSource;

    public void insert_version(Version version){

        String sql = "INSERT INTO version(id_dataset,id_creator,id_base_version,archive_path,changes) VALUES(?,?,?,?,?,?)";

        try(Connection conn = dataSource.getConnection();

            PreparedStatement comando = conn.prepareStatement(sql)){

            comando.setInt(2, version.getId_dataset());
            comando.setInt(3,version.getId_creator());
            comando.setInt(4,version.getId_base_version());
            comando.setString(5,version.getArchive_path());
            comando.setString(6,version.getChanges());

            comando.executeUpdate();
        }catch (SQLException message) {
            System.err.println("ERROR");
            throw new RuntimeException(message);
    }
    }

    public List<Version> list_version (){ // Uma lista dinâmica para armazenar as versões buscadas

        String sql = "SELECT * FROM version";

        List<Version> lista = new ArrayList<>();

        try(Connection conn = dataSource.getConnection(); // cria uma conexão com o dataSource
            // create a connection with dataSource

            PreparedStatement comando = conn.prepareStatement(sql)){// Avisa ao SQL que um comando terá que ser executado no banco de dados

            ResultSet result = comando.executeQuery();

            while(result.next()){ // enquanto existir uma proxima linha
                // while exist a next line
                Version version = new Version();

                version.setId_version(result.getInt("id_version"));

                version.setId_dataset(result.getInt("id_dataset"));

                version.setId_creator(result.getInt("id_creator"));

                version.setId_base_version(result.getInt("id_base_version"));

                version.setArchive_path(result.getString("archive_path"));

                version.setChanges(result.getString("changes"));

                lista.add(version);

            }


            return lista;

        } catch(SQLException message){

            System.out.println("ERROR!! Can't possible to list versions");

            throw new RuntimeException(message);

        }

    }

    public Version buscarIdentificador(int id){

        String sql = "SELECT * FROM version WHERE id_version = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement comando = conn.prepareStatement(sql)) {
            comando.setInt(1, id);

            try(ResultSet resultado = comando.executeQuery()){

                if(resultado.next()){
                    Version version = new Version();

                    version.setId_version(resultado.getInt("id_version"));

                    version.setId_dataset(resultado.getInt("id_dataset"));

                    version.setId_creator(resultado.getInt("id_creator"));

                    version.setId_base_version(resultado.getInt("id_base_version"));

                    version.setArchive_path(resultado.getString("archive_path"));

                    version.setChanges(resultado.getString("changes"));

                    return version;
                } else {
                    System.out.print("ERROR! ");
                }
            }
        } catch (SQLException message){
            System.out.println("ERROR!! Can't possible find dataset");
            throw new RuntimeException(message);

        }

        return null;
    }


}
