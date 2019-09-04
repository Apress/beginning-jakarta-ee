  # ###### List all users ########################
  ./imqusermgr list
  # ->  
  # User repository for broker instance: imqbroker
  # --------------------------------------
  # User Name    Group        Active State
  # --------------------------------------
  # admin        admin        true
  # guest        anonymous    true

  # ###### Change user password ##################
  ./imqusermgr update -u admin -p QW34rtz

  # ###### Add new user ##########################
  ./imqusermgr add -u Spongebob -p QW34rt7 -g admin

  # ###### Delete user ###########################
  ./imqusermgr delete -u Spongebob
