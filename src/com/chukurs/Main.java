package com.chukurs;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Task> tasks = TaskData.getTasks("all");
        sortAndPrint("Bosses tasks ",tasks);

        Comparator<Task> sortByPriority = Comparator.comparing((Task t) -> t.priority());
        Set<Task> annsTasks = TaskData.getTasks("ann");
        // sortAndPrint("Anns tasks",annsTasks,sortByPriority);

        Set<Task> bobTasks = TaskData.getTasks("bob");
        Set<Task> carolTasks = TaskData.getTasks("carol");

        Set<Task> assignedSets = getUnion(List.of(annsTasks,bobTasks,carolTasks));

        sortAndPrint("All assigned tasks ", assignedSets);
        Set<Task> everyTask = getUnion(List.of(assignedSets,tasks));
        sortAndPrint("All tasks ",everyTask);

        Set<Task> missingTasks = getDifference(everyTask,tasks);
        sortAndPrint("Missing tasks ", missingTasks);

        Set<Task> unassignedTasks = getDifference(everyTask,assignedSets);
        sortAndPrint("Unassigned tasks ", unassignedTasks,sortByPriority);



    }

    public static Set<Task> getUnion(List<Set<Task>> listOfSets) {
        Set<Task> unionSet = new HashSet<>();
        for (Set e : listOfSets) {
            unionSet.addAll(e);
        }
        return unionSet;
    }

    public static Set<Task> getIntersection(Set<Task> firstSet, Set<Task> secondSet) {
        Set<Task> intersectionSet = new HashSet<>(firstSet);
        intersectionSet.retainAll(secondSet);

        return intersectionSet;
    }

    public static Set<Task> getDifference(Set<Task> firstSet, Set<Task> secondSet) {
        Set<Task> differenceSet = new HashSet<>(firstSet);
        differenceSet.removeAll(secondSet);
        return differenceSet;
    }


    private static void sortAndPrint(String header, Collection<Task> collection) {
        sortAndPrint(header, collection, null);
    }

    private static void sortAndPrint(String header, Collection<Task> collection, Comparator<Task> sorter) {

        String lineSeparator = "_".repeat(90);
        System.out.println(lineSeparator);
        System.out.println(header);
        System.out.println(lineSeparator);

        List<Task> list = new ArrayList<>(collection);
        list.sort(sorter);
        list.forEach(System.out::println);


    }
}
