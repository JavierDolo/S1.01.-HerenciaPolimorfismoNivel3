import java.util.ArrayList;

public class Editor {
    private String name;
    private final String dni;
    public static double salary = 1500.0;
    private ArrayList<News> newsList;

    public Editor(String name, String dni) {
        this.name = name;
        this.dni = dni;
        this.newsList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public static double getSalary() {
        return salary;
    }

    public static void setSalary(double newSalary) {
        salary = newSalary;
    }

    public ArrayList<News> getNews() {
        return newsList;
    }

    public void addNews(News news) {
        newsList.add(news);
    }

    public boolean removeNews(News news) {
        return newsList.remove(news);
    }
}