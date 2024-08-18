package org.example.actions;

import org.example.model.Task;
import org.example.storage.JSONFileStorage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeleteAction implements Action {

    JSONFileStorage jsonFileStorage;

    public DeleteAction(JSONFileStorage jsonFileStorage){
        this.jsonFileStorage = jsonFileStorage;
    }

    @Override
    public void perform(String[] input) {
        List<Task> taskList = jsonFileStorage.fetch();
        taskList = taskList.stream()
                .filter(task -> task.getId() != Integer.parseInt(input[1]))
                .collect(Collectors.toList());
        jsonFileStorage.save(taskList);

    }
}
