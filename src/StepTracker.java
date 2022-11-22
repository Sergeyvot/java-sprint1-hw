import java.util.Scanner;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    Main input = new Main();
    int targetNumberSteps = 10000;
    int inputTargetSteps = input.newTargetNumberSteps;  // Сохраняем введенную в Main новую цель
    MonthData[] monthToData;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    static class MonthData {
        int[] stepsDay = new int[30]; // Массив со значениями шагов по дням

         // Заполните класс самостоятельно
    }
    int recordGoal( int targetNumberSteps) { //Задание новой цели по шагам в день. Возвращающий метод
        System.out.println ("Текущее значение " + targetNumberSteps + " шагов. Введите новую цель" );
        int newTargetNumberSteps  = scanner.nextInt();
        while (newTargetNumberSteps < 0) {
            System.out.println ("Целевое количество шагов не может быть отрицательным. Попробуйте еще раз");
            newTargetNumberSteps  = scanner.nextInt();
        }
        return newTargetNumberSteps;
    }
    void printStatMonth (int inputMonth) { //Метод печатающий статистику шагов по дням
        for (int j = 0; j < monthToData[inputMonth].stepsDay.length; j++) {
            System.out.print(j + " день: " + monthToData[inputMonth].stepsDay[j] + ", ");
        }
    }
    int findSumSteps(int inputMonth) { // Возвращающий метод - сумма шагов за месяц
        int sumSteps = 0;
        for (int j = 0; j < monthToData[inputMonth].stepsDay.length; j++) {
            sumSteps = sumSteps + monthToData[inputMonth].stepsDay[j];
        }
        return sumSteps;
    }
    int findMaxSteps(int inputMonth) { // Метод возвращает максимальное количество шагов в месяце
        int maxSteps = 0;
        for (int j = 0; j < monthToData[inputMonth].stepsDay.length; j++) {
            if (maxSteps < monthToData[inputMonth].stepsDay[j]) {
                maxSteps = monthToData[inputMonth].stepsDay[j];
            }
        }
        return maxSteps;
    }
    void enterSteps() { // Метод ввода количества пройденных шагов
        System.out.println ("Введите номер месяца, по которому сохраняете данные. Номера месяцев начинаются с 0");
        int numberMonth = scanner.nextInt();
        while ((numberMonth < 0) || (numberMonth > 11)) { // Проверяем на корректность
            System.out.println("Введите корректное значение месяца от 0 до 11");
            numberMonth = scanner.nextInt();
        }
        System.out.println ("Введите номер дня, за который сохраняете данные. Номера дней начинаются с 0");
        int numberDay = scanner.nextInt();
        while ((numberDay < 0) || (numberDay > 29)) { // Проверяем на корректность
            System.out.println("Введите корректное значение дня от 0 до 29");
            numberDay = scanner.nextInt();
        }
        System.out.println ("Введите количеество пройденных шагов");
        int numberSteps = scanner.nextInt();
        while (numberSteps < 0) {
            System.out.println ("Количество шагов не может быть отрицательным. Попробуйте еще раз");
            System.out.println ("Введите количеество пройденных шагов");
            numberSteps = scanner.nextInt();
        }
        monthToData[numberMonth].stepsDay[numberDay] = numberSteps;
        System.out.println ("Данные сохранены");
    }
    int findBestSeries (int inputMonth) { // Метод возвращает значение лучшей серии
        int bestSeries = 0;
        int series = 0;
        int basicPurposeOfSteps;
        if ((inputTargetSteps == 0) || (inputTargetSteps == targetNumberSteps)) {
            basicPurposeOfSteps = targetNumberSteps;
        } else {
            basicPurposeOfSteps = inputTargetSteps;
        }
        for (int j = 0; j < monthToData[inputMonth].stepsDay.length; j++) {
            if (monthToData[inputMonth].stepsDay[j] >= basicPurposeOfSteps) {
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
