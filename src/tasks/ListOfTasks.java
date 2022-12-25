package tasks;
import java.time.LocalDate;
import java.util.*;
public class ListOfTasks {
   private final Map<Integer ,Task>  mapOfTasks = new HashMap<>();
    public void addTasks (Task task){
        this. mapOfTasks.put(task.getId(), task);
    }
    public void removeTask (int id){
        this. mapOfTasks.remove(id);
    }
    
    public int getSizeTask (){
        return  mapOfTasks.size();
    }

    public List<Task> getCurrnetTasks(LocalDate valueDate){
        List<Task> currentTasks = new ArrayList<>();
        for (Task task:  mapOfTasks.values()) {
            if (task.isCurrentTask(valueDate)) { currentTasks.add(task);}
        }
        return currentTasks;
    }

    public Collection<Task> getTask(){
        return this. mapOfTasks.values();
    }
}
