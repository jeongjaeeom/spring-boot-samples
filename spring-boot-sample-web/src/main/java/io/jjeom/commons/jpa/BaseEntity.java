package io.jjeom.commons.jpa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author Jeongjae Eom
 * @since 2018-12-21
 */
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @CreationTimestamp
    protected LocalDateTime createdTimeAt;

    @UpdateTimestamp
    protected LocalDateTime updateTimeAt;
}
