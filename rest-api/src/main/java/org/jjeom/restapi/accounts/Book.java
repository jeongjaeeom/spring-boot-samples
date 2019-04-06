package org.jjeom.restapi.accounts;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

/**
 * @author eomjeongjae
 * @since 2019-04-06
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class Book {

    private String title;

    private String author;
}