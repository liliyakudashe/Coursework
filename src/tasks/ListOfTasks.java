package tasks;

import tasks.Task;

import java.util.ArrayList;

public class ListOfTasks {
    ArrayList<Task> listOfTask = new ArrayList<>();
    public void addTasks (Task task){
        listOfTask.add(task);
    }
    public void removeTask (int id){
        listOfTask.remove(id);
    }
    
    public int getSizeTask (){
        return listOfTask.size();
    }
    public String getTaskInfoById(int id){
        Task task = listOfTask.get(id);
        return Task.getTaskInfo();
    }
}
