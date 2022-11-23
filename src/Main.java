import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Пришло время практики!");
        Scanner scanner = new Scanner(System.in);
        StepTracker results = new StepTracker();

        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                results.enterSteps();
            } else if (userInput == 2) {
                printStatisticOfMonth (results, scanner); // Переменные классов передаются параметрами
            } else if (userInput == 3) {
                results.recordGoal();
                // При вызове метода обновляется значение поля класса StepTracker
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
    public static void printStatisticOfMonth(StepTracker results, Scanner scanner) {
        Converter convert = new Converter();
        System.out.println ("Введите номер месяца, за который вы хотите получить статистику -");
        int statMonth = scanner.nextInt();
        while ((statMonth < 0) || (statMonth > 11)) { // Проверяем на корректность
            System.out.println("Введите корректное значение месяца от 0 до 11");
            statMonth = scanner.nextInt();
        }
        System.out.println ("Количество пройденных шагов в выбранном месяце по дням - ");
        results.printStatMonth(statMonth);
        System.out.println();
        System.out.println ("Общее количество шагов за месяц - " + results.findSumSteps(statMonth));
        System.out.println ("Максимальное пройденное количество шагов в месяце - " + results.findMaxSteps(statMonth));
        System.out.println ("Среднее количество шагов в день - " + results.findSumSteps(statMonth)/30);
        System.out.println ("Пройденная дистанция в километрах - " + convert.convertSteps(results.findSumSteps(statMonth)));
        System.out.println ("Количество сожженных килокалорий - " + convert.countCalories (results.findSumSteps(statMonth)));
        System.out.println ("Лучшая серия дней - " + results.findBestSeries(statMonth) + " дней");
    }
}