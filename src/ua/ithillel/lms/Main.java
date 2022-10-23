package ua.ithillel.lms;

import java.util.HashMap;
import java.util.Map;
import ua.ithillel.lms.javapro.pavlopashchevskyi.mentor.task1.NewsAgency;
import ua.ithillel.lms.javapro.pavlopashchevskyi.mentor.task1.NewsChannel;

public class Main {

  public static void main(String[] args) {
    Map<String, NewsAgency> mna = new HashMap<>();
    mna.put("reuters", new NewsAgency("REUTERS"));
    mna.put("unian", new NewsAgency("УНІАН"));

    Map<String, NewsChannel> mnc = new HashMap<>();
    mnc.put("bbc", new NewsChannel("BBC"));
    mnc.put("cnn", new NewsChannel("CNN"));
    mnc.put("dw", new NewsChannel("DW"));
    mnc.put("tsn", new NewsChannel("ТСН"));

    mna.get("reuters").setNews("колобок повісився");
    mna.get("unian").setNews("ЗСУ звільнили місто Лиман на Донеччині");

    mna.get("reuters").attach(mnc.get("bbc"));
    mna.get("reuters").attach(mnc.get("cnn"));
    mna.get("reuters").attach(mnc.get("dw"));
    mna.get("unian").attach(mnc.get("tsn"));

    System.out.println(mna.get("reuters"));
    System.out.println(mna.get("unian"));

    mna.get("reuters").inform();
    mna.get("reuters").detach(mnc.get("dw"));
    mna.get("unian").inform();

    for (NewsAgency nao : mna.values()) {
      for (NewsChannel nco : mnc.values()) {
        if (nao.isAttached(nco)) {
          System.out.println(
              nco.getName() + ": як повідомило агенство \"" + nao.getName() + "\", " + nco.getNews()
                  + ".");
        }
      }
    }
  }
}