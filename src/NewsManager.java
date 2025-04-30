import java.util.ArrayList;
import java.util.Scanner;

public class NewsManager {
    private static ArrayList<Editor> editors = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void start() {
        initializeData();
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            executeOption(option);
        } while (option != 8);
    }

    private void showMenu() {
        System.out.println("Menu: ");
        System.out.println("1.- Add editor");
        System.out.println("2.- Remove editor");
        System.out.println("3.- Add news to an editor");
        System.out.println("4.- Remove news");
        System.out.println("5.- Show all news by editor");
        System.out.println("6.- Calculate news score");
        System.out.println("7.- Calculate news price");
        System.out.println("8.- Exit");
        System.out.print("Choose an option: ");
    }

    private void executeOption(int option) {
        switch (option) {
            case 1 -> addEditor();
            case 2 -> removeEditor();
            case 3 -> addNews();
            case 4 -> removeNews();
            case 5 -> showNewsByEditor();
            case 6 -> calculateNewsScore();
            case 7 -> calculateNewsPrice();
            case 8 -> System.out.println("Exiting program...");
            default -> System.out.println("Invalid option.");
        }
    }

    private static void initializeData() {
        Editor editor1 = new Editor("Javier D", "12345678A");
        News news1 = new FootballNews("Benzema's goal", "Champions League", "Madrid", "Benzema");
        News news2 = new BasketballNews("Barça wins", "EuroLeague", "Barça");
        editor1.addNews(news1);
        editor1.addNews(news2);

        Editor editor2 = new Editor("Cristina O", "87654321B");
        News news3 = new TennisNews("Nadal's match", "Roland Garros", "Nadal");
        News news4 = new F1News("Ferrari dominates", "Ferrari");
        editor2.addNews(news3);
        editor2.addNews(news4);

        editors.add(editor1);
        editors.add(editor2);

        System.out.println("Initial data loaded:");
        System.out.println("2 editors and their news added successfully.\n");
    }

    private static void addEditor() {
        System.out.println("Editor name: ");
        String name = scanner.nextLine();
        System.out.println("Editor DNI: ");
        String dni = scanner.nextLine();
        editors.add(new Editor(name, dni));
        System.out.println("Editor added successfully.");
    }

    private static void removeEditor() {
        System.out.println("Enter the DNI of the editor to remove: ");
        String dni = scanner.nextLine();
        editors.removeIf(editor -> editor.getDni().equals(dni));
        System.out.println("Editor removed successfully.");
    }

    private static void addNews() {
        System.out.print("Editor DNI: ");
        String dni = scanner.nextLine();

        Editor editor = editors.stream()
                .filter(e -> e.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (editor == null) {
            System.out.println("Editor not found.");
            return;
        }

        System.out.print("News type (Football, Basketball, Tennis, F1, Motorcycling): ");
        String type = scanner.nextLine();
        System.out.print("Headline: ");
        String headline = scanner.nextLine();

        News news = null;
        switch (type.toLowerCase()) {
            case "football" -> {
                System.out.print("Competition: ");
                String competition = scanner.nextLine();
                System.out.print("Club: ");
                String club = scanner.nextLine();
                System.out.print("Player: ");
                String player = scanner.nextLine();
                news = new FootballNews(headline, competition, club, player);
            }
            case "basketball" -> {
                System.out.print("Competition: ");
                String competition = scanner.nextLine();
                System.out.print("Club: ");
                String club = scanner.nextLine();
                news = new BasketballNews(headline, competition, club);
            }
            case "tennis" -> {
                System.out.print("Competition: ");
                String competition = scanner.nextLine();
                System.out.print("Player: ");
                String player = scanner.nextLine();
                news = new TennisNews(headline, competition, player);
            }
            case "f1" -> {
                System.out.print("Team: ");
                String team = scanner.nextLine();
                news = new F1News(headline, team);
            }
            case "motorcycling" -> {
                System.out.print("Team: ");
                String team = scanner.nextLine();
                news = new MotorcyclingNews(headline, team);
            }
            default -> System.out.println("Invalid news type.");
        }

        if (news != null) {
            editor.addNews(news);
            System.out.println("News added.");
        }
    }

    private static void removeNews() {
        System.out.print("Editor DNI: ");
        String dni = scanner.nextLine();

        Editor editor = editors.stream()
                .filter(e -> e.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (editor == null) {
            System.out.println("Editor not found.");
            return;
        }

        ArrayList<News> newsList = editor.getNews();
        if (newsList.isEmpty()) {
            System.out.println("This editor has no news.");
            return;
        }

        System.out.println("Editor’s news:");
        for (int i = 0; i < newsList.size(); i++) {
            System.out.println((i + 1) + ". " + newsList.get(i).getHeadline());
        }

        System.out.print("Enter the number of the news to remove: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 1 || number > newsList.size()) {
            System.out.println("Invalid number.");
            return;
        }

        News removedNews = newsList.remove(number - 1);
        System.out.println("The news \"" + removedNews.getHeadline() + "\" has been removed.");
    }

    private static void showNewsByEditor() {
        System.out.print("Editor DNI: ");
        String dni = scanner.nextLine();

        Editor editor = editors.stream()
                .filter(e -> e.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (editor == null) {
            System.out.println("Editor not found.");
            return;
        }

        ArrayList<News> newsList = editor.getNews();
        if (newsList.isEmpty()) {
            System.out.println("This editor has no news.");
            return;
        }

        System.out.println("News by editor " + editor.getName() + ":");
        for (int i = 0; i < newsList.size(); i++) {
            News news = newsList.get(i);
            System.out.println((i + 1) + ". Headline: " + news.getHeadline());
            System.out.println("   Text: " + news.getText());
        }
    }

    private static void calculateNewsPrice() {
        System.out.print("Editor DNI: ");
        String dni = scanner.nextLine();

        Editor editor = editors.stream()
                .filter(e -> e.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (editor == null) {
            System.out.println("Editor not found.");
            return;
        }

        ArrayList<News> newsList = editor.getNews();
        if (newsList.isEmpty()) {
            System.out.println("This editor has no news.");
            return;
        }

        System.out.println("Editor’s news:");
        for (int i = 0; i < newsList.size(); i++) {
            System.out.println((i + 1) + ". " + newsList.get(i).getHeadline());
        }

        System.out.print("Enter the number of the news to calculate its price: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 1 || number > newsList.size()) {
            System.out.println("Invalid number.");
            return;
        }

        News selectedNews = newsList.get(number - 1);
        double price = selectedNews.calculatePrice();
        System.out.println("The price of the news \"" + selectedNews.getHeadline() + "\" is: " + price + "€");
    }

    private static void calculateNewsScore() {
        System.out.print("Editor DNI: ");
        String dni = scanner.nextLine();

        Editor editor = editors.stream()
                .filter(e -> e.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if (editor == null) {
            System.out.println("Editor not found.");
            return;
        }

        ArrayList<News> newsList = editor.getNews();
        if (newsList.isEmpty()) {
            System.out.println("This editor has no news.");
            return;
        }

        System.out.println("Editor’s news:");
        for (int i = 0; i < newsList.size(); i++) {
            System.out.println((i + 1) + ". " + newsList.get(i).getHeadline());
        }

        System.out.print("Enter the number of the news to calculate its score: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 1 || number > newsList.size()) {
            System.out.println("Invalid number.");
            return;
        }

        News selectedNews = newsList.get(number - 1);
        int score = selectedNews.calculateScore();
        System.out.println("The score of the news \"" + selectedNews.getHeadline() + "\" is: " + score + " points");
    }
}
