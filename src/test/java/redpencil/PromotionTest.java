package redpencil;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonat on 4/30/2016.
 */
public class PromotionTest {

    @Test
    public void createPromotion() throws Exception {
        Promotion p = Promotion.createPromotion(new BigDecimal(5), 5);
        assertEquals(new BigDecimal(5), p.getPrice());
        assertEquals(5, p.getSale());
        assertEquals(0, p.getDuration());
        assertEquals(30, p.getPriceStableDuration());
    }

    @Test
    public void promotionDurationTest() throws Exception {
        Promotion p = Promotion.createPromotion(new BigDecimal(5), 5);
        for (int i = 0; i < 30; i++) {
            assertEquals(i, p.getDuration());
            p = Promotion.incrementDuration(p);
        }
        p = Promotion.incrementDuration(p);
        assertEquals(0, p.getDuration());
    }

    @Test
    public void promotionPriceIncreaseTest() throws Exception {
        Promotion p = Promotion.createPromotion(new BigDecimal(5), 5);
        for (int i = 0; i < 4; i++) {
            p = Promotion.incrementDuration(p);
        }
        p.setPrice(new BigDecimal(3));
        assertEquals(4, p.getDuration());
        p.setPrice(new BigDecimal(10));
        assertEquals(0, p.getDuration());
        assertEquals(0, p.getSale());
    }
}