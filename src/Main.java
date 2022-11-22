import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("Пришло время практики!");
        Scanner scanner = new Scanner(System.in);
        StepTracker results = new StepTracker ();
        Converter convert = new Converter();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (userInput == 1) {
                results.enterSteps();
            } else if (userInput == 2) {
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

            } else if (userInput == 3) {
                results.targetNumberSteps = results.recordGoal();
                // Вызываем метод и одновременно сохраняем его результат
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
    /*  Оставил в качестве вопроса. При текущем коде статистику печатает. Если я пробую убрать
    блок вот в такой метод ниже, и при вводе на консоли 2, его вызвать, статистика выходит с нулями
    по всем строкам. "Внутренности" совпадают. Не могу понять, почему перестает корректно работать?
    Static  у метода убрать не дает. Ошибка связана с типами или с чем-то другим? С вызовом метода
    основной код конечно, красивее выглядит)
    
    public static void printStatisticOfMonth() {
        Converter convert = new Converter();
        StepTracker results = new StepTracker ();
        Scanner scanner = new Scanner(System.in);
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
    } */
}