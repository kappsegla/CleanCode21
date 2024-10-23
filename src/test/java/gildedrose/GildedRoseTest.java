package gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void compareUpdateQualityBetweenOriginalAndRefactored() {
        Item[] items = new TestItem[]{
                new TestItem("+5 Dexterity Vest", 10, 20),
                new TestItem("Aged Brie", 2, 0),
                new TestItem("Elixir of the Mongoose", 5, 7),
                new TestItem("Sulfuras, Hand of Ragnaros", 0, 80),
                new TestItem("Sulfuras, Hand of Ragnaros", -1, 80),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new TestItem("Conjured Mana Cake", 3, 6)};

        Item[] items2 = new TestItem[]{
                new TestItem("+5 Dexterity Vest", 10, 20),
                new TestItem("Aged Brie", 2, 0),
                new TestItem("Elixir of the Mongoose", 5, 7),
                new TestItem("Sulfuras, Hand of Ragnaros", 0, 80),
                new TestItem("Sulfuras, Hand of Ragnaros", -1, 80),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new TestItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new TestItem("Conjured Mana Cake", 3, 6)};


        GildedRose app = new GildedRose(items);
        GildedRoseRefactored refactored = new GildedRoseRefactored(items2);

        app.updateQuality();
        refactored.updateQuality();

        assertThat(items).isEqualTo(items2);
    }

}
