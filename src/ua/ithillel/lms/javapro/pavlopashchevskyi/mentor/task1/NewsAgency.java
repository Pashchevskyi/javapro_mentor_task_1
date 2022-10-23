package ua.ithillel.lms.javapro.pavlopashchevskyi.mentor.task1;

import java.util.ArrayList;
import java.util.List;
import ua.ithillel.lms.javapro.pavlopashchevskyi.mentor.task1.api.Notifiable;
import ua.ithillel.lms.javapro.pavlopashchevskyi.mentor.task1.api.Observable;

public class NewsAgency implements Observable {

  private final String name;

  private String news;

  private final List<Notifiable> channels = new ArrayList<>();

  public NewsAgency(String name) {
    this.name = name;
  }

  @Override
  public void attach(Notifiable notifiable) {
    this.channels.add(notifiable);
  }

  @Override
  public void detach(Notifiable notifiable) {
    this.channels.remove(notifiable);
    notifiable.setNews(null);
  }

  @Override
  public boolean isAttached(Notifiable notifiable) {
    return this.channels.contains(notifiable);
  }


  @Override
  public void inform() {
    for (Notifiable channel : channels) {
      channel.update(news);
    }
  }

  public String getName() {
    return name;
  }

  public void setNews(String news) {
    this.news = news;
    this.inform();
  }

  public String toString() {
    return "Говорить інформаційне агенство \"" + name + "\": " + news + ". Розсилаємо новину ЗМІ.";
  }
}
