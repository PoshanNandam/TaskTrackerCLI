package org.example;

import org.example.actions.Action;
import org.example.actions.factory.ActionFactory;

import java.util.Scanner;

public class TaskTrackerCLI {

    public static void main(String[] args) {
        System.out.println("TaskTrackerCLI started!!");

        Scanner sc = new Scanner(System.in);
        while(true) {
            String command = sc.nextLine();
            if("exit".equals(command)) break;
            if(command.isEmpty()) continue;

            String[] input = command.split(" ");


            String inputAction = input[1];
            Action action = new ActionFactory().getInstance(inputAction);

            action.perform(input);
        }
    }
}