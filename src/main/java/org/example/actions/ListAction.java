package org.example.actions;

import org.example.model.Status;
import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListAction implements IAction{

    @Override
    public void perform(String[] input, Map<Integer, Task> taskMap) {
        List<Task> taskList = new ArrayList<>(taskMap.values());

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

        System.out.println(taskList);
    }
}
