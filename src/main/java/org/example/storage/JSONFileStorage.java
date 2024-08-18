package org.example.storage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Task;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class JSONFileStorage {
    Gson gson;

    public JSONFileStorage() {
        this.gson = new Gson();
    }

    public void save(List<Task> taskList){

        String jsonTaskList = gson.toJson(taskList);

        try {
            URL resource = JSONFileStorage.class.getResource("/tasks.json");
            FileWriter fileWriter = null;
            if (resource != null) {
                fileWriter = new FileWriter(resource.getPath(), false);
            }
            else {
                System.err.println("JSON Resource not found");
                return;
            }
            fileWriter.write(jsonTaskList);
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Saving to file failed try again");
        }
    }

    public List<Task> fetch() {
        List<Task> taskList = new ArrayList<>();
        try {
            URL resource = JSONFileStorage.class.getResource("/tasks.json");
            FileReader fileReader = null;
            if (resource != null) {
                fileReader = new FileReader(resource.getPath());
            }
            else {
                System.err.println("JSON Resource not found");
                return new ArrayList<>();
            }
            taskList = gson.fromJson(fileReader, new TypeToken<List<Task>>(){}.getType());
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Failed to read JSON File");
        }
        return taskList;
    }
}
