package org.example.model;

import lombok.Data;

import java.util.Date;

@Data
public class Task {
    int id;
    String description;
    Status status;
    Date createdAt;
    Date updatedAt;

    public Task(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.status = Status.TODO;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
