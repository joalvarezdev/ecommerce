CREATE TABLE IF NOT EXISTS "products" (
    id UUID NOT NULL,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(1000) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    discount_percentage DOUBLE PRECISION NOT NULL,
    stock INT2 NOT NULL,
    brand VARCHAR(100) NOT NULL,
    thumbnail VARCHAR(250) NOT NULL,
    CONSTRAINT "pk_products" PRIMARY KEY ("id")
);