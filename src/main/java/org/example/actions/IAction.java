package org.example.actions;

import org.example.model.Task;

import java.util.Map;

public interface IAction {

    void perform(String[] input, Map<Integer, Task> taskMap);
}
