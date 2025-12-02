package com.guilhermesilva.workshopmongo.config;

import com.guilhermesilva.workshopmongo.domain.Post;
import com.guilhermesilva.workshopmongo.domain.User;
import com.guilhermesilva.workshopmongo.dto.AuthorDTO;
import com.guilhermesilva.workshopmongo.dto.CommentDTO;
import com.guilhermesilva.workshopmongo.repository.PostRepository;
import com.guilhermesilva.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@Configuration
public class instantiaton implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria,alex,bob));


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));


        Post post1 = new Post(null, sdf.parse("20/11/2025"), "Partiu viagem", "Vou viajar para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("15/11/2025"),"Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!",Instant.parse("2019-06-20T21:53:07Z"),new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite!",Instant.parse("2019-06-20T21:53:07Z"),new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", Instant.parse("2019-06-20T21:53:07Z"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(maria);
    }
}
