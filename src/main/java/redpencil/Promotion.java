package redpencil;

import java.math.BigDecimal;

/**
 * Created by jonat on 4/30/2016.
 */
public class Promotion {
    private static final int MAX_PROMOTION_DURATION = 30;
    private static final int MINIMUM_STABLE_PRICE_DURATION = 30;

    private BigDecimal price;
    private int sale;
    private int duration;
    private int priceStableDuration;

    private Promotion(BigDecimal price, int sale, int duration, int priceStableDuration) {
        this.price = price;
        this.sale = sale;
        this.duration = duration;
        this.priceStableDuration = priceStableDuration;
    }

    public static Promotion createPromotion(BigDecimal price, int sale) {
        if (sale < 5 || sale > 30) {
            throw new UnsupportedOperationException("Sale must be between 5 and 30 percent");
        }
        Promotion p = new Promotion(price, sale, 0, 30);
        return p;
    }

    public static Promotion incrementDuration(Promotion p) {
        if (p.getDuration() >= MAX_PROMOTION_DURATION) {
            p.sale = 0;
            p.duration = 0;
        }else {
            p.duration += 1;
        }
        p.setPriceStableDuration(p.getPriceStableDuration() + 1);
        return p;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (this.price.compareTo(price) < 1) {
            sale = 0;
            duration = 0;
        }
        this.price = price;
        this.priceStableDuration = 0;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPriceStableDuration() {
        return priceStableDuration;
    }

    public void setPriceStableDuration(int priceStableDuration) {
        this.priceStableDuration = priceStableDuration;
    }

    //
//    private HashMap<Item, Integer> currentPromotions = new HashMap<>();
//    private HashMap<Item, Integer> ineligibleForPromotion = new HashMap<>();
//
//    // safely adds a red pencil promotion without replacing duration
//    public void addPromotion(Item item) {
//        if (item.getPercentReduction() < 5 || item.getPercentReduction() > 30) {
//            throw new UnsupportedOperationException("Reduction amount must be  between 5 and 30 percent");
//        }
//        if (!currentPromotions.containsKey(item)
//                && !ineligibleForPromotion.containsKey(item)) {
//            currentPromotions.put(item, 0);
//        }
//    }
//
//    public void endPromotion(Item item) {
//        ineligibleForPromotion.put(item, 0);
//        currentPromotions.entrySet().remove(item);
//    }
//
//    public void addReductionToItem(Item item, add)
//
//
//    public void incrementDuration() {
//        Iterator currentIterator = currentPromotions.entrySet().iterator();
//        while (currentIterator.hasNext()) {
//            Map.Entry<Item, Integer> m = (Map.Entry<Item, Integer>) currentIterator.next();
//            if (m.getValue() == MAX_PROMOTION_DURATION) {
//                endPromotion(m.getKey());
//            } else {
//                m.setValue(m.getValue() + 1);
//            }
//        }
//        Iterator ineligibleIterator = ineligibleForPromotion.entrySet().iterator();
//        while (ineligibleIterator.hasNext()) {
//            Map.Entry<Item, Integer> m = (Map.Entry<Item, Integer>) ineligibleIterator.next();
//            if (m.getValue() == MINIMUM_STABLE_PRICE_DURATION) {
//                ineligibleIterator.remove();
//            } else {
//                m.setValue(m.getValue() + 1);
//            }
//        }
//    }
}
