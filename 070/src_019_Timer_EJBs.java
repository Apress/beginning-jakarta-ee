  @Schedule(second="10", minute="0", hour="0")
    // <- at 00:00:10 every day

  @Schedule(minute="30", hour="0", 
        dayOfWeek="Tue")
    // <- at 00:30:00 on Tuesdays (second defaults to 00)

  @Schedule(minute="11", hour="15", 
        dayOfWeek="Mon,Tue,Fri")
    // <- at 15:11:00 on mondays, Tuesdays and Fridays

  @Schedule(minute="*/10", hour="*")
    // <- every 10 minutes, every hour

  @Schedule(minute="25/10", hour="1")
    // <- 01:25, 01:35, 01:45 and 01:55

  @Schedule(hour="*", dayOfMonth="1,2,3")
    // <- every hour at 1st, 2nd and 3rd each month
    // (minute defaults to 00)

  @Schedule(hour="*/10")
    // <- every 10 hours

  @Schedule(month="Feb,Aug")
    // <- 00:00:00 each February and August
    // (hour defaults to 00)

  @Schedule(dayOfMonth="1", year="2020")
    // <- 00:00:00 each 1st each month during 2020

  @Schedule(dayOfMonth="1-10")
    // <- 00:00:00 each 1st to 10th each month
