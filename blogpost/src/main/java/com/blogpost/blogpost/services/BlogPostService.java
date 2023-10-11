package com.blogpost.blogpost.services;


import com.blogpost.blogpost.dto.BlogPostDto;

import java.util.List;

public interface BlogPostService {

    List<BlogPostDto> getAllBlogPosts();

//    List<BlogPostDto> getBlogPostByUserId(Long userId);
    String createBlogPost(BlogPostDto blogPostDto);
    String updateBlogPost(Long id, BlogPostDto updatedBlogPostDto);

//    BlogPostDto getBlogPostById(Long id);

    //void deleteBlogPostByUserId(Long userId);

    //List<BlogPostDto> getBlogPostsById(Long id);


    void deleteById(Long id);

    //List<BlogPostDto> getBlogPostByUserId(Long id);

    BlogPostDto getBlogPostById(Long id);

   // List<BlogPostDto> findById(Long id);
}
