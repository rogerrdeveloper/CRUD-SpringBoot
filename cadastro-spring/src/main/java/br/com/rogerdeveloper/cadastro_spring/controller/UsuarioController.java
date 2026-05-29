package br.com.rogerdeveloper.cadastro_spring.controller;

import br.com.rogerdeveloper.cadastro_spring.business.UsuarioService;
import br.com.rogerdeveloper.cadastro_spring.infraestructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario user) {
        usuarioService.salvarUsuario(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        Usuario usuario = usuarioService.buscarPorEmail(email);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        usuarioService.deletarUsuario(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuario (@RequestParam String email,
                                                  @RequestBody Usuario user) {
        usuarioService.atualizarUsuario(email, user);
        return ResponseEntity.ok().build();
    }
}
