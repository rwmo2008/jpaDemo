package jpademo.presentation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpademo.data.NbaPlayerJpaDemo;
import jpademo.model.NbaPlayer;

public class Runner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaNbaPlayer");
		NbaPlayerJpaDemo demo = new NbaPlayerJpaDemo(emf);

		NbaPlayer curlyNeal = new NbaPlayer();
		curlyNeal.setFirstName("Curly");
		curlyNeal.setLastName("Neal");
		curlyNeal.setCareerPoints(22);

		demo.create(curlyNeal);
		demo.delete(curlyNeal.getPlayerId());

		NbaPlayer michaelJordan = new NbaPlayer("Michael", "Jordan", 32_292);
		demo.create(michaelJordan);

		NbaPlayer lebronJames = new NbaPlayer("Lebron", "James", 35_367);
		demo.create(lebronJames);

		NbaPlayer kobeBryant = new NbaPlayer("Kobe", "Bryant", 33_643);
		demo.create(kobeBryant);

		NbaPlayer karlMalone = new NbaPlayer("Karl", "Malone", 36_928);
		demo.create(karlMalone);

		NbaPlayer lewisAlcindor = new NbaPlayer("Lewis", "Alcindor", 0);
		demo.create(lewisAlcindor);

		lewisAlcindor.setFirstName("Kareem");
		lewisAlcindor.setLastName("Abdul-Jabbar");
		lewisAlcindor.setCareerPoints(38_786);
		demo.update(lewisAlcindor);

		Optional<NbaPlayer> optKareem = demo.read(lewisAlcindor.getPlayerId());
		if (optKareem.isPresent()) {
			System.out.println("lewisAlcindor object from the database: " + optKareem.get());
		}

		List<NbaPlayer> retrievedPlayers = demo.read();
		retrievedPlayers.forEach(player -> System.out.println(player));

		if (emf != null && emf.isOpen()) {
			emf.close();
		}
	}

}
