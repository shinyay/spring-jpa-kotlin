CREATE TABLE "book"
(
    "id"       BIGINT NOT NULL AUTO_INCREMENT,
    "category" VARCHAR(255),
    "isbn"     BIGINT NOT NULL,
    "name"     VARCHAR(255),
    "price"    BIGINT NOT NULL
);