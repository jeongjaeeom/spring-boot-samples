package io.jjeom.posts.entity;

import io.jjeom.commons.jpa.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;

/**
 * @author eomjeongjae
 * @since 2019-01-25
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post extends BaseEntity {

    private String title;

    private String contents;

    @ManyToOne
    private Post parent;

    @OneToMany(mappedBy = "parent")
    private Collection<Post> children;
}
