package org.example;

import org.example.actions.*;
import org.example.model.Task;
import org.example.storage.JSONFileStorage;

import java.util.HashMap;
import java.util.Scanner;

public class TaskTrackerCLI {

    public static void main(String[] args) {
        System.out.println("TaskTrackerCLI started!!");
        JSONFileStorage jsonFileStorage = new JSONFileStorage();
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Task> taskHashMap = new HashMap<>();
        while(true) {
            String command = sc.nextLine();
            if("exit".equals(command)) break;
            if(command.isEmpty()) continue;

            String[] input = command.split(" (?=(?:[^']*'[^']*')*[^']*$)");


            String inputAction = input[1];
            IAction action = null;

            switch (inputAction){
                case "add": {
                    action = new AddAction(jsonFileStorage);
                    break;
                }
                case "update":
                case "mark-in-progress":
                case "mark-done": {
                    action = new UpdateAction(jsonFileStorage);
                    break;
                }
                case "delete": {
                    action = new DeleteAction(jsonFileStorage);
                    break;
                }
                case "list": {
                    action = new ListAction();
                    break;
                }
                default: {
                    System.err.println("Invalid action input");
                    break;
                }
            }

            if(action!=null) action.perform(input, taskHashMap);
        }
    }
}