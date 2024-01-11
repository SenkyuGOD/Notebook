package edu.examples.java_classes.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.entity.Notebook;

public class NotebookLogic {

    private final NoteBookDao dao = new NoteBookDao();

    public void add(Note n) {
        //NoteBookDao dao = new NoteBookDao();

        dao.save(n);
    }

    public void add(String title, String content) {
        //NoteBookDao dao = new NoteBookDao();
        Note n = new Note(title, content);

        dao.save(n);
    }

    public void remove(Note n) {
        dao.delete(n);
    }

    public void sortByTitle() {
        dao.sortTitle();
    }

    public void sortByContent() {
		dao.sortContent();
    }

    public List<Note> findByString(String text) {
        List<Note> result = new ArrayList<Note>();

        //NoteBookDao dao = new NoteBookDao();
        List<Note> myNotes = dao.allNotes();

        for (Note n : myNotes) {
            if (isTextInNote(n, text)) {
                result.add(n);
            }
        }
		
		/*for(int i=0; i<myNotes.size(); i++) {
			Note n = myNotes.get(i);
		}*/
        return result;

    }

    private boolean isTextInNote(Note n, String text) {
        return n.getTitle().contains(text) || n.getContent().contains(text);
    }


    public List<Note> findByDate(Date date) {
        List<Note> result = new ArrayList<Note>();

        //NoteBookDao dao = new NoteBookDao();
        List<Note> myNotes = dao.allNotes();

        // ...d1.equals(d2);

        for (int i = 0; i < myNotes.size(); i++) {
            if (myNotes.get(i).getD().equals(date)) {
                result.add(myNotes.get(i));
            }
        }

        return result;

    }

    public List<Note> sortByDate() {

        List<Note> myNotes = dao.allNotes();

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < myNotes.size() - 1; i++) {
                if (myNotes.get(i).getD().compareTo(myNotes.get(i + 1).getD()) > 0) {
                    isSorted = false;

                    Note temp = myNotes.get(i);
                    myNotes.set(i, myNotes.get(i + 1));
                    myNotes.set(i + 1, temp);
                }
            }
        }

        List<Note> result = new ArrayList<Note>(myNotes);

        return result;
    }


    public List<Note> allNotes() {
        return dao.allNotes();
    }

}
