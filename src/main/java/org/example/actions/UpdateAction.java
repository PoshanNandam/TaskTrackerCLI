package org.example.actions;

import org.example.model.Status;
import org.example.model.Task;
import org.example.storage.JSONFileStorage;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class UpdateAction implements Action {

    JSONFileStorage jsonFileStorage;

    public UpdateAction(JSONFileStorage jsonFileStorage){
        this.jsonFileStorage = jsonFileStorage;
    }

    @Override
    public void perform(String[] input) {
        List<Task> taskList = jsonFileStorage.fetch();
        try {
            Optional<Task> optionalTask = taskList.stream()
                    .filter(task -> task.getId() == Integer.parseInt(input[2]))
                    .findFirst();
            Task taskToUpdate = optionalTask.orElseThrow();

            switch (input[1]){
                case "update":{
                    StringBuilder sb = new StringBuilder();
                    for(int i=3;i<input.length;i++){
                        sb.append(input[i]).append(" ");
                    }
                    taskToUpdate.setDescription(sb.toString().replace("\"", "").trim());
                    break;
                }
                case "mark-in-progress":{
                    taskToUpdate.setStatus(Status.IN_PROGRESS);
                    break;
                }
                case "mark-done":{
                    taskToUpdate.setStatus(Status.DONE);
                    break;
                }
            }
        }
        catch (NoSuchElementException e){
            System.err.println("No task exist with this ID.");
        }
        jsonFileStorage.save(taskList);


    }
}
