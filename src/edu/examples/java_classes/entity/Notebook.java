package edu.examples.java_classes.entity;

import java.util.*;

public class Notebook {

    private List<Note> notes = new ArrayList<Note>();

    public Notebook() {
    }

    public Notebook(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }


    public Note getNotes(int index) {
        if (index < 0 || index >= notes.size()) {
            throw new RuntimeException("Wrong NoteBook index.");
        }

        return notes.get(index);
    }

    public void setNotes(Note note) {
        notes.add(note);
    }

    public void delete(Note note) {
        notes.remove(note);
    }

    public void sortNotesTittle() {
        Collections.sort(notes);
    }

    public void sortNoteContent() {
        Comparator<Note> noteComparator = new SortingNotes();
        notes.sort(noteComparator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Notebook other = (Notebook) obj;
        return Objects.equals(notes, other.notes);
    }

    @Override
    public String toString() {
        return "Notebook [notes=" + notes + "]";
    }

}
