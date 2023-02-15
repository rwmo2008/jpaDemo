package jpademo.data;

import java.util.List;
import java.util.Optional;

import jpademo.model.NbaPlayer;

public interface Persistable<T, U> {
	public void create(NbaPlayer player);
	Optional<T> read (U u);
	public List<T> read();
	public void update (T t);
	public void delete (U u);
}
