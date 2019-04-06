package org.jjeom.restapi.accounts;

import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * @author eomjeongjae
 * @since 2019-04-06
 */
@Embeddable
public class Address {

    private String citiy;
    private String street;
    private String zipcode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(citiy, address.citiy) &&
                Objects.equals(street, address.street) &&
                Objects.equals(zipcode, address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(citiy, street, zipcode);
    }
}
