package org.oop;

import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

public class Main {
    private static final GsonBuilder gsonBuilder;
    private static final Gson gson;

    static {
        gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Person.class, new PersonAdapter());
        gson = gsonBuilder.create();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Lad lad = gson.fromJson(new BufferedReader(new FileReader("resources/main/Lad.json")), Lad.class);
        Lass lass = gson.fromJson(new BufferedReader(new FileReader("resources/main/Lass.json")), Lass.class);
        Clique clique = gson.fromJson(new BufferedReader(new FileReader("resources/main/Clique.json")), Clique.class);


        System.out.println(clique.toString());
    }
}

class PersonAdapter implements JsonDeserializer<Person> {
    @Override
    public Person deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        var person = json.getAsJsonObject();
        var isFemale = person.get("female").getAsBoolean();
        var name = person.get("NAME").getAsString();

        if (isFemale)
            return new Lass(name);

        return new Lad(name);
    }
}

