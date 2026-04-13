package com.itb.inf2am.Zeroum.model.services;

import com.itb.inf2am.Zeroum.model.entity.Usuario;
import com.itb.inf2am.Zeroum.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Listar todos os usuários
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Salvar um usuário no banco
    public Usuario save(Usuario usuario) {
        usuario.setStatusUsuario("ATIVO");
        usuario.setDataCadastro(LocalDateTime.now().withNano(0));
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    // Buscar por ID
    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Atualizar usuário
    public Usuario update(Integer id, Usuario dadosNovos) {
        Usuario existente = usuarioRepository.findById(id).orElse(null);
        if (existente == null) return null;

        if (dadosNovos.getNome() != null)          existente.setNome(dadosNovos.getNome());
        if (dadosNovos.getEmail() != null)         existente.setEmail(dadosNovos.getEmail());
        if (dadosNovos.getNivelAcesso() != null)   existente.setNivelAcesso(dadosNovos.getNivelAcesso());
        if (dadosNovos.getStatusUsuario() != null) existente.setStatusUsuario(dadosNovos.getStatusUsuario());

        // Só re-encripta a senha se vier uma nova senha em texto puro
        if (dadosNovos.getSenha() != null && !dadosNovos.getSenha().startsWith("$2a$")) {
            existente.setSenha(passwordEncoder.encode(dadosNovos.getSenha()));
        }

        return usuarioRepository.save(existente);
    }

    // Login
    public Usuario login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && passwordEncoder.matches(senha, usuario.getSenha())) {
            return usuario;
        }
        return null;
    }
}
