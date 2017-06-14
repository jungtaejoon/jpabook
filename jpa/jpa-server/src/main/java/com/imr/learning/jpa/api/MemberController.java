package com.imr.learning.jpa.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imr.learning.jpa.domain.Member;
import com.imr.learning.jpa.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {
	
	@Autowired private MemberService service;

	@GetMapping
	public List<Member> findAll() {
		return service.findMembers();
	}
	
	@PostMapping
	public Long insertMember(@RequestBody Member member) {
		System.out.println("@@@@###");
		return service.join(member);
	}
}
