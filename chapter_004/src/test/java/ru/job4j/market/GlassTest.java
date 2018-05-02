package ru.job4j.market;

import org.junit.Test;

/**
 * Test market.
 * @author Ayup Bariev.
 */
public class GlassTest {


    @Test
    public void whenSimilarPriceAndDifferentActionShouldSellItem() {

        Market market = new Market();
        market.addItem("Alibaba", Type.add, Action.bid, 10, 2);
        market.addItem("Alibaba", Type.add, Action.ask, 10, 3);

        market.print();

    }

    @Test
    public void whenSimilarPriceAndTypeAndTypeDifferentShouldDeleteItemOFGlass() {

        Market market = new Market();
        market.addItem("Alibaba", Type.add, Action.ask, 10, 3);
        market.addItem("Alibaba", Type.delete, Action.ask, 10, 1);

        market.print();
    }

    @Test
    public void whenSimilarTypeActionPriceThenEmptyGlass() {
        Market market = new Market();
        market.addItem("Alibaba", Type.add, Action.ask, 10, 3);
        market.addItem("Alibaba", Type.add, Action.bid, 10, 3);
        market.addItem("Alibaba", Type.add, Action.ask, 50, 1);
        market.addItem("Alibaba", Type.add, Action.bid, 50, 1);
        market.addItem("Sum", Type.add, Action.ask, 100, 2);
        market.addItem("Sum", Type.add, Action.bid, 100, 2);
        market.addItem("Sum", Type.add, Action.ask, 3, 3);
        market.addItem("Sum", Type.add, Action.bid, 3, 3);

        market.print();
    }

    @Test
    public void whenSimilarTypeActionVolumePriceTheEmptyMarket() {
        Market market = new Market();
        market.addItem("mail", Type.add, Action.ask, 10, 3);
        market.addItem("mail", Type.delete, Action.ask, 10, 3);

        market.print();
    }


    @Test
    public void testSix() {
        Market market = new Market();
        market.addItem("Alibaba", Type.add, Action.ask, 10, 3);
        market.addItem("Alibaba", Type.add, Action.ask, 10, 3);
        market.addItem("Alibaba", Type.add, Action.ask, 51, 1);
        market.addItem("Alibaba", Type.add, Action.ask, 50, 1);
        market.addItem("Sum", Type.add, Action.ask, 100, 2);
        market.addItem("Sum", Type.add, Action.ask, 101, 2);
        market.addItem("Sum", Type.add, Action.ask, 3, 3);
        market.addItem("Sum", Type.add, Action.ask, 4, 3);

        market.addItem("Alibaba", Type.delete, Action.ask, 10, 3);
        market.addItem("Sum", Type.delete, Action.ask, 3, 3);

        market.print();
    }

    @Test
    public void testSeven() {
        Market market = new Market();
        market.addItem("Alibaba", Type.add, Action.bid, 10, 3);
        market.addItem("Alibaba", Type.add, Action.bid, 10, 3);
        market.addItem("Alibaba", Type.add, Action.bid, 51, 1);
        market.addItem("Alibaba", Type.add, Action.bid, 50, 1);
        market.addItem("Sum", Type.add, Action.bid, 100, 2);
        market.addItem("Sum", Type.add, Action.bid, 101, 2);
        market.addItem("Sum", Type.add, Action.bid, 3, 3);
        market.addItem("Sum", Type.add, Action.bid, 4, 3);

        market.print();
    }

    @Test
    public void testEnd() {
        Market market = new Market();
        market.addItem("Alibaba", Type.add, Action.bid, 10, 3);
        market.addItem("Alibaba", Type.add, Action.bid, 10, 3);
        market.addItem("Alibaba", Type.add, Action.bid, 51, 1);
        market.addItem("Alibaba", Type.add, Action.bid, 50, 1);
        market.addItem("Alibaba", Type.add, Action.bid, 100, 2);
        market.addItem("Alibaba", Type.add, Action.bid, 101, 2);
        market.addItem("Alibaba", Type.add, Action.bid, 3, 3);
        market.addItem("Alibaba", Type.add, Action.bid, 4, 3);

        market.addItem("Alibaba", Type.add, Action.ask, 564, 3);
        market.addItem("Alibaba", Type.add, Action.ask, 600, 3);
        market.addItem("Alibaba", Type.add, Action.ask, 400, 1);
        market.addItem("Alibaba", Type.add, Action.ask, 333, 1);
        market.addItem("Alibaba", Type.add, Action.ask, 444, 2);
        market.addItem("Alibaba", Type.add, Action.ask, 888, 2);
        market.addItem("Alibaba", Type.add, Action.ask, 987, 3);
        market.addItem("Alibaba", Type.add, Action.ask, 564, 3);

        market.print();
    }
}

