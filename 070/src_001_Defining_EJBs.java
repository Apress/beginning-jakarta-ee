  import javax.ejb.Singleton;
  import javax.ejb.Stateless;
  import javax.ejb.Stateful;
  ...
  @Singleton
  public class Configuration {
      ... configuration access methods
  }

  @Stateless
  public class Invoice {
      ... invoice access methods
  }

  @Stateful
  public class TicTacToe {
      ... tic-tac-toe methods
  }
