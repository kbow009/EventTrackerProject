package com.skilldistillery.wellnesstracker.entities.Wellness;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.bytebuddy.matcher.ElementMatcher;

class WellnessTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Wellness wellness;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAWellness");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		wellness = em.find(Wellness.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		
		em.close();
		wellness = null;
	}

	@Test
	void test() {
		assertNotNull(wellness);
		assertEquals("Meditation", wellness.getActivity());
	}

}
