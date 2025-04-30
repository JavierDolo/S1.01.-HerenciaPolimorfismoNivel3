public class F1News extends News {
    private String team;

    public F1News(String headline, String team) {
        super(headline);
        this.team = team;
    }

    @Override
    public double calculatePrice() {
        double price = 100;
        if ("Ferrari".equalsIgnoreCase(team) || "Mercedes".equalsIgnoreCase(team)) {
            price += 50;
        }
        return price;
    }

    @Override
    public int calculateScore() {
        int score = 4;
        if ("Ferrari".equalsIgnoreCase(team) || "Mercedes".equalsIgnoreCase(team)) {
            score += 2;
        }
        return score;
    }
}