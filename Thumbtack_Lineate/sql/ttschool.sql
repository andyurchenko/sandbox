drop database if exists ttschool;
create database ttschool;
use ttschool;

create table `trainee` (
	id INT(11) NOT NULL AUTO_INCREMENT,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
    rating int(5) NOT NULL DEFAULT 0,
    
    primary key (id),
    key firstname(firstname),
    key lastname(lastname),
    key rating(rating)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

create table `subject` (
	id INT(11) NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    
    primary key(id),
    key name(name)
) ENGINE = INNODB DEFAULT CHARSET = utf8;


create table `school` (
	id INT(11) NOT NULL AUTO_INCREMENT,
    name varchar(50) not null,
    year int(4) not null,
    
	primary key(id),
	KEY name(name),
    KEY year(year),
    UNIQUE KEY name_year (name, year)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

create table `group` (
	id INT(11) NOT NULL AUTO_INCREMENT,
    name varchar(50) not null,
    room varchar(50) not null,
    schoolid int(11) not null, 
    
    primary key(id),
	foreign key (schoolid) references `school`(id) on delete cascade,
    key name(name),
    key room(room)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

alter table `group`
add foreign key (schoolid) references `school`(id) on delete cascade;

create table `trainee_group` (
	id INT(11) NOT NULL AUTO_INCREMENT,
    traineeid INT(11) NOT NULL,
	groupid INT(11) NOT NULL,
    
    primary key (id),
    
	key groupid(groupid),
    foreign key (groupid) references `group`(id) on delete cascade,
    
    key traineeid(traineeid),
    foreign key (traineeid) references `trainee`(id) on delete cascade
) ENGINE = INNODB DEFAULT CHARSET = utf8;

create table `subject_group` (
	id INT(11) NOT NULL AUTO_INCREMENT,
    subjectid INT(11) NOT NULL,
	groupid INT(11) NOT NULL,
        
    primary key (id),
    
    key groupid(groupid),
    foreign key (groupid) references `group`(id) on delete cascade,
    
    key subjectid(subjectid),
    foreign key (subjectid) references `subject`(id) on delete cascade
) ENGINE = INNODB DEFAULT CHARSET = utf8;