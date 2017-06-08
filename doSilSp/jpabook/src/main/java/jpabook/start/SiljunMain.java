package jpabook.start;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mysema.query.jpa.impl.JPAQuery;

import jpabook.model.entity.Member;
import jpabook.model.entity.QMember;

public class SiljunMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			Member member1 = new Member("회원1");
			Member member2 = new Member("회원2");
			em.persist(member1);
			em.persist(member2);
			queryDSL(em);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}
		emf.close();
	}
	
	public static void queryDSL(EntityManager em) {
		JPAQuery query = new JPAQuery(em);
		QMember qMember = new QMember("m");
		List<Member> members = query.from(qMember).where(qMember.name.eq("회원1")).orderBy(qMember.name.desc()).list(qMember);
		for(Member member : members) {
			System.out.println(member.getName());
		}
	}

}
