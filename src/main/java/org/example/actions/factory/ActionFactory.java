package org.example.actions.factory;

import org.example.actions.*;
import org.example.storage.JSONFileStorage;

public class ActionFactory {

    public ActionFactory(){

    }
    JSONFileStorage jsonFileStorage = new JSONFileStorage();

    public Action getInstance(String inputAction){
        switch (inputAction){
            case "add": {
                return new AddAction(jsonFileStorage);
            }
            case "update":
            case "mark-in-progress":
            case "mark-done": {
                return new UpdateAction(jsonFileStorage);
            }
            case "delete": {
                return new DeleteAction(jsonFileStorage);
            }
            case "list": {
                return new ListAction(jsonFileStorage);
            }
            default: {
                System.err.println("Invalid action input");
                break;
            }
        }
        return new NullAction();
    }
}
