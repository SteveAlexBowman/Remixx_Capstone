package perscholas.stevealexbowman.cap312.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import perscholas.stevealexbowman.cap312.model.Pledge;
import perscholas.stevealexbowman.cap312.repository.PledgeRepository;

import java.util.List;

@Service
public class PledgeService {

    @Autowired
    private PledgeRepository pledgeRepository;

    public List<Pledge> getAllPledges() {
        return pledgeRepository.findAll();
    }

    public Pledge savePledge(Pledge pledge) {
        return pledgeRepository.save(pledge);
    }
}
