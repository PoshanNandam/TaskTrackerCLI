package org.example.storage;

import com.google.gson.Gson;
import org.example.model.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONFileStorage {
    Gson gson;

    public JSONFileStorage() {
        this.gson = new Gson();
    }

    public void save(Map<Integer, Task> taskMap){
        List<Task> taskList = new ArrayList<>(taskMap.values());

        String jsonTaskList = gson.toJson(taskList);

        try {
            File file = new File("C:\\Users\\poshan_nandam\\Documents\\TaskTrackerCLIJava\\src\\main\\java\\org\\example\\resources\\tasks.json");
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(jsonTaskList);
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Saving to file failed try again");
        }
    }

}
