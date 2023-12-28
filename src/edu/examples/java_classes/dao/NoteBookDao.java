package edu.examples.java_classes.dao;

import java.util.List;

import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.entity.Notebook;
import edu.examples.java_classes.source.NoteBookProvider;

public class NoteBookDao {

	public void create() {
		NoteBookProvider.getInstance();
	}

	private final NoteBookProvider provider = NoteBookProvider.getInstance();
	private final Notebook nb = provider.getNotebook();

	public void save(Note n) {
		nb.setNotes(n);
	}

	public List<Note> allNotes() {
		return nb.getNotes();
	}

}
