package org.jjeom.restapi.events;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author eomjeongjae
 * @since 2019-04-11
 */
public interface EventRepository extends JpaRepository<Event, Integer> {
}
