create database baseball;
use baseball;

drop table team;
create table team (
    id int not null auto_increment,
    name varchar(45) not null,
    primary key (id)
);

drop table player;
create table player (
    id int not null auto_increment,
    name varchar(45) not null,
    role varchar(45),
    player_status tinyint(1) not null default 0,
    team_id int not null,
    primary key (id),
    foreign key (team_id) references team(id)
);

drop table game;
create table game (
                        id int not null auto_increment,
                        away_team_id int not null,
                        home_team_id int not null,
                        play_status tinyint(1) not null default 0,
                        last_batting_player int,
                        primary key (id),
                        foreign key (away_team_id) references team(id),
                        foreign key (home_team_id) references team(id),
);

drop table game_player_detail;
create table game_player_detail (
                        at_bat int default 0,
                        out_count int default 0,
                        plate_appearance int default 0,
                        player_id int not null,
                        game_id int not null,
                        primary key (game_id,player_id),
                        foreign key (player_id) references player(id),
                        foreign key (game_id) references game(id)
);

drop table game_team_score;
create table game_team_score (
                                    id int not null auto_increment,
                                    score int,
                                    round int,
                                    team_id int not null,
                                    game_id int not null,
                                    game_key int,
                                    primary key (id),
                                    foreign key (team_id) references team(id),
                                    foreign key (game_id) references game(id)
);
