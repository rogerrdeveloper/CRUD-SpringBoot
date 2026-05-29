package br.com.rogerdeveloper.cadastro_spring.business;

import br.com.rogerdeveloper.cadastro_spring.infraestructure.entitys.Usuario;
import br.com.rogerdeveloper.cadastro_spring.infraestructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario user) {
        repository.saveAndFlush(user);
        //chama o Repository. Salva e fecha a conexão com banco de dados
    }

    public Usuario buscarPorEmail (String email) {
        return repository.findByEmail(email).orElse(null);
        //o or else null é o optional agindo
    }

    public void deletarUsuario(String email) {
        repository.deleteByEmail(email);
    }

    public void atualizarUsuario(String email, Usuario user) {
        Usuario usuarioEntity = buscarPorEmail(email);
        // reaproveitamento do buscarporemail para procurar no banco de dados
        Usuario usuarioAtualizado = Usuario.builder() //builder serve para criar esses parametros
                .email(user.getEmail() != null ?
                        user.getEmail() : usuarioEntity.getEmail() )
                // verifico se o usuarion passou no body o email
                // caso nao tenha nada, vai reaproveitar o email que passou no body para buscar
                // ? = preencher e : = igual a "ou"

                .nome(user.getNome() != null ?
                        user.getNome() : usuarioEntity.getNome())
                // verifico se o usuario passou o nome no body
                .build();
        repository.saveAndFlush(usuarioAtualizado);
    }


}
