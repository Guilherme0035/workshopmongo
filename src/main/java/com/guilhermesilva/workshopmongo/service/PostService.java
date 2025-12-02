package com.guilhermesilva.workshopmongo.service;

import com.guilhermesilva.workshopmongo.domain.Post;
import com.guilhermesilva.workshopmongo.repository.PostRepository;
import com.guilhermesilva.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findPostById(String id){
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minData, Date maxData){
        Date maxDate = new Date(maxData.getTime() + 24 * 60 * 60 * 1000);
        return  postRepository.fullSearch(text,minData,maxData);
    }

}
