package org.example.actions;

import org.example.model.Task;
import org.example.storage.JSONFileStorage;

import java.util.Map;

public class DeleteAction implements IAction{

    JSONFileStorage jsonFileStorage;

    public DeleteAction(JSONFileStorage jsonFileStorage){
        this.jsonFileStorage = jsonFileStorage;
    }

    @Override
    public void perform(String[] input, Map<Integer, Task> taskMap) {
        taskMap.remove(Integer.parseInt(input[1]));
        jsonFileStorage.save(taskMap);

    }
}
