package io.jjeom.posts.repository;

import io.jjeom.posts.entity.Post;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author eomjeongjae
 * @since 2019-01-25
 */
@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void save() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = repository.save(post); // persist

        assertThat(entityManager.contains(savedPost)).isTrue();
        assertThat(entityManager.contains(post)).isTrue();
        assertThat(savedPost == post);

        Post postUpdate = new Post();
        postUpdate.setId(post.getId());
        postUpdate.setTitle("hibernate");
        Post updatedPost = repository.save(postUpdate); // merge

        assertThat(entityManager.contains(updatedPost)).isTrue();
        assertThat(entityManager.contains(postUpdate)).isFalse();
        assertThat(savedPost == post);

        // postUpdate.setTitle("jjeom"); postUpdate 는 merge가 발생했기 때문에 persist 상태가 아니다.
        updatedPost.setTitle("sunj");

        List<Post> all = repository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    public void test() {
        Post post = Post.builder().title("원글").contents("원글내용").build();
        Post comment = Post.builder().title("답글").contents("답글내용").build();

        comment.setParent(post);
        post.setChildren(Arrays.asList(comment));

        Post p = repository.findByTitle(post.getTitle());
    }

}
