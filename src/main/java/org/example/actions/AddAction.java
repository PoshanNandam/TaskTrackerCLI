package org.example.actions;

import org.example.model.Task;
import org.example.storage.JSONFileStorage;
import org.example.util.AutoIncrementIdGenerator;

import java.util.List;

public class AddAction implements Action {

    JSONFileStorage jsonFileStorage;

    public AddAction(JSONFileStorage jsonFileStorage){
        this.jsonFileStorage = jsonFileStorage;
    }

    @Override
    public void perform(String[] input) {
        List<Task> taskList = jsonFileStorage.fetch();

        Task task = new Task();
        task.setId(AutoIncrementIdGenerator.generateId());
        StringBuilder sb = new StringBuilder();
        for(int i=2;i<input.length;i++){
            sb.append(input[i]).append(" ");
        }
        task.setDescription(sb.toString().replace("\"", "").trim());

        taskList.add(task);
        jsonFileStorage.save(taskList);
    }
}
