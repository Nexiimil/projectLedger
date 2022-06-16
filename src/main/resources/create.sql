CREATE TABLE IF NOT EXISTS Users (
    Username varchar(16) PRIMARY KEY NOT NULL,
    Passhash varchar(255) NOT NULL,
    Email varchar(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Transactions (
    ID int PRIMARY KEY NOT NULL,
    SubjectName varchar(16) REFERENCES Users NOT NULL,
    TargetName varchar(16) REFERENCES Users NOT NULL,
    Currency varchar(1) NOT NULL,
    Value numeric(10,2) NOT NULL,
    Ref varchar(255),
    Paid boolean NOT NULL,
    DateFiled timestamp NOT NULL,
    DatePaid timestamp NOT NULL
);