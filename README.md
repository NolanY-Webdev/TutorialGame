# TutorialGame
  - Creating a game following youtube tutorial
  - https://www.youtube.com/watch?v=rfR09erJu7U

  -Realized about day 11 I saved the whole ecclipse workspace instead of just the project... (sorry github, newbie ecclipse user mistake) Will fix it when I figure out how to. Going to focus on finishing the project first.

##Day 1
  @ https://www.youtube.com/watch?v=MgSApgveCjU

    Current files of Ecclipse workspace for game
    Functional game window
    No further progress

##Day 2 or something
  @ https://youtu.be/O1vQABTMMgo?t=5m54s

    1:48AM
    Game sized for 1440x900 just because my system works best in that resolution.
    Have a beautiful field of grass showing. So peaceful.

##Day 3 not much happened
  @ https://youtu.be/O1vQABTMMgo?t=14m11s

    Added map saved as int[][] (so a double array of intergers)
      sized for my devices screen, which is a peculiar ratio. I'll work on it for fun but it wont work well on other devices...

    Created randomized map2 :
      - each layout is unplayable
      - rethinking randomization in terms of a bigger chunk of grid at a time.
        - Like a tileset system.
        - Wonder if there is a way to control zoom...
        - Would be neat to have a tower defense map that is built upon as it is played...

    Dont entirely remember where the video was going on or what had happened.

##Day 4ish

    Didn't work though weekend, spent some time playing some other games for ideas.
    Hadn't logged day 3 so spent the morning of day 4 writing that and catching up.
    Going to commit log and eat while coffee kicks in. Then I'll figure out where I'm at. Think I need to get out of the rabbit hole and just follow the video.

  @  https://youtu.be/O1vQABTMMgo?t=15m34s

    Got my map to match the one in the video as well, figured it was best for learning. At least I know I can easily change things around in my own way. Perhaps I will learn a better method in the future.

  @ https://youtu.be/O1vQABTMMgo?t=21m20s

    First enemy to show on screen, committing progress.

  @ https://youtu.be/g4OwOcKq148?t=14m31s

    Clock helper implemented, understood to an extent but not completely.
    Enemy can now move slightly.

  @ https://youtu.be/g4OwOcKq148?t=21m17s

    Got enemy wave class creation working.


  @ https://youtu.be/wn9YK2oVcI0?list=PLFUqwj4q1Zr8GHs6bO4d6gxMGUh_2pcNg

    Everything working and up to date with latest video.

  @ https://youtu.be/wn9YK2oVcI0?t=6m2s

    Adding logic to pathing.


##Day 5

    not feeling so good, really didn't get anything done
    consider it a personal health day

##Day 6

  @ https://youtu.be/wn9YK2oVcI0?t=28m0s

    got code directly matching video
    everything functional at that point.

  @ https://www.youtube.com/watch?v=LLBGr6Co3BQ

    code all caught up to video

  @ https://youtu.be/LLBGr6Co3BQ?t=7m18s

    somewhere near where I had ended

##Day 7/8

    stuff* got done, on video 30 now

  @ https://www.youtube.com/watch?v=3jOhfVt9PZc

    have been trying to work off projector and that has made this log a bit more out of the way in terms of verifying im on the right youtube link and all. Tower base tiles have been implemented spawned in the same fashion enemies are.

    Interesting later project would be to recreate minecraft or a similar, if not stupider, clone. Perhaps design any sort of 3d project that would allow the user to expolore to some extent. Maybe even reuse the amazing textures from this game or something.
          (*Stuff: some bug fixes and the base tile level of towers)

