# Game Lobby

 In this racing game there are up to 25,000 drivers who enter a race. Each driver has a unique ranking based on their performance in the game. For example a driver might be ranked 1 (meaning they are the best player in the whole game), or they could be ranked 10,000 meaning they are the 10,000th best player.

When a driver chooses to enter a race they will first be put into a lobby screen while they wait for the race to start. In this lobby area they will find out which type of car they will use for the race.

This racing game is designed to make the races more even. Thus poorly ranked drivers are given fast cars, while highly ranked drivers are given slow cars. In fact, the top half of the drivers in a race will be racing in a slow (but reliable): `Honda Odyssey '03`,  while the bottom half of the racers will be driving the much faster: `Renault Espace F1`.

In the event the race has an odd number of racers: the median ranked racer will race in the slow vehicle (the `Honda Odyssey '03`).

While drivers are waiting for the race to start. We reported which drivers are currently the top ranked of the bottom half of the drivers and the lowest ranked of the top half of the drivers. 

 for example, a race with the following drivers (and their ranking).

|Driver | Ranking | Potential Car |
|-------|---------| --- |
| GentleGiant | 4 | Odyssey
| SlicedBread | 8 | Odyssey |
|:arrow_heading_up: Top ranking drivers |---|Bottom ranking drivers:arrow_heading_down: |
| Billion\$Man | 22|  Renault |
| Mario       | 200| Renault

Considering the situation that a new racer joins the lobby. The cars for those drivers who are on the bubble might change. At the moment Billion\$Man is the highest ranking of the low ranking racers. If a racer with a lower ranking than 22 (the ranking of Billion\$Man) joins the group, then Billion\$Man will join the top half (as per the rule the anyone ranked at exactly the median joins the top half). Like what happens below when ClumsyPup with ranking 44 joins the lobby:

|Driver | Ranking | Potential Car |
|-------|---------| --- |
| GentleGiant | 4 | Odyssey
| SlicedBread | 8 | Odyssey |
| Billion$Man | 22|  Odyssey |
|:arrow_heading_up: Top ranking drivers |---|Bottom ranking drivers:arrow_heading_down: |
| ClumsyPup | 44 | Renault |
| Mario       | 200| Renault
                

