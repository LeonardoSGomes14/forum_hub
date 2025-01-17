package br.com.forum_hub.controller;


import br.com.forum_hub.security.DadosTokenJWT;
import br.com.forum_hub.security.TokenService;
import br.com.forum_hub.usuario.DadosAutenticacao;
import br.com.forum_hub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity efetuarLogin (@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken ( dados.login ( ), dados.senha ( ) );
        var authentication = manager.authenticate ( authenticationToken );

        var tokenJWT = tokenService.gerarToken ( (Usuario) authentication.getPrincipal ( ) );

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}