## Day 9 (I think?)

  @ https://youtu.be/S-WiE_O4zjM?t=4m11s

    Worked a bit over the weekend and this morning. Not a ton but kept up the rythm of working more and more. Need to keep logging everything. Aim is to get really far and log a lot today.

    -More random ideas, Pandora radio remote control app.


  @ https://youtu.be/S-WiE_O4zjM?t=5m50s

    not much video progress but much personal
    BRANCHING FROM VIDEO, NOTE TOWER DIFFERENCES added fireRate and projectileSpeed to tower construction and passing variables directly to Projectile class.

    don't quite agree with how he is setting up the Wave/WaveManager but I'll follow along for now

  @ https://youtu.be/3yUzOKp4BT0?t=2s

    that last episode was a bit of a nightmare, strayed from video and got a bit lost, code seems up to par with video minus tower deviations made before. So much hopping around randomly last time. Guess it's good practice at the least.


  @ https://youtu.be/XRcmPVsi9V4?t=20s

    Got waves implemented to an extent.

  @ https://youtu.be/e3-TZ7TfJjA?t=23s

    Towers are tracking enemies now, not firing in correct direction though

  @ https://youtu.be/5Ttg8n6cWFA?t=20s

    Place towers on a click, did mine a bit differently than he did his but I dont think it will cause any problems in the future. Getting the hang of Java :D

## Day 10

  @ https://youtu.be/YoBFN0WcM2w?t=12s

    Makin progress, towers no longer firing crooked bullets. Time multiplier implemented on Right and Left arrow keys.

  @ https://youtu.be/yKCpcQleRqs

    video 39 adding button functionality

  @ https://youtu.be/yKCpcQleRqs?t=11m19s

  BUG DETECTED:

    Exception in thread "main" java.lang.NullPointerException
      at data.Player.update(Player.java:44)

  REASON:

    I am using a different resolution than he is in the video. Click is attempting to place tower immediately upon starting. By commenting out the tower placement on click code @ (Player.java:44) the game works perfectly fine.
      - Current background giving funky x/y coords in comparison to game state page
      - sizing differences
      - need to fix tower placement so it is not trying to place a tower in a funky x/y position immediately as game begins
        - will probably be handled this video

    Also: cleaned up and added git formatting the Readme


## Day 11 (or so)
###Heatspike, late summer or something, could not work at all indoors with no AC. It was absolutely miserable.

  @ https://youtu.be/Ttg-1GVz_RM?t=2s

    - Fixed old bug from previous commit, it was from tower being placed immediately as game began. Systems to prevent this had not been properly hooked up (or had somehow become undone)
    - need to remove the testing branch I blindly made
    - ecclipse isnt happy about how the repo is saved in github (newbie mistake uploading more of workspace than just project ( sorry github :( )))

  @ https://youtu.be/Zl2slZ4kCzk?t=14m55s

    - Have to fix wave manager not beginning new wave after breakPeriod.
    - Have to add breakPeriod for waves

  @ https://youtu.be/YK9CQ6uFuNw?t=30s

    - there's a bug after placing too many towers or something
        Exception in thread "main" java.lang.NullPointerException
        at data.TowerCannon.calculateAngle(TowerCannon.java:73)
        at data.TowerCannon.update(TowerCannon.java:107)
        at data.Player.update(Player.java:31)
        at data.Game.update(Game.java:27)
        at helpers.StateManager.update(StateManager.java:51)
        at data.Boot.<init>(Boot.java:54)
        at data.Boot.main(Boot.java:72)
    - not entirely sure why


## Day 12

  still @ https://youtu.be/YK9CQ6uFuNw?t=30s
    - Bug was being caused by targeting AI mixed with tower range restrictions causing game to crash when towers were outside of proper targeting range.
    - Spent the morning fixing the bug from the targeting AI.
    - Towers will now only shoot enemies within range and will not crash the game after derping hard.

  @ https://youtu.be/tza3fqIZaNM?t=7m31s

    - Helped my neighbor move, took twice as long as expected but glad I didn't leave him to do it alone.
    - Adding abstract tower class to game, not sure why he hasn't added a cannon/base texture differentiation.
    - Pretty burnt after moving furniture for over four hours, logging and picking things up tomorrow.

## Day 13

  @ https://youtu.be/IN-V4g6c7pU?t=7m26s    (or somewhere around there)

    - Adding TowerType enum for simple creation of multiple tower types.
    - Paused video and working ahead freestyle to prep enum for future expected uses.

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -

  @

    -
