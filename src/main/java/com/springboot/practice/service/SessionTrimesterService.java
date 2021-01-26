package com.springboot.practice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.springboot.practice.entities.SessionTrimester;
import com.springboot.practice.entities.Trimester;
import com.springboot.practice.ripository.SessionTrimesterRepository;
import com.springboot.practice.ripository.TrimesterRepository;

@Service
public class SessionTrimesterService {
	private final SessionTrimesterRepository sessionRepo;
	private final TrimesterRepository tRepo;
	    public SessionTrimesterService(SessionTrimesterRepository sessionRepo,TrimesterRepository tRepo) {
	        this.sessionRepo = sessionRepo;
	        this.tRepo = tRepo;
	    }

	    public List<SessionTrimester> getAll(){
	        return sessionRepo.findAllByIsDeleteTrue();
	    }

	    public void save(SessionTrimester session){
	    	sessionRepo.save(session);
	    }
	    
	    public SessionTrimester getById(long Id) {
	        Optional<SessionTrimester> optionalSessionTrimester = sessionRepo.findById(Id);
	        if (optionalSessionTrimester.isEmpty()) {
	            throw new RuntimeException("Session Not Find By this Id");
	        } else {
	            return optionalSessionTrimester.get();
	        }
	    }
	    public Trimester getByTrimesterId(long Id) {
	        Optional<Trimester> optionalTrimester = tRepo.findById(Id);
	        if (optionalTrimester.isEmpty()) {
	            throw new RuntimeException("Trimester Not Find By this Id");
	        } else {
	            return optionalTrimester.get();
	        }
	    }
}
