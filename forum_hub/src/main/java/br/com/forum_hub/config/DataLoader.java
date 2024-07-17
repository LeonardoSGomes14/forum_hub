package br.com.forum_hub.config;



import br.com.forum_hub.model.Autor;
import br.com.forum_hub.model.Curso;
import br.com.forum_hub.model.Estado;
import br.com.forum_hub.model.Topico;
import br.com.forum_hub.repository.AutorRepository;
import br.com.forum_hub.repository.CursoRepository;
import br.com.forum_hub.repository.EstadoRepository;
import br.com.forum_hub.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void run(String... args) throws Exception {
        Autor autor = new Autor("nome", "email@exemplo.com");
        autorRepository.save(autor);

        Curso curso = new Curso("Curso", "Descrição do Curso Exemplo");
        cursoRepository.save(curso);

        Estado estado = new Estado("Aberto");
        estadoRepository.save(estado);

        LocalDateTime dataAtual = LocalDateTime.now();

        Topico topico = new Topico("Título do Tópico", "Mensagem do Tópico", estado, autor, curso);
        topico.setDataCriacao(dataAtual); // Define a data de criação explicitamente
        topicoRepository.save(topico);
    }
}
