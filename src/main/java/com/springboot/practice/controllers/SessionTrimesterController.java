package com.springboot.practice.controllers;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.practice.dto.BatchDto;
import com.springboot.practice.dto.SessionTrimesterDto;
import com.springboot.practice.entities.Batch;
import com.springboot.practice.entities.SessionTrimester;
import com.springboot.practice.entities.Trimester;
import com.springboot.practice.request_models.BatchRm;
import com.springboot.practice.request_models.SessionTrimesterRm;
import com.springboot.practice.ripository.TrimesterRepository;
import com.springboot.practice.service.BatchService;
import com.springboot.practice.service.SessionTrimesterService;

@Controller
public class SessionTrimesterController {
	@Autowired
	private SessionTrimesterService sessionTrimesterService;
	
	@Autowired
	private TrimesterRepository tRepository;
	 
	@RequestMapping("/session_trimester/add")
	public String addsessionTrimester_GET(Model model) {
		model.addAttribute("session_trimester",new SessionTrimesterRm());
		List<Trimester> trimesters=tRepository.findAll();
		model.addAttribute("trimesters",trimesters);
		return "session_trimester/add";
	}
	@PostMapping("/session_trimester/add")
	public String addBatch_POST(Model model, @ModelAttribute("sessionTrimesterRm") SessionTrimesterRm sessionTrimesterRm) {
		LocalDateTime entry_date = LocalDateTime.now();
		var trimesterId = sessionTrimesterService.getByTrimesterId(sessionTrimesterRm.getTrimesterId());
		SessionTrimesterDto sessionTrimesterDto = new SessionTrimesterDto();
		SessionTrimester sessionTrimesterEntity = new SessionTrimester();
		sessionTrimesterDto.setName(sessionTrimesterRm.getName());
		sessionTrimesterDto.setCode(sessionTrimesterRm.getCode());
		sessionTrimesterDto.setAcademicYear(sessionTrimesterRm.getAcademicYear());
		sessionTrimesterDto.setTrimester(trimesterId);
		BeanUtils.copyProperties(sessionTrimesterDto, sessionTrimesterEntity);
		sessionTrimesterEntity.setEntryDate(entry_date);
		sessionTrimesterEntity.setIsDelete(true);
		sessionTrimesterService.save(sessionTrimesterEntity);
		return "redirect:/session_trimester/show-all";
	}

	@GetMapping("/session_trimester/show-all")
	public String show_all(Model model) {
		model.addAttribute("session_trimester", new SessionTrimesterRm());
		model.addAttribute("sessionList",sessionTrimesterService.getAll());
		model.addAttribute("message", "Showing All Session Trimester");  
		return "session_trimester/show-all";
	}
	
}
