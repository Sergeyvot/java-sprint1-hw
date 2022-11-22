public class Converter {
    public double convertSteps (int sumSteps) { // Метод возвращает пройденные шаги в км
        double mileage = sumSteps * 0.00075; /* ВОПРОС - Обе переменные определяются,
       как избыточные. Да, можно было бы их подсчитать в main при вызове метода findSumSteps,
       но создание класса Converter было указано в ТЗ. Поэтому некритично?*/
        return mileage;
    }
    public double countCalories (int sumSteps) { // Метод возвращает потраченные ккал

        double numberCalories = sumSteps * 0.05;
        return numberCalories;
    }
}
