CREATE TABLE IF NOT EXISTS "images" (
    product_id UUID NOT NULL,
    url VARCHAR(150) NOT NULL,
    CONSTRAINT "pk_images" PRIMARY KEY ("product_id")
);