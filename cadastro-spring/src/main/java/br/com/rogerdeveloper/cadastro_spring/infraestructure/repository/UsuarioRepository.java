package br.com.rogerdeveloper.cadastro_spring.infraestructure.repository;

import br.com.rogerdeveloper.cadastro_spring.infraestructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Jpa recebe a tabela e ID
    Optional<Usuario> findByEmail (String email);
    //optional obriga caso nao tenha nada, a enviar um else
    //findby é regra e sempre será chamado
    //o nome email precisa corresponder ao mesmo nome na tabela usuario

    @Transactional //anotação para caso tenha qualquer erro, nao deletar o email
    void deleteByEmail (String email);

}
