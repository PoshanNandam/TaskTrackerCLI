package org.example.actions;

import org.example.model.Status;
import org.example.model.Task;
import org.example.storage.JSONFileStorage;

import java.util.Map;

public class UpdateAction implements IAction{

    JSONFileStorage jsonFileStorage;

    public UpdateAction(JSONFileStorage jsonFileStorage){
        this.jsonFileStorage = jsonFileStorage;
    }

    @Override
    public void perform(String[] input, Map<Integer, Task> taskMap) {
        Task taskToUpdate = taskMap.get(Integer.parseInt(input[2]));
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
        jsonFileStorage.save(taskMap);

    }
}
