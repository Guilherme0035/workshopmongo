package com.guilhermesilva.workshopmongo.config;

import com.guilhermesilva.workshopmongo.domain.Post;
import com.guilhermesilva.workshopmongo.domain.User;
import com.guilhermesilva.workshopmongo.dto.AuthorDTO;
import com.guilhermesilva.workshopmongo.repository.PostRepository;
import com.guilhermesilva.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.xml.crypto.Data;
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

        Post post1 = new Post(null, Instant.parse("2019-06-20T21:53:07Z"), "Partiu comer", "Vou viajar para São Paulo", new AuthorDTO(maria));
        Post post2 = new Post(null, Instant.parse("2019-06-20T21:53:07Z"),"Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));


        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}
