package com.springboot.practice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.springboot.practice.entities.Batch;
import com.springboot.practice.entities.SessionTrimester;
import com.springboot.practice.ripository.BatchRepository;
import com.springboot.practice.ripository.SessionTrimesterRepository;

@Service
public class BatchService {
	private final BatchRepository batchRepo;
	private final SessionTrimesterRepository tRepo;
	    public BatchService(BatchRepository batchRepo,SessionTrimesterRepository tRepo) {
	        this.batchRepo = batchRepo;
	        this.tRepo = tRepo;
	    }

	    public List<Batch> getAll(){
	        return batchRepo.findAll();
	    }

	    public void save(Batch batch){
	    	batchRepo.save(batch);
	    }
	    
	    public Batch getById(long Id) {
	        Optional<Batch> optionalBatch = batchRepo.findById(Id);
	        if (optionalBatch.isEmpty()) {
	            throw new RuntimeException("Student Not Find By this Id");
	        } else {
	            return optionalBatch.get();
	        }
	    }
	    public SessionTrimester getByTrimesterId(long Id) {
	        Optional<SessionTrimester> optionalTrimester = tRepo.findById(Id);
	        if (optionalTrimester.isEmpty()) {
	            throw new RuntimeException("Trimester Not Find By this Id");
	        } else {
	            return optionalTrimester.get();
	        }
	    }
}
