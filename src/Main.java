import tasks.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;

public class Main {

   private static ListOfTasks mapOfTasks = new ListOfTasks();
    private final static DateTimeFormatter DATE = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final static DateTimeFormatter TIME = DateTimeFormatter.ofPattern("hh:mm");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        mapOfTasks.addTasks(new OneTimeTask("Поход", "Собрать рюкзак" ,
                LocalDateTime.of(2022,12,12, 23,15),
                TaskTypeEnum.PERSONAL));
        mapOfTasks.addTasks(new DailyTask("Дзюдо", "Не забыть кимано и воду" ,
                LocalDateTime.of(2022,12,10, 16,45),
                TaskTypeEnum.PERSONAL));
        mapOfTasks.addTasks(new WeaklyTask("Ментальная арифметика", "абакус" ,
                LocalDateTime.of(2022,12,11, 15,25),
                TaskTypeEnum.PERSONAL));
        mapOfTasks.addTasks(new YearTask("Отпуск", "Купить путёвку" ,
                LocalDateTime.of(2022,12,31, 10,15),
                TaskTypeEnum.PERSONAL));
        doWork();
        tasksDay(scanner);
    }
    static void doWork(){
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сейчас в списке задач - " + mapOfTasks.getSizeTask());
        System.out.println("Что будем делать: \n 1. Добавить задачу \n 2. Удалить задачу \n 3. Получить задачу на указанный день \n 4.Выход \n ");
        while (isRunning){
            String taskType = scanner.nextLine();
            if (Objects.equals(taskType, "1")){
            addTask(scanner);
            System.out.println("Задача добавлена");
            isRunning = false;
        }
        if (Objects.equals(taskType, "2")){
            if (mapOfTasks.getSizeTask() > 0){
                System.out.println("В списке " + mapOfTasks.getSizeTask()+" задач.");
                remove(scanner);
            } else {
                System.out.println("В списке пусто. Нет задач для удаления");
            }
        }
            if (Objects.equals(taskType, "3")) {
                tasksDay(scanner);
            }
            if (Objects.equals(taskType, "4")){
                isRunning = false;
            }
        }

    }

    private static void addTask(Scanner scanner){
        String name = stringScanner("Введите название задачи", scanner);
        String description = stringScanner("Введите описание задачи", scanner);
        LocalDateTime taskDate = scannerDate(scanner);
        RepeatabilityTasks repeatabilityTasks = scannerRepeatability(scanner);
        TaskTypeEnum taskTypeEnum = scannerTaskTypeEnum(scanner);
        switch (repeatabilityTasks){
            case ONE_TIME:
                new OneTimeTask(name, description, taskDate, taskTypeEnum);
            case DAILY:
                new DailyTask(name, description, taskDate, taskTypeEnum);
            case WEAKLY:
                new WeaklyTask(name, description, taskDate, taskTypeEnum);
            case MONTHLY:
                new MonthlyTask(name, description, taskDate, taskTypeEnum);
            case YEAR:
                new YearTask(name, description, taskDate, taskTypeEnum);

        }
    }

    private static TaskTypeEnum scannerTaskTypeEnum(Scanner scanner) {
        while (true){
            try {
                System.out.println("Выберите тип задачи ");
                for (TaskTypeEnum taskTypeEnum : TaskTypeEnum.values()){
                    System.out.println(taskTypeEnum.ordinal());
                }
                System.out.print("Введите тип задачи ");
                String receiving = scanner.nextLine();
                int task = Integer.parseInt(receiving);
                return TaskTypeEnum.values()[task];
            } catch (NumberFormatException e){
                System.out.println("Введен неверный номер задачи");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Тип задачи не найден");
            }
        }
    }

    private static RepeatabilityTasks scannerRepeatability(Scanner scanner) {
        while (true){
            try {
                System.out.println("Выберите тип повторяемость задачи ");
                for (RepeatabilityTasks repeatabilityTasks : RepeatabilityTasks.values()){
                    System.out.println(repeatabilityTasks.ordinal());
                }
                System.out.print("Введите тип повторяемость задачи ");
                String receiving = scanner.nextLine();
                int task = Integer.parseInt(receiving);
               return RepeatabilityTasks.values()[task];
            } catch (NumberFormatException e){
                System.out.println("Введен неверный номер задачи");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Тип задачи не найден");
            }
        }
    }

    private static LocalDateTime scannerDate(Scanner scanner) {
        LocalDate localDate = introductionOfDate(scanner);
        LocalTime localTime = introductionOfTime(scanner);
        return localDate.atTime(localTime);
    }

    private static String stringScanner(String message, Scanner scanner) {
        while (true){
            System.out.println(message);
            String stringScanner = scanner.nextLine();
            if (stringScanner == null || stringScanner.isBlank()){
                System.out.println("Название задачи не может быть пустым!");
            }else {
                return stringScanner;
            }
        }
    }


    private static TaskTypeEnum taskTypeEnum(Scanner scanner){
        System.out.println("Выберите тип задачи: \n" +
                "1. Рабочая \n" +
                "2. Личная \n");
        while (true){
            System.out.print("Введите тип задачи: ");
            String taskType = scanner.nextLine();
            switch (taskType){
                case "1":
                    return TaskTypeEnum.WORK;
                case "2":
                    return TaskTypeEnum.PERSONAL;
                default:
                    System.out.println("Вы ввели неверный тип задачи, попробуте снова!");
            }
        }
    }


    private static void tasksDay (Scanner scanner) {
        LocalDate localDate = introductionOfDate(scanner);
        Collection<Task> taskCollection = mapOfTasks.getCurrnetTasks(localDate);
        System.out.println("Все задачи на " + localDate.format(DATE));
        for (Task task : taskCollection){
            System.out.println(task.getTaskTypeEnum()+" - тип задачи.\n "+
                    task.getName()+ " - название задачи. \n"+
                    task.getDescription() + " - описание задачи.\n"+
                    task.getLocalDateTime());
        }
    }

    private static LocalDate introductionOfDate(Scanner scanner) {
        while (true){
            try {
                System.out.print("Введите дату задачи(в формате dd.mm.yyyy): ");
                String dateTime = scanner.nextLine();
                return LocalDate.parse(dateTime, DATE);
            }
            catch (DateTimeParseException e){
                System.out.println("Введён неверный формат даты!");
            }
        }
    }

    private static LocalTime introductionOfTime(Scanner scanner) {
        while (true){
            try {
                System.out.print("Введите время задачи(в формате hh:mm): ");
                String dateTime = scanner.nextLine();
                return LocalTime.parse(dateTime, TIME);
            }
            catch (DateTimeParseException e){
                System.out.println("Введён неверный формат времени!");
            }
        }
    }

    private static void remove (Scanner scanner){
        for (Task task : mapOfTasks.getTask()){
            System.out.println(task.getName() + " " + task.getDescription() + " "
            + task.getId());
        }
        while (true){
            try {
                System.out.print("Выберите ID задачи для удаления: ");
                String iDLine = scanner.nextLine();
                int id = Integer.parseInt(iDLine);
                mapOfTasks.removeTask(id);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Неверный ID!");
            }

        }

    }

}