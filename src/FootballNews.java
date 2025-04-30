public class FootballNews extends News {
    private String competition;
    private String club;
    private String player;

    public FootballNews(String headline, String competition, String club, String player) {
        super(headline);
        this.competition = competition;
        this.club = club;
        this.player = player;
    }

    @Override
    public double calculatePrice() {
        double price = 300;
        if ("Champions League".equalsIgnoreCase(competition)) price += 100;
        if ("Barça".equalsIgnoreCase(club) || "Madrid".equalsIgnoreCase(club)) price += 100;
        if ("Ferran Torres".equalsIgnoreCase(player) || "Benzema".equalsIgnoreCase(player)) price += 50;
        return price;
    }

    @Override
    public int calculateScore() {
        int score = 5;
        if ("Champions League".equalsIgnoreCase(competition)) score += 3;
        if ("League".equalsIgnoreCase(competition)) score += 2;
        if ("Barça".equalsIgnoreCase(club) || "Madrid".equalsIgnoreCase(club)) score += 1;
        if ("Ferran Torres".equalsIgnoreCase(player) || "Benzema".equalsIgnoreCase(player)) score += 1;
        return score;
    }
}