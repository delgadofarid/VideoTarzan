INSERT INTO ACTOR VALUES (null, 'Jhon Travolta');
INSERT INTO ACTOR VALUES (null, 'Brad Pit');
INSERT INTO ACTOR VALUES (null, 'Leonardo D Caprio');
INSERT INTO ACTOR VALUES (null, 'Samual L Jackson');
INSERT INTO ACTOR VALUES (null, 'Rami Malek');


INSERT INTO MOVIE VALUES (null,
'A chronicle of the years leading up to Queens legendary appearance at the Live Aid (1985) concert.',
'Bryan Singer', '12000', 'Bohemian Rhapsody', 1);

INSERT INTO MOVIE_ACTOR VALUES (1, 1);
INSERT INTO MOVIE_ACTOR VALUES (1, 2);
INSERT INTO MOVIE_ACTOR VALUES (1, 3);
INSERT INTO MOVIE_ACTOR VALUES (1, 4);
INSERT INTO MOVIE_ACTOR VALUES (1, 5);

INSERT INTO USERS VALUES (1, 0, 1, 'admin', 'admin');
INSERT INTO AUTHORITIES VALUES (1, 'ROLE_ADMIN', 'admin');

INSERT INTO CUSTOMER VALUES (1, 'user@test.com', 'User Tester', '3000000', 1, 'user', 'user', 0);