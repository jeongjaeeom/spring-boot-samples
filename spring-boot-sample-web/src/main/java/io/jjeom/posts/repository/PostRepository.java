package io.jjeom.posts.repository;

import io.jjeom.posts.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author eomjeongjae
 * @since 2019-01-25
 */
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findByTitle(String title);
}
