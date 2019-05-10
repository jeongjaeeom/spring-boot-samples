package org.jjeom.restapi.events;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @author eomjeongjae
 * @since 2019-04-01
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventDto {

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    @NotNull
    private LocalDateTime beginEnrollmentDateTime;

    @NotNull
    private LocalDateTime closeEnrollmentDateTime;

    @NotNull
    private LocalDateTime beginEventDateTime;

    @NotNull
    private LocalDateTime endEventDateTime;

    private String location;

    @Min(0)
    private int basePrice;

    @Min(0)
    private int maxPrice;

    private int limitOfEnrollment;

}
