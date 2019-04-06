package org.jjeom.restapi.accounts;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Embedded
    private Address address;

    @Builder.Default
    @ElementCollection
    private Set<String> favoriteFoods = Sets.newHashSet();

    @Builder.Default
    @ElementCollection
    private List<Address> addressHistory = Lists.newArrayList();

    @Builder.Default
    @ElementCollection
    private Map<String, String> attributes = Maps.newHashMap();

    @Builder.Default
    @ElementCollection
    @MapKeyColumn(name = "book_key")
    private Map<String, Book> books = Maps.newHashMap();

    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapKey(name = "type")
    private Map<String, Phone> phones = Maps.newHashMap();

    @Builder.Default
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Phone> phones2 = Lists.newArrayList();



}
