package perscholas.stevealexbowman.cap312.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import perscholas.stevealexbowman.cap312.model.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long> {
}
