package io.jjeom.accounts;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author Jeongjae Eom
 * @since 2018-12-20
 */
@Getter
@Setter
@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    @CreationTimestamp
    private LocalDateTime createdTimeAt;

    @UpdateTimestamp
    private LocalDateTime updateTimeAt;
}
