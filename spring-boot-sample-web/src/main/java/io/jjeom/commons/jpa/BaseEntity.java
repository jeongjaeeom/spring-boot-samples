package io.jjeom.commons.jpa;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author Jeongjae Eom
 * @since 2018-12-21
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue
    protected Long id;

    @CreationTimestamp
    protected LocalDateTime createdTimeAt;

    @UpdateTimestamp
    protected LocalDateTime updateTimeAt;
}
