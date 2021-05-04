create table team (
    id int not null auto_increment,
    name varchar(45) not null,
    primary key (id)
);

create table player (
    id int not null auto_increment,
    name varchar(45) not null,
    team_id int not null,
    primary key (id),
    foreign key (team_id) references team(id)
);
