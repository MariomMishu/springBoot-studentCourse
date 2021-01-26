package com.springboot.practice.controllers;

import org.springframework.http.MediaType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springboot.practice.dto.BatchDto;
import com.springboot.practice.entities.Batch;
import com.springboot.practice.entities.SessionTrimester;
import com.springboot.practice.request_models.BatchRm;
import com.springboot.practice.ripository.SessionTrimesterRepository;
import com.springboot.practice.service.BatchService;

@Controller
public class BatchController {
	@Autowired
	private BatchService batchService;
	
	@Autowired
	private SessionTrimesterRepository tRepository;
	 
	@GetMapping("/batch")
    public String manageBatch (Model model) {
        model.addAttribute("title", "Manage Batch");
        model.addAttribute("batch",new BatchRm());
		List<SessionTrimester> trimesters=tRepository.findAllByIsDeleteTrue();
		model.addAttribute("trimesters",trimesters);
		model.addAttribute("batchList",batchService.getAll());
        return "/batch/manage-batch";
    }
	 @GetMapping(value = "/getAllOnPageLoad", consumes = "application/json", produces = "application/json")
	    public @ResponseBody List<BatchRm> getAll_onLoad() {
	        List<Batch> batchList = batchService.getAll();
	        return this.getDtoRmList(batchList);
	    }
	   private List<BatchRm> getDtoRmList(List<Batch> batchList) {
	        List<BatchRm> rmList = new ArrayList<>();
	        for (Batch batch : batchList) {
	        	BatchRm batchRm = new BatchRm();
	        	BatchDto batchDto = new BatchDto();
	            BeanUtils.copyProperties(batch, batchDto);
	            batchRm.setId(batchDto.getId());
	            batchRm.setName(batchDto.getName());
	            batchRm.setTrimesterId(batchDto.getTrimester().getId());
	            batchRm.setTrimesterName(batchDto.getTrimester().getName());
	            rmList.add(batchRm);
	        }
	        return rmList;
	    }
	@RequestMapping("/batch/add")
	public String addBatch_GET(Model model) {
		model.addAttribute("batch",new BatchRm());
		List<SessionTrimester> trimesters=tRepository.findAllByIsDeleteTrue();
		model.addAttribute("trimesters",trimesters);
		return "batch/add";
	}
	@PostMapping("/batch/add")
	public String addBatch_POST(Model model, @ModelAttribute("batchRm") BatchRm batchRm) {
		LocalDateTime entry_date = LocalDateTime.now();
		var trimesterId = batchService.getByTrimesterId(batchRm.getTrimesterId());
	//	System.out.println(deptId);
		BatchDto batchDto = new BatchDto();
		Batch batchEntity = new Batch();
		batchDto.setName(batchRm.getName());
		batchDto.setTrimester(trimesterId);
		BeanUtils.copyProperties(batchDto, batchEntity);
		batchEntity.setEntryDate(entry_date);
		batchEntity.setIsDelete(true);
		batchService.save(batchEntity);
		return "redirect:/batch/show-all";
	}
	  @PostMapping(value = "/batch/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody BatchRm saveStudent(@RequestBody BatchRm batchRm) {
		  LocalDateTime entry_date = LocalDateTime.now();
		  var trimesterId = batchService.getByTrimesterId(batchRm.getTrimesterId());
		  BatchDto batchDto = new BatchDto();
			Batch batchEntity = new Batch();
			batchDto.setName(batchRm.getName());
			batchDto.setTrimester(trimesterId);
			BeanUtils.copyProperties(batchDto, batchEntity);
			batchEntity.setEntryDate(entry_date);
			batchEntity.setIsDelete(true);
			batchService.save(batchEntity);
			batchEntity = batchService.getById(batchEntity.getId());
	        BeanUtils.copyProperties(batchEntity, batchDto);
	        batchRm.setId(batchDto.getId());
	        batchRm.setName(batchDto.getName());
	        batchRm.setTrimesterId(batchDto.getTrimester().getId());
	        batchRm.setTrimesterName(batchDto.getTrimester().getName());
	        return batchRm;
	    }

	@GetMapping("/batch/show-all")
	public String show_all(Model model) {
		model.addAttribute("batch", new BatchRm());
		model.addAttribute("batchList",batchService.getAll());
		model.addAttribute("message", "Showing All Batch");  
		return "batch/show-all";
	}
	
}
