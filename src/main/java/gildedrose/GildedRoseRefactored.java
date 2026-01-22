package gildedrose;

class GildedRoseRefactored {
    Item[] items;

    public GildedRoseRefactored(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            updateBeforeExpiration(item);

            if (isNotSulfuras(item)) {
                decreaseSellIn(item);
            }

            if (isExpired(item)) {
                updateExpiredItem(item);
            }
        }
    }

    private static void updateBeforeExpiration(Item item) {
        if (isAgedBrie(item) || isBackStagePass(item)) {
            if (hasMaxQuality(item)) {
                increaseQuality(item);

                if (isBackStagePass(item)) {
                    increaseBackStageQuality(item);
                }
            }
        } else {
            updateNormalItem(item);
        }
    }

    private static void updateNormalItem(Item item) {
        if (hasMinQuality(item)) {
            if (isNotSulfuras(item)) {
                decreaseQuality(item);
            }
        }
    }

    private static boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private static void updateExpiredItem(Item item) {
        if (!isAgedBrie(item)) {
            if (!isBackStagePass(item)) {
                updateNormalItem(item);
            } else {
                item.quality = 0;
            }
        } else {
            if (hasMaxQuality(item)) {
                increaseQuality(item);
            }
        }
    }

    private static void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private static void increaseBackStageQuality(Item item) {
        if (item.sellIn < 11) {
            if (hasMaxQuality(item)) {
                increaseQuality(item);
            }
        }

        if (item.sellIn < 6) {
            if (hasMaxQuality(item)) {
                increaseQuality(item);
            }
        }
    }

    private static boolean hasMaxQuality(Item item) {
        return item.quality < 50;
    }

    private static boolean hasMinQuality(Item item) {
        return item.quality > 0;
    }

    private static void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private static void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private static boolean isNotSulfuras(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private static boolean isBackStagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }
}
