import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    int targetNumberSteps = 10000;

    MonthData[] monthToData;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    class MonthData {
        int[] stepsDay = new int[30]; // Массив со значениями шагов по дням

         // Заполните класс самостоятельно
    }

    int recordGoal() { //Задание новой цели по шагам в день. Возвращающий метод
        System.out.println ("Какое количество шагов в день вы хотите задать в качестве цели?");
        int targetNumberSteps  = scanner.nextInt();
        if (targetNumberSteps < 0) {
            System.out.println ("Целевое количество шагов не может быть отрицательным");
        }
        return targetNumberSteps;
    }
    void printStatMonth (int i) { //Метод печатающий статистику шагов по дням
        StepTracker results = new StepTracker();
        for (int j = 0; j < monthToData[i].stepsDay.length; j++) {
            System.out.print(j + " день: " + monthToData[i].stepsDay[j] + ", ");
        }
    }
    int findSumSteps(int i) { // Возвращающий метод - сумма шагов за месяц
        int sumSteps = 0;
        StepTracker results = new StepTracker();
        for (int j = 0; j < monthToData[i].stepsDay.length; j++) {
            sumSteps = sumSteps + monthToData[i].stepsDay[j];
        }
        return sumSteps;
    }
    int findMaxSteps(int i) { // Метод возвращает максимальное количество шагов в месяце
        int maxSteps = 0;
        StepTracker results = new StepTracker();
        for (int j = 0; j < monthToData[i].stepsDay.length; j++) {
            if (maxSteps < monthToData[i].stepsDay[j]) {
                maxSteps = monthToData[i].stepsDay[j];
            }
        }
        return maxSteps;
    }
    void enterSteps() { // Метод ввода количества пройденных шагов
        System.out.println ("Введите номер месяца, по которому сохраняете данные. Номера месяцев начинаются с 0");
        int numberMonth = scanner.nextInt();
        System.out.println ("Введите номер дня, за который сохраняете данные");
        int numberDay = scanner.nextInt();
        System.out.println ("Введите количеество пройденных шагов");
        int numberSteps = scanner.nextInt();
        while (numberSteps < 0) {
            System.out.println ("Количество шагов не может быть отрицательным. Попробуйте еще раз");
            System.out.println ("Введите количеество пройденных шагов");
            numberSteps = scanner.nextInt();
        }
        StepTracker results = new StepTracker();
        monthToData[numberMonth].stepsDay[numberDay] = numberSteps;
        System.out.println ("Данные сохранены");
    }
    int findBestSeries (int i) { // Метод возвращает значение лучшей серии
        StepTracker results = new StepTracker();
        int bestSeries = 0;
        int series = 0;
        for (int j = 0; j < monthToData[i].stepsDay.length; j++) {
            if (monthToData[i].stepsDay[j] >= targetNumberSteps) {
                series = series + 1;
                if (bestSeries < series) {
                    bestSeries = series;
                }
            } else {
            series = 0;
            }
        }
        return bestSeries;
    }
}
