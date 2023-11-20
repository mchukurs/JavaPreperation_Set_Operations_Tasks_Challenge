package com.chukurs;

public record Task(String assignee, String projectName, String description, Status status, Priority priority)
        implements Comparable<Task>{

    @Override
    public int compareTo(Task o) {
        if(this.projectName.compareTo(o.projectName)!=0){
            return this.projectName.compareTo(o.projectName);

        }
        return this.description.compareTo(o.description);
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %s".formatted(projectName, description,priority,assignee,status);
    }
}
