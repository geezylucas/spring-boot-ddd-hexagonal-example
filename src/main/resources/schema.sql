CREATE TABLE orders
(
    id     BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE order_items
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    product_id BIGINT,
    quantity   INT,
    order_id   BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES orders
);