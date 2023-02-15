package jpademo.data;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import jpademo.model.NbaPlayer;

public class NbaPlayerJpaDemo implements Persistable<NbaPlayer, Integer> {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaNbaPlayer");

	public NbaPlayerJpaDemo(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void create(NbaPlayer player) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.persist(player);
			et.commit();
		} finally {
			if (em != null && em.isOpen())
				em.close();
		}

	}

	public Optional<NbaPlayer> read(Integer playerId) {
		EntityManager em = null;
		NbaPlayer retrievedPlayer = null;
		try {
			em = emf.createEntityManager();
			retrievedPlayer = em.find(NbaPlayer.class, playerId);
		} finally {
			if (em != null && em.isOpen())
				em.close();
		}
		return Optional.ofNullable(retrievedPlayer);
	}

	public List<NbaPlayer> read() {
		EntityManager em = null;
		List<NbaPlayer> players = null;
		try {
			em = emf.createEntityManager();
			//TypedQuery<NbaPlayer> query = em.createQuery("SELECT p from NbaPlayer p", NbaPlayer.class);
			TypedQuery<NbaPlayer> query = em.createQuery("findAllNbaPlayers", NbaPlayer.class);
			players = query.getResultList();
		} finally {
			if (em != null && em.isOpen())
				em.close();
		}
		return players;
	}

	public void update(NbaPlayer player) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(player);
			em.getTransaction().commit();
		} finally {
			if (em != null && em.isOpen())
				em.close();
		}
	}

	public void delete(NbaPlayer player) {

	}

	public void delete(Integer playerId) {
		EntityManager em = null;
		try {
			em = emf.createEntityManager();
			NbaPlayer managedPlayer = em.find(NbaPlayer.class, playerId);
			em.getTransaction();
			em.remove(managedPlayer);
			((EntityTransaction) em).commit();
		} finally {
			if (em != null && em.isOpen())
				em.close();
		}
	}

}
