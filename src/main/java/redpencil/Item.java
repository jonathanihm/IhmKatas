package redpencil;

import java.math.BigDecimal;

/**
 * Created by jonat on 4/30/2016.
 */
public class Item {
    private long upcCode;
    private BigDecimal price;
    private int percentReduction;

    public Item(long upcCode, BigDecimal price, int percentReduction) {
        this.upcCode = upcCode;
        this.price = price;
        this.percentReduction = percentReduction;
    }

    public long getUpcCode() {
        return upcCode;
    }

    public void setUpcCode(long upcCode) {
        this.upcCode = upcCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPercentReduction() {
        return percentReduction;
    }

    public void setPercentReduction(int percentReduction) {
        this.percentReduction = percentReduction;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Item) {
            Item t = (Item) o;
            if (this.upcCode == t.getUpcCode()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (this.upcCode ^ (this.upcCode >>> 32));
    }
}
