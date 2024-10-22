create table if not exists characters (
    id SERIAL PRIMARY KEY,
    name varchar(100),
    health int,
    mana int,
    rage int,
    energy int,
    character_class varchar(100)
);

create table if not exists combat_log (
    id SERIAL PRIMARY KEY,
    character_id bigint references characters(id),
    attack varchar(300),
    damage int
);