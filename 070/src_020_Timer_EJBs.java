@Schedules({
  @Schedule(hour="*"),
  @Schedule(hour="0", minute="30") 
})
private void someMethod(Timer tm) {
    ...
}
