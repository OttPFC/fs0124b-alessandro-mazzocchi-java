package com.esercizio.M2S2G3.services;

import com.esercizio.M2S2G3.entities.Author;
import com.esercizio.M2S2G3.entities.BlogPost;
import com.esercizio.M2S2G3.exceptions.NotFoundException;
import com.esercizio.M2S2G3.payloads.NewPostPayload;
import com.esercizio.M2S2G3.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private PostsRepository blogsRepository;
    @Autowired
    private AuthorService authorsService;

    public BlogPost save(NewPostPayload body) {
        Author author = authorsService.findById(body.getAuthorId());
        BlogPost newBlogPost = new BlogPost();
        newBlogPost.setReadingTime(body.getReadingTime());
        newBlogPost.setContent(body.getContent());
        newBlogPost.setTitle(body.getTitle());
        newBlogPost.setAuthor(author);
        newBlogPost.setCategory(body.getCategory());
        newBlogPost.setCover("http://picsum.photos/200/300");
        return blogsRepository.save(newBlogPost);
    }

    public List<BlogPost> getBlogs() {
        return blogsRepository.findAll();
    }

    public BlogPost findById(int id) {
        return blogsRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) {
        BlogPost found = this.findById(id);
        blogsRepository.delete(found);
    }

    public BlogPost findByIdAndUpdate(int id, NewPostPayload body) {
        BlogPost found = this.findById(id);

        found.setReadingTime(body.getReadingTime());
        found.setContent(body.getContent());
        found.setTitle(body.getTitle());
        found.setCategory(body.getCategory());

        if(found.getAuthor().getId()!= body.getAuthorId()) {
            Author newAuthor = authorsService.findById(body.getAuthorId());
            found.setAuthor(newAuthor);
        }

        return blogsRepository.save(found);
    }

    public List<BlogPost> findByAuthor(int authorId){
        Author author = authorsService.findById(authorId);
        return blogsRepository.findByAuthor(author);
    }
}
