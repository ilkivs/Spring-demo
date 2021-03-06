CREATE TABLE CATEGORIES
(
    ID          BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME        VARCHAR(100) NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL
);

CREATE TABLE PRODUCTS
(
    ID             BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME           VARCHAR(100) NOT NULL,
    DESCRIPTION    VARCHAR(255) NOT NULL,
    PRICE          DOUBLE       NOT NULL,
    FK_CATEGORY_ID BIGINT       NOT NULL,
    CONSTRAINT FK_PROD_TO_CATEG FOREIGN KEY (FK_CATEGORY_ID)
        REFERENCES CATEGORIES (ID)
);

CREATE TABLE USERS
(
    ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    USERNAME VARCHAR(50) NOT NULL,
    EMAIL VARCHAR(100) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL
);

CREATE TABLE ROLES
(
    ID   BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(50) NOT NULL
);

CREATE TABLE USERS_TO_ROLES
(
    ID         BIGINT PRIMARY KEY AUTO_INCREMENT,
    FK_USER_ID BIGINT NOT NULL,
    FK_ROLE_ID BIGINT NOT NULL,
    CONSTRAINT FK_UTR_TO_USERS FOREIGN KEY (FK_USER_ID)
        REFERENCES USERS (ID),
    CONSTRAINT FK_UTR_TO_ROLES FOREIGN KEY (FK_ROLE_ID)
        REFERENCES ROLES (ID)
);

INSERT INTO USERS VALUES ( 1, 'ist1997', 'ilkivsviatoslav@gmail.com', '1111' );
INSERT INTO USERS VALUES ( 2, 'ist1998', 'ilkivsviatoslav1998@gmail.com', '2222' );
INSERT INTO USERS VALUES ( 3, 'ist1999', 'ilkivsviatoslav1999@gmail.com', '3333' );

INSERT INTO ROLES VALUES ( 1, 'admin' );
INSERT INTO ROLES VALUES ( 2, 'moderator' );
INSERT INTO ROLES VALUES ( 3, 'user' );

INSERT INTO CATEGORIES VALUES ( 1, 'TV`s', 'teliki' );
INSERT INTO CATEGORIES VALUES ( 2, 'Phones', 'telephonchiki' );
INSERT INTO CATEGORIES VALUES ( 3, 'PC`s', 'kompiki' );

INSERT INTO PRODUCTS VALUES ( 1, 'iPhone', 'XS', 900, 2 );
INSERT INTO PRODUCTS VALUES ( 2, 'Smart TV', 'tv', 1400, 1 );
INSERT INTO PRODUCTS VALUES ( 3, 'HP', 'Probook', 890, 3 );
INSERT INTO PRODUCTS VALUES ( 4, 'Xiaomi', 'A2 Lite', 500, 2 );
INSERT INTO PRODUCTS VALUES ( 5, 'MacBook', 'ios', 1900, 3 );

INSERT INTO USERS_TO_ROLES VALUES ( 1, 1, 1 );
INSERT INTO USERS_TO_ROLES VALUES ( 2, 1, 3 );
INSERT INTO USERS_TO_ROLES VALUES ( 3, 2, 2 );
INSERT INTO USERS_TO_ROLES VALUES ( 4, 2, 3 );
INSERT INTO USERS_TO_ROLES VALUES ( 5, 3, 3 );