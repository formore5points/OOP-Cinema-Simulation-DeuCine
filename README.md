# OOP-Cinema-Simulation-DeuCine
OOP Based Cinema Simulation using Java

# Project:  DeuCine
 
The subject of the project is to develop a software for the CineCeng Theaters. 
 
# General Information

The software to be developed has to include some entities explained below:
 
# Saloon

There are three saloons in CineCeng Theaters. Their names are Saloon 1, Saloon 2 and Saloon 3. Each saloon has 5x5 seat arrangement. Each saloon is reserved for a single movie in all showtimes per day. Saloons are differentiated according to their presentation technology (2D/3D/Imax etc.).

# Showtime

Three planned showtimes are performed per day for each saloon. Showtimes are entitled “morning”, “noon” and “evening”. They are scheduled as 10:00 AM - 01:00 PM, 02:00 PM - 05:00 PM and 06:00 PM - 09:00 PM, respectively. Different seat prices can be applied for different saloons and showtimes.

# Movie

Each movie has information including id, title, genre (action, comedy, horror etc.), duration (in minutes), director and stars. A movie can be showing in more than one saloon. 

# Seat

There are 25 seats in each saloon. The seats are named according to their row (A, B, C, D, E) and column (1, 2, 3, 4, 5). A seat id can be exemplified as A1 or E3. A seat is initially considered as empty. When a ticket is sold for a saloon and showtime, the selected seat is not empty anymore. A sold seat can not be sold again to another person.

# Star / Director

A movie star and director are recorded with their id, name, birth date and birth place. One director and minimum two stars must be specified for each movie.

# Person

A person can buy a ticket by specifying the movie he/she is going to watch, a showtime and a seat. Each ticket is sold for a single seat. If the selected seat is already sold, the software assign a random empty seat. Students pay half price of a ticket.


# Operations

Commands

-load;input.txt
-addStar;name;bdate;bplace
-addDirector;name;bdate;bplace
-addMovie;title;genre;duration;directorId;actorId1;actorId2 (...)
-updateSaloon;saloonId;movieId
-updateShowtime;saloonId;showtime;price
-sellTicket;saloonId;showtime;seat;personType
-cancelTicket;saloonId;showtime;seat
-displayActors
-displayDirectors
-displayMovies
-displaySeats;saloonId;showtime
-endTheDay

# Software Initialization

At the beginning of the program, an input file (input.txt) is read and evaluated line by line. Semicolon ( ; ) character is used as delimiter in this file. Each line corresponds an individual command. Each command must be parsed and executed in order. A sample input file content is given below:

input.txt
-addStar;Sally Hawkins;27/04/1976;London (auto increment id 1)
-addStar;Octavia Spencer;25/05/1972;Alabama (auto increment id 2)
-addMovie;The Shape of Water;Adventure;123;4;11;12 (auto increment id 1)
-updateSaloon;s1;1
-updateShowtime;s1;morning;20
-sellTicket;s1;morning;B3;student
-sellTicket;s1;morning;D2;regular
-cancelTicket;s1;morning;B3
-endTheDay

# End-of-day Operations

Statistics are; the most-watched movie, total revenue of CineCeng, the most-filled showtime(of which saloon) and the highest-income movie. You are also expected to draw status of the all seats in each showtime and saloon as given below. The sold seats are shown with the “X” character while the empty seats are shown with “O”. After presentation of the statistics, the necessary data structures must be initialized for the new day.

# Sample Screen
The most-watched movie : “The Shawshank Redemption”

Total revenue of CineCeng: 560

The most-filled showtime : s3-morning

The highest-income movie : “Inception” - 230

- Morning
-          s1	s2 	s3
-         XXOXX XXXXX XXXXX
-         OXOXX XXXXX XXXXX
-         XOOXX OOXXX XXXXX
-         XXOOX OXXXX XXXXX
-         OXOOX OOXXO XXXXX
- Noon
-         OXOXX OOXXO XOXOX
-         OXOXX XOXXO XOXOX
-         OXXOX OXXXO XOXOX
-         OXXOX XXXXO XOXOX
-         OXOXX OOXXO XOXOX
- Evening
-         XXOXX OOXXO XXXOX
-         OOXXX OOXXO XXXOX
-         OOOXX XXXXO XXXOX
-         XOOXX XXXXO XXXOX
-         XXOXX XXXXO XXXXX
