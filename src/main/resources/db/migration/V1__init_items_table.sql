CREATE TABLE IF NOT EXISTS items
(
    id UUID PRIMARY KEY,
    item_name VARCHAR(50) NOT NULL UNIQUE,
    item_description VARCHAR(50),
    item_price_euro DECIMAL(18,2) NOT NULL, --precision 18 is norm, 2 decimals after comma
    amount_in_stock INTEGER NOT NULL
);