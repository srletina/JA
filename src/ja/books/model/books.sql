create database BOOKS;
use BOOKS;

create table BOOK(
	IDBook int primary key auto_increment,
    Isbn varchar(20),
    Title varchar(20),
    Author varchar(20)
);

insert into BOOK values 
	(null, 'ISBN-123', 'Ponedjeljak', 'Daniel Bele');
insert into BOOK values
	(null, 'ISBN-213', 'Prazina', 'Daniel Bele');
insert into BOOK values 
	(null, 'ISBN-321', 'Fijasko', 'Imre Kertesz');

select IDBook, Isbn, Title, Author from Book;

