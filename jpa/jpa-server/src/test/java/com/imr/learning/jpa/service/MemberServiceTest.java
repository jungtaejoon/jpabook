package com.imr.learning.jpa.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imr.learning.jpa.domain.Member;
import com.imr.learning.jpa.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {
	
	@Autowired MemberService service;
	@Autowired MemberRepository repository;
	
	@Test
	public void shouldSave() {
		
		//given
		Member member = new Member();
		member.setName("kim");
		
		//when
		Long saveId = service.join(member);
		
		//then
		assertEquals(member, repository.findOne(saveId));
	}
	
	@Test
	public void shouldFindByName() {
		
		//given
		Member member = new Member();
		member.setName("kim");
		Long saveId = service.join(member);
		
		//when
		Member foundMember = service.findByName("kim");
		
		//then
		assertEquals(foundMember, repository.findOne(saveId));
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldCheckDuplicate() throws Exception {
		
		//given
		Member member = new Member();
		member.setName("kim");
		service.join(member);
		Member member2 = new Member();
		member2.setName("kim");
		
		//when
		service.join(member2);
		
		//then
		fail("예외가 발생해야 한다.");
		
	}

}
