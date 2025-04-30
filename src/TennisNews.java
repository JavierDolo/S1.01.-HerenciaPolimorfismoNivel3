public class TennisNews extends News {
    private String competition;
    private String player;

    public TennisNews(String headline, String competition, String player) {
        super(headline);
        this.competition = competition;
        this.player = player;
    }

    @Override
    public double calculatePrice() {
        double price = 150;
        if ("Federer".equalsIgnoreCase(player) || "Nadal".equalsIgnoreCase(player) || "Djokovic".equalsIgnoreCase(player)) {
            price += 100;
        }
        return price;
    }

    @Override
    public int calculateScore() {
        int score = 4;
        if ("Federer".equalsIgnoreCase(player) || "Nadal".equalsIgnoreCase(player) || "Djokovic".equalsIgnoreCase(player)) {
            score += 3;
        }
        return score;
    }
}