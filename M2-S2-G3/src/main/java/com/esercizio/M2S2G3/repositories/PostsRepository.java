package com.esercizio.M2S2G3.repositories;

import com.esercizio.M2S2G3.entities.Author;
import com.esercizio.M2S2G3.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<BlogPost,Integer> {

    List<BlogPost> findByAuthor(Author author);
}
