package ua.ithillel.lms.javapro.pavlopashchevskyi.mentor.task1.api;

public interface Observable {

  void attach(Notifiable notifiable);

  void detach(Notifiable notifiable);

  boolean isAttached(Notifiable notifiable);

  void inform();
}
