public class Converter {
    public double convertSteps (int sumSteps) { // Метод возвращает пройденные шаги в км
        return sumSteps * 0.00075;
    }
    public double countCalories (int sumSteps) { // Метод возвращает потраченные ккал
        return sumSteps * 0.05;
    }
}
