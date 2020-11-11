## 1. Write a program for error detecting code using CRC-CCITT (16- bits)

```
1. Start
2. Enter the message to be transmitted
3. Append the message with 16(since it is 16-bit CRC) 0`s (i.e. if you input 5 digit message, the appeneded message should be 21-bits.)
4. XOR appended message and transmit it.(Here, you compare with an already exisitng string such as "10001000000100001" and replace the bits the same way XOR operation works)
6. Verify the message that is received is the same as the one sent.
7. End
```

## 2. Write a program to find the shortest path between vertices using bellman-ford algorithm

```
1. Start
2. By convention, the distance of the node to itself is assigned to zero and when a node is unreachable the distance is accepted as 999.
3. Accept the input distance matrix from the user (dm[][]) that represents the distance between each node in the network.
4. Store the distance between nodes in a suitable varible.
5. Calculate the minimum distance between two nodes by iterating.
    - If the distance between two nodes is larger than the calculated alternate available path, replace the existing distance with the  calculated distaance.
7. Print the shortest path calculated.
8. Stop.
```

## 3. Using TCP/IP sockets, write a client – server program to make the client send the file name and to make the server send back the contents of the requested file if present.
