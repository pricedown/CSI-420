package case2;

import java.util.Date;

public class Alert {

    private double average;
    private final int rating;
    private final Date expiry;
    private final Date maturity;
    private final int level;

    public Alert(double average, int rating, Date expiry) {
        this(average, rating, expiry, null, AlertLevel.NORMAL);
    }

    public Alert(double average, int rating, Date expiry, Date maturity) {
        this(average, rating, expiry, maturity, AlertLevel.NORMAL);
    }

    public Alert(double average, int rating, Date expiry, Date maturity, int level) {
        this.average = average;
        this.rating = rating;
        this.expiry = expiry;
        this.maturity = maturity;
        this.level = level;
    }

    public double getAverage() {
        return average;
    }

    public int getRating() {
        return rating;
    }

    public Date getExpiry() {
        return expiry;
    }

    public Date getMaturity() {
        return maturity;
    }

    public boolean isHighLevel() {
        return level == AlertLevel.HIGH;
    }

    public boolean isNormalLevel() {
        return level == AlertLevel.NORMAL;
    }

    public boolean isLowLevel() {
        return level == AlertLevel.LOW;
    }
    
    
}
