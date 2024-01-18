package edu.examples.java_classes.dao.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;


public class FileNoteBookDao implements NoteBookDao {

    @Override
    public void save(Note n) throws DaoException {


        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("stub.txt"));

            List<Note> notes = new ArrayList<>();

            BufferedWriter writer = new BufferedWriter(new FileWriter("stub.txt"));

            String line;
            int id = 0;
            while ((line = reader.readLine()) != null) {
                id++;
            }

            n.setId(id);

            if (n.getD() == null) {
                    n.setD(new Date());
            }

            notes.add(n);

            writer.write(notes.toString());
            writer.close();
        } catch (IOException e) {
            throw new DaoException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    throw new DaoException(e1);
                }
            }
        }
    }

    /*@Override
    public void delete(String id) throws DaoException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("stub.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(id)) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            throw new DaoException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("stub.txt"))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void clear() throws DaoException {
        try (BufferedReader reader = new BufferedReader(new FileReader("stub.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = null;
            }
        } catch (IOException e) {
            throw new DaoException(e);
        }
    }*/


    @Override
    public List<Note> allNotes() throws DaoException {
        return null;
    }

}
