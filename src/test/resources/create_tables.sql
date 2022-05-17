CREATE TABLE hoover_results
(
    hoover_id           SERIAL PRIMARY KEY,
    final_position      varchar(10) NOT NULL,
    patches_cleaned     integer NOT NULL
);

CREATE TABLE hoover_requests
(
    hoover_id       SERIAL PRIMARY KEY,
    room_size       varchar(10) NOT NULL,
    start_position  varchar(10) NOT NULL,
    patches         varchar(50) NULL,
    instructions    varchar(20) NOT NULL
);
