package io.jjeom.commons.jpa;

import io.jjeom.accounts.Account;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Jeongjae Eom
 * @since 2018-12-21
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity<U> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    @ManyToOne
    private U createdBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedAt;

    @LastModifiedBy
    @ManyToOne
    private U lastModifiedBy;

}
