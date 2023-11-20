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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!projectName.equals(task.projectName)) return false;
        return description.equals(task.description);
    }

    @Override
    public int hashCode() {
        int result = projectName.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "%-20s %-25s %-10s %-10s %s".formatted(projectName, description,priority,assignee,status);
    }
}
