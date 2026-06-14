package com.uel.integracaosql.repository;
import com.uel.integracaosql.model.Dataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")

@Repository // Informa ao spring boot que a classe terá acesso ao banco de dados

            // Tell to spring boot that class will be access to database

public class DatasetsDAO{ // Cria a classe DataSetsDAO

                         // Creating the class DataSetsDAO

    @Autowired // Injeta as informações salvas pelo Bean dentro de dataSource

               // Inject the information save by Bean into dataSource

    private DataSource dataSource; // Cria um objeto dataSource da classe DataSource

                                   // Create an object dataSource of class DataSource

    public void inserir_dataset(Dataset dataset){

        String sql = "INSERT INTO datasets(id_creator,description,date_hour,source) VALUES(?,?,?,?)"; // Informa o código que será inserido no SQL
                                                                                                      // Informs the code that  will be inserted in SQL

        try(Connection conn = dataSource.getConnection(); // Abre uma conexão com o dataSource

                                                          // Open a connection with dataSource

            PreparedStatement novo = conn.prepareStatement(sql)){ // Informa o postgre que uma instrução será dada

                                                                  // Informs to postgre that an instruction will be given

                novo.setInt(1,dataset.getId_creator()); // O id do criador é  informado e a primeira ? recebe ele

                                                                     // The id of creater is informated and the first ? given it


                novo.setString(2, dataset.getDescription());

                novo.setObject(3, dataset.getDate_hour());


                novo.setString(4,dataset.getSource());

                novo.executeUpdate(); // É executado

                                      // Is executed

                } catch(SQLException message){

            System.out.println("ERROR!! Can't possible insert dataset");

            throw new RuntimeException(message);
        }

        }
    public List<Dataset> listar_datasets (){ // Uma lista dinâmica para armazenar os datasets buscados

        String sql = "SELECT * FROM datasets";

        List<Dataset> lista = new ArrayList<>();

        try(Connection conn = dataSource.getConnection(); // cria uma conexão com o dataSource
                                                            // create a connection with dataSource

            PreparedStatement comando = conn.prepareStatement(sql)){// Avisa ao SQL que um comando terá que ser executado no banco de dados

            ResultSet result = comando.executeQuery(); // Gera uma planilha temporária que armazena os dados desejados para exibição
                                                       //


            while(result.next()){ // enquanto existir uma proxima linha
                                  // while exist a next line
                Dataset dataset = new Dataset();

                dataset.setId_datasets(result.getInt("id_datasets"));

                dataset.setDescription(result.getString("description"));

                dataset.setSource(result.getString("source"));

                dataset.setId_creator(result.getInt("id_creator"));

                lista.add(dataset);

            }


            return lista;

        } catch(SQLException message){

            System.out.println("ERROR!! Can't possible to list datasets");

            throw new RuntimeException(message);

        }

    }

     public Dataset buscar_identificador(int id){

        String sql = "SELECT * FROM datasets WHERE id_datasets = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement comando = conn.prepareStatement(sql)) {
            comando.setInt(1, id);

            try(ResultSet resultado = comando.executeQuery()){
                if(resultado.next()){
                    Dataset dataset = new Dataset();

                    dataset.setId_datasets(resultado.getInt("id_datasets"));
                    dataset.setDescription(resultado.getString("description"));
                    dataset.setSource(resultado.getString("source"));
                    dataset.setId_creator(resultado.getInt("id_creator"));
                    return dataset;
                } else {
                    System.out.print("ERROR");
                }
            }
            } catch (SQLException message){
            System.out.println("ERROR!! Can't possible find dataset");
            throw new RuntimeException(message);

        }

         return null;
    }

}



