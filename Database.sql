create table book(
                     ISBN BIGINT,
                     TITRE VARCHAR(50),
                     AUTHOR VARCHAR(50),
                     QUANTITY INT,
                     PRIMARY KEY (ISBN));

create table member(
                       MEMBERID INT NOT NULL AUTO_INCREMENT,
                       FIRSTNAME VARCHAR(50) NOT NULL,
                       LASTNAME VARCHAR(50) NOT NULL,
                       PRIMARY KEY (MEMBERID));

CREATE TABLE BOOK_COPY(
                          ID INT NOT NULL AUTO_INCREMENT,
                          AVAILABILITY ENUM('AVAILABLE', 'NOT_AVAILABLE', 'LOST'),
                          ISBN BIGINT,
                          PRIMARY KEY (ID),
                          FOREIGN KEY (ISBN) REFERENCES book(ISBN));

CREATE TABLE loan (
                      MEMBER_ID INT NOT NULL,
                      BOOK_ID INT NOT NULL,
                      DATE_EMPRUNT DATE,
                      DATE_ROUTOUR DATE,
                      PRIMARY KEY (MEMBER_ID, BOOK_ID),
                      FOREIGN KEY (MEMBER_ID) REFERENCES member(MEMBERID),
                      FOREIGN KEY (BOOK_ID) REFERENCES BOOK_COPY(ID));


INSERT INTO book (ISBN, TITRE, AUTHOR, QUANTITY) VALUES
                                                     (9780451524935, 'To Kill a Mockingbird', 'Harper Lee', 5),
                                                     (9781984819194, '1984', 'George Orwell', 3),
                                                     (9780061120084, 'Fahrenheit 451', 'Ray Bradbury', 4);

INSERT INTO BOOK_COPY (AVAILABILITY, ISBN) VALUES
                                               ('AVAILABLE', 9780451524935),
                                               ('AVAILABLE', 9780451524935),
                                               ('NOT_AVAILABLE', 9781984819194),
                                               ('AVAILABLE', 9780061120084);

INSERT INTO member (FIRSTNAME,LASTNAME) VALUES
                                            ('Smith', 'John'),
                                            ('Johnson', 'Alice'),
                                            ('Brown', 'Michael');

INSERT INTO loan (MEMBER_ID, BOOK_ID, DATE_EMPRUNT, DATE_ROUTOUR) VALUES
                                                                      (1, 1, '2023-08-01', '2023-08-15'),
                                                                      (2, 2, '2023-08-05', '2023-08-20'),
                                                                      (1, 3, '2023-08-10', '2023-08-25'),
                                                                      (3, 4, '2023-08-15', '2023-08-30');