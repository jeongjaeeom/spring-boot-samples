package org.jjeom.restapi.accounts;

import lombok.*;

import javax.persistence.*;

/**
 * @author eomjeongjae
 * @since 2019-04-06
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String number;
}
