  class MusicRecord {
      static class Composer {
        String firstName;
        String lastName;
        Composer(String firstName, String lastName) {
          ...
        }
      }
      String title;
      Composer[] composers;
      String performer;
      int makeYear;

      MusicRecord(String title, Composer[] composers,
            String performer, int makeYear) {
        ...
      }
  }

  MusicRecord rec = new MusicRecord(
      "Somewhere over the Rainbow",
      new MusicRecord.Composer[] {
        new MusicRecord.Composer("Harold", "Arlen"),
        new MusicRecord.Composer("E. Y.", "Harburg")
      },
      "Judy Garland",
      1939
  );
