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

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            return null;
        }
        usuario.setStatusUsuario("ATIVO");
        usuario.setDataCadastro(LocalDateTime.now().withNano(0));
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario update(Integer id, Usuario dadosNovos) {
        Usuario existente = usuarioRepository.findById(id).orElse(null);
        if (existente == null) return null;

        if (dadosNovos.getNome() != null)          existente.setNome(dadosNovos.getNome());
        if (dadosNovos.getEmail() != null)         existente.setEmail(dadosNovos.getEmail());
        if (dadosNovos.getNivelAcesso() != null)   existente.setNivelAcesso(dadosNovos.getNivelAcesso());
        if (dadosNovos.getStatusUsuario() != null) existente.setStatusUsuario(dadosNovos.getStatusUsuario());

        if (dadosNovos.getSenha() != null && !dadosNovos.getSenha().startsWith("$2a$")) {
            existente.setSenha(passwordEncoder.encode(dadosNovos.getSenha()));
        }

        return usuarioRepository.save(existente);
    }

    public Usuario login(String email, String senha) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && passwordEncoder.matches(senha, usuario.getSenha())) {
            if ("INATIVO".equalsIgnoreCase(usuario.getStatusUsuario())) {
                return null;
            }
            return usuario;
        }
        return null;
    }
}