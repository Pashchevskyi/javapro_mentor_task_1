package ua.ithillel.lms.javapro.pavlopashchevskyi.mentor.task1;

import ua.ithillel.lms.javapro.pavlopashchevskyi.mentor.task1.api.Notifiable;

public class NewsChannel implements Notifiable {

  private final String name;

  private String news;

  public NewsChannel(String name) {
    this.name = name;
  }

  @Override
  public void update(Object o) {
    this.setNews((String) o);
  }

  public String getNews() {
    return this.news;
  }

  public void setNews(String news) {
    this.news = news;
  }

  public String getName() {
    return name;
  }
}
