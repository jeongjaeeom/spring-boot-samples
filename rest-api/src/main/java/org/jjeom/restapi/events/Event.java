package org.jjeom.restapi.events;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * @author eomjeongjae
 * @since 2019-04-01
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Setter
@EqualsAndHashCode(of = "id")
@Entity
public class Event {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location;
    private int basePrice;
    private int maxPrice;
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;
    private EventStatus eventStatus;

    public void setId(Integer id) {
        this.id = id;
    }
}
