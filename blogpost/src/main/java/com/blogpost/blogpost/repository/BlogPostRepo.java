package com.blogpost.blogpost.repository;


import com.blogpost.blogpost.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepo extends JpaRepository<BlogPost, Long> {

    void deletePostById(Long id);

    //List<BlogPostDto> findById(Long id);

}
