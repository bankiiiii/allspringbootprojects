package com.blogpost.blogpost.controller;


import com.blogpost.blogpost.dto.BlogPostDto;
import com.blogpost.blogpost.exception.PostNotFoundException;
import com.blogpost.blogpost.services.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/blogPostDto")
public class BlogPostController {

    private final BlogPostService blogPostService;



    @PostMapping("/createBlogPost")
    public ResponseEntity<String> createBlogPost(@RequestBody BlogPostDto blogPostDto) {
        String createBlogPost = blogPostService.createBlogPost(blogPostDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBlogPost);
    }



    @GetMapping("/getAllBlogPost")
    public ResponseEntity<List<BlogPostDto>> getAllBlogPosts()
    {
        List <BlogPostDto> listOfPosts =  blogPostService.getAllBlogPosts();
        ResponseEntity<List<BlogPostDto>> post = new ResponseEntity<List<BlogPostDto>>(listOfPosts, HttpStatus.OK);
        return post;
    }

    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<String> deleteBlogPostByUserId(@PathVariable Long id)


    {
        ResponseEntity<String> deletePost = null;
        try
        {
            blogPostService.deleteById(id);
            deletePost = new ResponseEntity<String>("post removed " + id ,HttpStatus.OK);

        }
        catch (PostNotFoundException pe)
        {
            pe.printStackTrace();
            deletePost = new ResponseEntity<String>(pe.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

        return deletePost;
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateBlogPostById(
            @PathVariable Long id,
            @RequestBody BlogPostDto updatedBlogPostDto) {

        ResponseEntity<String> updateResponse = null;

        try {
            BlogPostDto existingBlogPost = blogPostService.getBlogPostById(id);

            if (existingBlogPost != null) {
                if (updatedBlogPostDto.getName() != null) {
                    existingBlogPost.setName(updatedBlogPostDto.getName());
                }

                if (updatedBlogPostDto.getPost() != null) {
                    existingBlogPost.setPost(updatedBlogPostDto.getPost());
                }

                // Add more fields to update as needed

                blogPostService.updateBlogPost(id, existingBlogPost);
                updateResponse = new ResponseEntity<>("Blog post with id " + id + " updated successfully", HttpStatus.OK);
            } else {
                updateResponse = new ResponseEntity<>("Blog post with id " + id + " not found", HttpStatus.NOT_FOUND);
            }
        } catch (PostNotFoundException pe) {
            pe.printStackTrace();
            updateResponse = new ResponseEntity<>(pe.getMessage(), HttpStatus.NOT_FOUND);
        }

        return updateResponse;
    }




//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> updateBlogPostById( @PathVariable Long id, @RequestBody BlogPostDto updatedBlogPostDto)
//    {
//
//        ResponseEntity<String> updateResponse = null;
//
//        try {
//            blogPostService.updateBlogPostById(id, updatedBlogPostDto);
//            updateResponse = new ResponseEntity<>("Blog post with id " + id + " updated successfully", HttpStatus.OK);
//        } catch (PostNotFoundException pe) {
//            pe.printStackTrace();
//            updateResponse = new ResponseEntity<>(pe.getMessage(), HttpStatus.NOT_FOUND);
//        }
//
//        return updateResponse;
//    }
}
