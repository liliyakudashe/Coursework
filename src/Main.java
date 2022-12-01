import tasks.ListOfTasks;
import tasks.PersonalOrWork;
import tasks.Task;
import tasks.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void main(String[] args) {

        doWork();
    }
    static void doWork(){
        User pers = new User("Елизавета");
        ListOfTasks listOfTasks = new ListOfTasks();
        int what;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Сейчас в списке задач - " + listOfTasks.getSizeTask());
            System.out.println("Что будем делать: \n 1. Добавить задачу \n 2. Удалить задачу \n 3. Получить задачу на указанный день \n 4.Выход ");

        what = whatDo(pers);
        if (what == 1){
            personalOrWork(scanner);
            introductionOfDateAndTime(scanner);
            addTaskList(pers,listOfTasks);
        }
        if (what == 2){
            if (listOfTasks.getSizeTask() > 0){
                removeTask(pers, listOfTasks);
                System.out.println("В списке " + listOfTasks.getSizeTask()+" задач.");
            } else {
                System.out.println("В списке пусто. Нет задач для удаления");
            }

        }
    }
    static int whatDo(User pers) {
        int d;
        do {
            d = pers.getAnswer();
            if (d != 1 & d != 2 & d != 3 & d != 4 ) {
                System.out.println("Укажите что нужно сделать: \n 1. Добавить задачу \n 2. Удалить задачу \n 3. Получить задачу на указанный день \n 4.Выход");
            }
        } while(d != 1 & d != 2 & d != 3 & d != 4);
        return d;
    }
    public static LocalDateTime introductionOfDateAndTime(Scanner scanner) {
        while (true){
            try {
                System.out.println("Введите дату и время задачи(в формате dd.mm.yyyy hh:mm): ");
                String dateTime = scanner.nextLine();
                return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
            }
            catch (DateTimeParseException e){
                System.out.println("Введён неверный формат даты и времени!");
            }
        }
    }

    public static PersonalOrWork personalOrWork(Scanner scanner){
        System.out.println("Выберите тип задачи: \n" +
                "1. Рабочая \n" +
                "2. Личная \n");
        while (true){
            System.out.println("Введите тип задачи: ");
            String taskType = scanner.nextLine();
            switch (taskType){
                case "1":
                    return PersonalOrWork.WORK;
                case "2":
                    return PersonalOrWork.PERSONAL;
                default:
                    System.out.println("Вы ввели неверный тип задачи, попробуте снова!");
            }
        }
    }

    static void removeTask(User pers, ListOfTasks listOfTasks) {
        int numTask;
        System.out.println("В списке задач - " + listOfTasks.getSizeTask());
        System.out.println("Укажите id удаляемой задачи");
        do {
            numTask = pers.getAnswer();
        } while(numTask < 1 || numTask > listOfTasks.getSizeTask());
        --numTask;
        System.out.println("Вы уверены что хотите удалить задачу: " + listOfTasks.getTaskInfoById(numTask) + "?");
        System.out.println("0-нет; 1-да");
        int ans;
        do {
            ans = pers.getAnswer();
        } while (ans != 0 & ans != 1);
        if (ans == 1) {
            listOfTasks.removeTask(numTask);
        }
    }

    static void addTaskList (User pers, ListOfTasks listOfTasks) {
       // listOfTasks.addTasks(new Task());
        System.out.println("Задача добавлена в список");
    }




}