package com.esercizio.M2S2G3.controllers;

import com.esercizio.M2S2G3.entities.BlogPost;
import com.esercizio.M2S2G3.payloads.NewPostPayload;
import com.esercizio.M2S2G3.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    BlogPostService blogsService;


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public BlogPost saveBlog(@RequestBody NewPostPayload body) {
        return blogsService.save(body);
    }


    @GetMapping("")
    public List<BlogPost> getBlogs(@RequestParam(required = false) Integer authorId) {
        if(authorId != null) return blogsService.findByAuthor(authorId);
        else return blogsService.getBlogs();
    }

    @GetMapping("/{blogId}")
    public BlogPost findById(@PathVariable int blogId) {
        return blogsService.findById(blogId);
    }

    @PutMapping("/{blogId}")
    public BlogPost findAndUpdate(@PathVariable int blogId, @RequestBody NewPostPayload body) {
        return blogsService.findByIdAndUpdate(blogId, body);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findAndDelete(@PathVariable int blogId) {
        blogsService.findByIdAndDelete(blogId);
    }
}
