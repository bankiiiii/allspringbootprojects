package com.blogpost.blogpost.services.serviceImpl;


import com.blogpost.blogpost.dto.BlogPostDto;
import com.blogpost.blogpost.exception.PostNotFoundException;
import com.blogpost.blogpost.model.BlogPost;
import com.blogpost.blogpost.repository.BlogPostRepo;
import com.blogpost.blogpost.services.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {

    @Autowired
    private final BlogPostRepo blogPostRepo;


    @Override
    public String createBlogPost(BlogPostDto blogPostDto) {
        // Converted BlogPostDto to BlogPost entity
        BlogPost blogPost = new BlogPost();
        blogPost.setId(blogPostDto.getId());
        blogPost.setName(blogPostDto.getName());
        blogPost.setPost(blogPostDto.getPost());

        blogPostRepo.save(blogPost);

        return "Blog post created successfully";
    }


    @Override
    public List<BlogPostDto> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostRepo.findAll();

        // Converting BlogPost entities to BlogPostDto objects
        // .stream() is to convert blogpost to streams for processing of the list
        List<BlogPostDto> blogPostDtos = blogPosts.stream()
                // .map() to transform each BlogPost entity into a BlogPostDto object using the convertToDto method.
                //:: is a shorthand lambda function calling the covertToDto on the streams
                .map(this::convertToDto)
                //collects the transformed BlogPostDto objects back into a list.
                .collect(Collectors.toList());

        return blogPostDtos;
    }

    //private helper method that takes a BlogPost entity as input and converts it into a BlogPostDto object.
    private BlogPostDto convertToDto(BlogPost blogPost) {
        // Convert a BlogPost entity to a BlogPostDto object here
        BlogPostDto blogPostDto = new BlogPostDto();
        blogPostDto.setId(blogPost.getId());
        blogPostDto.setName(blogPost.getName());
        blogPostDto.setPost(blogPost.getPost());


        return blogPostDto;
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        // Check if a blog post with the given id exists
        if (blogPostRepo.existsById(id)) {
            // If it exists, then it will delete
            blogPostRepo.deletePostById(id);
        } else {

            throw new PostNotFoundException("Blog post with id " + id + " not found");
        }
    }



    @Override
    @Transactional
    public String updateBlogPost(Long id, BlogPostDto updatedBlogPostDto) {
        // Check if a blog post with the given id exists
        BlogPost existingBlogPost = blogPostRepo.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Blog post with id " + id + " not found"));

        // Update the existing blog post with the data from the updatedBlogPostDto
        if (updatedBlogPostDto.getName() != null) {
            existingBlogPost.setName(updatedBlogPostDto.getName());
        }
        if (updatedBlogPostDto.getPost() != null) {
            existingBlogPost.setPost(updatedBlogPostDto.getPost());
        }

        // Save the updated blog post
        blogPostRepo.save(existingBlogPost);

        return "Blog post with id " + id + " updated successfully";
    }





    @Override
    public BlogPostDto getBlogPostById(Long id) {
        // Retrieve the BlogPost entity by ID
        BlogPost blogPost = blogPostRepo.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Blog post with id " + id + " not found"));

        // Convert the BlogPost entity to a BlogPostDto and return it
        return convertToDto(blogPost);
    }


//    @Override
//    public List<BlogPostDto> getBlogPostByUserId(Long id) {
//        List<BlogPostDto> blogPosts = blogPostRepo.findByUserId(id);
//
//        if (blogPosts.isEmpty()) {
//            // You can handle the case where no posts are found, e.g., by returning an empty list or throwing an exception.
//            // For now, let's return an empty list.
//            return Collections.emptyList();
//        }
//
//        // Return the list of BlogPostDto directly
//        return blogPosts;
//    }



}



