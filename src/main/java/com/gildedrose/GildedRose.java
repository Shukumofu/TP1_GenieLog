package com.gildedrose;

class GildedRose {
  Item[] items;

  GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateBrie(int i) {
    items[i].sellIn = items[i].sellIn - 1;
    if (items[i].quality < 50) {
      items[i].quality = items[i].quality + 1;
    }
  }

  public void updateSulfuras(int i) {
    items[i].quality = 80;
  }

  public void updateBackstage(int i) {
    items[i].sellIn = items[i].sellIn - 1;

    if (items[i].quality < 50) {
      items[i].quality = items[i].quality + 1;
    }
    if (items[i].quality < 50 && items[i].sellIn < 11) {
      items[i].quality = items[i].quality + 1;
    }
    if (items[i].quality < 50 && items[i].sellIn < 6) {
      items[i].quality = items[i].quality + 1;
    }
    if (items[i].sellIn < 0) {
      items[i].quality = 0;
    }
  }

  public void updateConjured(int i) {
    items[i].sellIn = items[i].sellIn - 1;
    if (items[i].quality > 1) {
      items[i].quality = items[i].quality - 2;
    }
    if (items[i].quality > 1 && items[i].sellIn < 0) {
      items[i].quality = items[i].quality - 2;
    }
  }

  public void updateFoo(int i) {
    items[i].sellIn = items[i].sellIn - 1;
    if (items[i].quality > 0) {
      items[i].quality = items[i].quality - 1;
    }
    if (items[i].quality > 0 && items[i].sellIn < 0) {
      items[i].quality = items[i].quality - 1;
    }
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (items[i].name.equals("Aged Brie")) {
        updateBrie(i);
      } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
        updateBackstage(i);
      } else if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
        updateSulfuras(i);
      } else  if (items[i].name.equals("Conjured")) {
        updateConjured(i);
      } else {
        updateFoo(i);
      }
    }
  }
}
