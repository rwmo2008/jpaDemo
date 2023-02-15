package jpademo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="nba_players_jpa")
@NamedQuery(name="findAllNbaPlayers", query = "SELECT p from NbaPlayer p")
public class NbaPlayer {
	@Id
	@SequenceGenerator(name="seq_player_id", sequenceName="nba_players_id_seq_jpa",
    initialValue=1001, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_playe_id")
	private int playerId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="career_points")
	private int careerPoints;
	public NbaPlayer(String firstName, String lastName, int careerPoints) {
		super();
		this.playerId = playerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.careerPoints = careerPoints;
	}
	public NbaPlayer() {
	}
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "NBAPlayer [playerId=" + playerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", careerPoints=" + careerPoints + "]";
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getCareerPoints() {
		return careerPoints;
	}

	public void setCareerPoints(int careerPoints) {
		this.careerPoints = careerPoints;
	}
}
