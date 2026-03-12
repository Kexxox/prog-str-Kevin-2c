package com.example.demo.Services;

import com.example.demo.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line == null || line.isBlank()) continue;

            String[] parts = line.split(",");
            String name = parts[0];
            String email = parts[1];
            String age = parts[2];
            result.add(name + "-" + email + "," + age);
        }
        return result;
    }

    public void addPerson(String name, String email, String age) throws IOException {
        validate(name, email, age);
        repo.addNewLine(name + "," + email + "," + age);
    }


    private void validate(String name, String email, String age){
        if(name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre es incorecto");
        }
        String em = (email==null) ? "" : email.trim();
        if (em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email es invalido");
        }

        int newNumber = Integer.parseInt(age);
        if (newNumber < 10){
            throw new IllegalArgumentException("La edad debe ser mayor a 18");
        }
        if (newNumber <0 ){
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }

    }
}

