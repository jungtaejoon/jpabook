package com.imr.learning.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imr.learning.jpa.domain.Member;
import com.imr.learning.jpa.repository.MemberRepository;

@Service
@Transactional
public class MemberService {

	@Autowired MemberRepository repository;
	
	public Long join(Member member) {
		validateDuplicateMember(member);
		repository.save(member);
		return member.getId();
	}
	
	private void validateDuplicateMember(Member member) {
		Member foundMember = repository.findByName(member.getName());
		if(foundMember != null) throw new IllegalStateException("이미 존재하는 회원입니다.");
	}
	
	public List<Member> findMembers() {
		return repository.findAll();
	}
	
	public Member findOne(Long id) {
		return repository.findOne(id);
	}
	
	public Member findByName(String name) {
		return repository.findByName(name);
	}
	
}
