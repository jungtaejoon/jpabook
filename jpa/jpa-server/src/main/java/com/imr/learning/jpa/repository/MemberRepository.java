package com.imr.learning.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imr.learning.jpa.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	public Member findByName(String name);

}
