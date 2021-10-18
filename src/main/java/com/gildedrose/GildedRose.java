package com.gildedrose;

class GildedRose {
  Item[] items;

  GildedRose(Item[] item) {
    this.items = item;
  }

  private void updateBrie(Item item) {
    item.quality += 1;
  }

  private void updateSulfuras(Item item) {
    item.quality = 80;
  }

  private void updateBackstage(Item item) {
    if (item.sellIn < 11) {
      item.quality += 1;
    }
    if (item.sellIn < 6) {
      item.quality += 1;
    }
    if (item.sellIn <= 0) {
      item.quality = -1;
    }
  }

  private void updateConjured(Item item) {
    if (item.sellIn < 0) {
      item.quality -= 2;
    }
  }

  private void updateFoo(Item item) {
    if (item.sellIn <= 0) {
      item.quality -= 1;
    }
  }

  private void qualityCheck(Item item, int j) {
    item.sellIn -= 1;
    item.quality += j;

    if (item.quality > 50) {
      item.quality = 50;
    }
    if (item.quality < 0) {
      item.quality = 0;
    }
  }

  private void itemSort(Item item) {
    switch (item.name) {
      case "Aged Brie":
        updateBrie(item);
        qualityCheck(item, 0);
        break;

      case "Backstage passes to a TAFKAL80ETC concert":
        updateBackstage(item);
        qualityCheck(item, 1);
        break;

      case "Sulfuras, Hand of Ragnaros":
        updateSulfuras(item);
        break;

      case "Conjured":
        updateConjured(item);
        qualityCheck(item, -2);
        break;

      default:
        updateFoo(item);
        qualityCheck(item, -1);
        break;
    }
  }

  public void updateQuality() {

    for (Item items : items) {
      itemSort(items);
    }
  }
}
