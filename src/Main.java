import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Пришло время практики!");
        Scanner scanner = new Scanner(System.in);
        StepTracker results = new StepTracker ();
        Converter convert = new Converter();
        int targetNumberSteps = 10000;
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                results.enterSteps();
            } else if (userInput == 2) {
                System.out.println ("Введите номер месяца, за который вы хотите получить статистику -");
                int statMonth = scanner.nextInt()-1;
                System.out.println ("Количество пройденных шагов в выбранном месяце по дням - ");
                results.printStatMonth(statMonth);
                System.out.println();
                System.out.println ("Общее количество шагов за месяц - " + results.findSumSteps(statMonth));
                System.out.println ("Максимальное пройденное количество шагов в месяце - " + results.findMaxSteps(statMonth));
                System.out.println ("Среднее количество шагов в день - " + results.findSumSteps(statMonth)/30);
                int m = results.findSumSteps(statMonth);
                System.out.println ("Пройденная дистанция в километрах - " + convert.convertSteps(m));
                System.out.println ("Количество сожженных килокалорий - " + convert.countingCalories (m));
                System.out.println ("Лучшая серия дней - " + results.findBestSeries(statMonth) + " дней");
            } else if (userInput == 3) {
                results.recordGoal();
                while (targetNumberSteps < 0) {
                    results.recordGoal();
                }
            } else {
                System.out.println ("Такой команды не существует. Выберите еще раз.");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }
    private static void printMenu() {
        System.out.println ("Какое действие вы хотите сделать? Выберите вариант:");
        System.out.println ("1 - Ввести количество шагов, пройденных за определенный день");
        System.out.println ("2 - Напечатать статистику за определенный месяц");
        System.out.println ("3 - Изменить цель по количеству шагов в день");
        System.out.println ("0 - Выход");
    }

    public static int printStatistic() { // Учесть, что номер месяца на 1 больше индекса
        Scanner scanner = new Scanner(System.in);
        System.out.println ("Введите номер месяца, за который вы хотите получить статистику -");
        int statMonth = scanner.nextInt();
        return (statMonth-1);
    }
}