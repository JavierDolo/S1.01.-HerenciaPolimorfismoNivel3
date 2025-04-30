public abstract class News {
    private String headline;
    private String text = " ";
    private int score;
    private double price;

    public News(String headline) {
        this.headline = headline;
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract double calculatePrice();
    public abstract int calculateScore();
}