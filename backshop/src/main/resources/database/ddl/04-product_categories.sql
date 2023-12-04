CREATE TABLE IF NOT EXISTS "product_categories" (
    product_id UUID NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT "pk_product_categories" PRIMARY KEY ("product_id", "category_id"),
    CONSTRAINT "fk_product_categories_product" FOREIGN KEY ("product_id") REFERENCES "products" ("id"),
    CONSTRAINT "fk_product_categories_category" FOREIGN KEY ("category_id") REFERENCES "categories" ("id")
);