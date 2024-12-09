package perscholas.stevealexbowman.cap312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perscholas.stevealexbowman.cap312.model.Subscriber;
import perscholas.stevealexbowman.cap312.repository.SubscriberRepository;

import java.util.List;

@Service
public class SubscriberService {
    @Autowired
    private SubscriberRepository subscriberRepository;

    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }

    public void saveSubscriber(Subscriber subscriber) {
        subscriberRepository.save(subscriber);
    }
}
