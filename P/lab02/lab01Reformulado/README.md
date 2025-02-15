# Puzzle Exercise

## WSGenerator execution

```
javac *.java -> compilation

java WSGenerator -i *.txt -s xx -o *.txt (in case you want the output in a file)

java WSGenerator -i *.txt -s xx (in case you want the output in the terminal)

Example:
java WSGenerator -i wlist3.txt -s 12
J M M D J Z D L H U M V
U M Y A P R O W S Q R L
Z S V S N M U L O C S D
H A T S O U P Y G F V E
L D R Y P C N J Y N U U
N O E S C Z B H V B A K
F X D U L S A C A P M A
T X O K G Q R P G Z K T
B S A E M R A J T W F H
G K K P L Q U L S X M A
G N I M M A R G O R P I
F M P J T B Q V L W V F
programming, columns, java, soup, rows
```

## WSSolver.java execution

```
javac *.java -> compilation

java WSSolver *.txt

java WSSolver *.txt > *.txt (in case you want to redirect the output into a file)

Example:
java WSSolver sdl_01.txt
programming     11      12,6    UP
java            4       9,1     DOWN
words           5       11,11   UPLEFT
lines           5       5,5     LEFT
civil           5       6,11    DOWN
test            4       2,8     RIGHT
stack           5       1,1     RIGHT
S T A C K . . . . . . .
. . . . . G . T E S T .
. . . . . N . . . . . .
. . . . . I . . . . . .
S E N I L M . . . . . .
. . . . . M . . . . C .
. . . . . A S . . . I .
. . . . . R . D . . V .
J . . . . G . . R . I .
A . . . . O . . . O L .
V . . . . R . . . . W .
A . . . . P . . . . . .
```
