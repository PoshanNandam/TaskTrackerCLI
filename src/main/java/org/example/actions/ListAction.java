package org.example.actions;

import org.example.model.Status;
import org.example.model.Task;
import org.example.storage.JSONFileStorage;

import java.util.List;
import java.util.stream.Collectors;

public class ListAction implements Action {

    JSONFileStorage jsonFileStorage;

    public ListAction(JSONFileStorage jsonFileStorage){
        this.jsonFileStorage = jsonFileStorage;
    }
    @Override
    public void perform(String[] input) {
        List<Task> taskList = jsonFileStorage.fetch();

        if(input.length > 2){
            switch (input[2]){
                case "done":{
                    taskList = taskList.stream()
                            .filter(task -> Status.DONE.equals(task.getStatus()))
                            .collect(Collectors.toList());
                    break;
                }
                case "todo":{
                    taskList = taskList.stream()
                            .filter(task -> Status.TODO.equals(task.getStatus()))
                            .collect(Collectors.toList());
                    break;
                }
                case "in-progress":{
                    taskList = taskList.stream()
                            .filter(task -> Status.IN_PROGRESS.equals(task.getStatus()))
                            .collect(Collectors.toList());
                    break;
                }
            }
        }

        for(Task task: taskList) System.out.println(task);
    }
}
