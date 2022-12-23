package tasks;
import java.time.LocalDate;
import java.util.*;

public class ListOfTasks {
   private final Map<Integer ,Task> MAP_OF_TASKS = new HashMap<>();
    public void addTasks (Task task){
        this.MAP_OF_TASKS.put(task.getId(), task);
    }
    public void removeTask (int id){
        this.MAP_OF_TASKS.remove(id);
    }
    
    public int getSizeTask (){
        return MAP_OF_TASKS.size();
    }

    public List<Task> getCurrnetTasks(LocalDate valueDate){
        List<Task> currentTasks = new ArrayList<>();
        for (Task task: MAP_OF_TASKS.values()) {
            if (task.isCurrentTask(valueDate)) { currentTasks.add(task);}
        }
        return currentTasks;
    }

    public Collection<Task> getTask(){
        return this.MAP_OF_TASKS.values();
    }
}
