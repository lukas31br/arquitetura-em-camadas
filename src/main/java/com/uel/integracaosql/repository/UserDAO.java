/*O DAO (Data Access Object) é o nome dado à classe que conecta-se com o banco de dados. O service contém
* toda a programação e requer que o DAO acesse o banco de dados para isso.
*
* -> DAO(Data Access Object) is the name given to the class that is connected with the database.
* Service have all programming needs that DAO access the database for this. */

package com.uel.integracaosql.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;
import com.uel.integracaosql.model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused","SqlNoDataSourceInspection"})
@Repository // Avisa ao spring boot que essa classe vai ter acesso ao banco de dados.
            // Explaining to spring boot that this class will have access to the database.

public class UserDAO { // Nome do arquivo
                       // File name

    @Autowired // Serve para injetar automaticamente a conexão feita pelo DataSource
               // Used to inject automatically the connection created by DataSource

    private DataSource dataSource; // Cria um objeto dataSource proveniente do método DataSource
                                   // Create a dataSource object from the DataSource method

    public void cadastro_usuario(Users users) { // Método para cadastrar um usuário
                                                   // Method for sign up a user

        String sql = "INSERT INTO users (id_users, name, email, password) VALUES (?, ?, ?, ?)"; // Código em texto que posteriormente será aplicado ao postgresql

        try (Connection conn = dataSource.getConnection(); //  Cria uma conexão com o dataSource
                                                              // Create a connection with dataSource

             PreparedStatement comando = conn.prepareStatement(sql)) { // O PreparedStatement serve para informar ao postgresql que um texto irá entrar como
                                                                       // comando; e então cria-se um objeto chamado comando que recebe o objeto conn
                                                                       // criado pelo método Connection. Esse conexão tem a função prepareStatement que recebe
                                                                       // o texto que será usado.

                                                                        // The PreparedStatemente is used to tell to postgresql that a text will go in as
                                                                        // command;and, so is created an object called new that receive the object conn
                                                                        // created by method Connection. This connection have the function prepareStatement
                                                                        // that receive the text that will be used.

            comando.setString(1, users.getName());// o objeto novo criado que possui as propriedades de colocar algo no banco de dados
                                                                // recebe na primeira posição o nome e substitui a primeira ? por esse nome.

                                                               // The new created object that got the properties of put something in the database
                                                               // receive in first position the name and change the first ? to this name. The same
                                                               // situation happens with the methods below


            comando.setString(2, users.getPassword());
            comando.setString(3, users.getEmail());

            comando.executeUpdate(); // Executa o método
                                  // Executing the method

        } catch (SQLException mensagem) { // Atribui à variável mensagem o erro que será causado caso o algoritmo entre no catch

                                          // Assigning to message variable the error that will be caused if the algorithm
                                          // enter in catch

            System.out.print("ERROR: " + mensagem.getMessage()); // Exibe a mensagem de erro
                                                                 // Exibe the error message

            throw new RuntimeException(mensagem); // usado para forçar o java a parar
                                                 // used to force java to stop
        }
    }

    public List<Users> listar_users () { // Uma lista dinâmica para armazenar os datasets buscados

        String sql = "SELECT * FROM users";

        List<Users> lista = new ArrayList<>();

        try (Connection conn = dataSource.getConnection(); // cria uma conexão com o dataSource
             // create a connection with dataSource

             PreparedStatement comando = conn.prepareStatement(sql)) {// Avisa ao SQL que um comando terá que ser executado no banco de dados

            ResultSet result = comando.executeQuery(); // Gera uma planilha temporária que armazena os dados desejados para exibição


            while (result.next()) { // enquanto existir uma proxima linha
                // while exist a next line
                Users user = new Users();

                user.setId_users(result.getInt("id_users"));

                user.setName(result.getString("name"));

                user.setEmail(result.getString("email"));

                user.setPassword(result.getString("password"));

                lista.add(user);

            }

            return lista;

        } catch (SQLException message) {

            System.out.println("ERROR!! Can't possible to list datasets");

            throw new RuntimeException(message);

        }
        }
    }