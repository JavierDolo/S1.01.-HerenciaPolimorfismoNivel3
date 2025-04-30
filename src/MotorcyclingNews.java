public class MotorcyclingNews extends News {
    private String team;

    public MotorcyclingNews(String headline, String team) {
        super(headline);
        this.team = team;
    }

    @Override
    public double calculatePrice() {
        double price = 100;
        if ("Honda".equalsIgnoreCase(team) || "Yamaha".equalsIgnoreCase(team)) {
            price += 50;
        }
        return price;
    }

    @Override
    public int calculateScore() {
        int score = 3;
        if ("Honda".equalsIgnoreCase(team) || "Yamaha".equalsIgnoreCase(team)) {
            score += 3;
        }
        return score;
    }
}