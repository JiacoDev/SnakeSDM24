## List of tests that needs to be implemented:

## snake tests
- wasd input (movement)
- get and set snake length
- snake death when the head hits border
- snake death when the head hits the tail
- eat fruit (detection that the head is on top of a fruit)
- increase size when the snake eats the fruit
- (maybe) check that all snake body elements are connected

## fruit tests
- respawn of fruits
- get and set fruit position

## score tests
- get and set score
- increase score when a fruit gets eaten

## map tests
- get and set map dimension

## example of gameloop

snake.move(); \
collosionHandler.checkCollision(); \
returns a gamestate (win, lose, eat, normal) \
we switch the flow to the corrisponding gamestate and if we resolve it we go back to the normal gamestate

