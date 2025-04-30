public class BasketballNews extends News {
    private String competition;
    private String club;

    public BasketballNews(String headline, String competition, String club) {
        super(headline);
        this.competition = competition;
        this.club = club;
    }

    @Override
    public double calculatePrice() {
        double price = 250;
        if ("EuroLeague".equalsIgnoreCase(competition)) price += 75;
        if ("Barça".equalsIgnoreCase(club) || "Madrid".equalsIgnoreCase(club)) price += 75;
        return price;
    }

    @Override
    public int calculateScore() {
        int score = 4;
        if ("EuroLeague".equalsIgnoreCase(competition)) score += 3;
        if ("ABC".equalsIgnoreCase(competition)) score += 2;
        if ("Barça".equalsIgnoreCase(club) || "Madrid".equalsIgnoreCase(club)) score += 1;
        return score;
    }
}