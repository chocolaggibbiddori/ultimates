DROP TABLE IF EXISTS game_data;
CREATE TABLE game_data (
    idx bigint NOT NULL AUTO_INCREMENT,
    user_name varchar(255) DEFAULT NULL,
    game_number int DEFAULT NULL,
    start_time datetime DEFAULT NULL,
    end_time datetime DEFAULT NULL,
    play_champ varchar(255) DEFAULT NULL,
    kill_cnt int DEFAULT NULL,
    death_cnt int DEFAULT NULL,
    assist_cnt int DEFAULT NULL,
    win tinyint(1) DEFAULT NULL,
    atk_dmg int DEFAULT NULL,
    rec_dmg int DEFAULT NULL,
    PRIMARY KEY (idx)
);
DROP TABLE IF EXISTS champ_data;
CREATE TABLE champ_data (
    idx BIGINT NOT NULL AUTO_INCREMENT,
    champ_name VARCHAR(255) NOT NULL,
    q_skill VARCHAR(255) NOT NULL,
    w_skill VARCHAR(255) NOT NULL,
    e_skill VARCHAR(255) NOT NULL,
    r_skill VARCHAR(255) NOT NULL,
    PRIMARY KEY (idx)
);
DROP TABLE IF EXISTS user_data;
CREATE TABLE user_data (
    idx BIGINT AUTO_INCREMENT PRIMARY KEY,
    lv INT NOT NULL,
    game_num INT NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    tier INT
);
