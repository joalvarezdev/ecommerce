INSERT INTO categories (id, description)
SELECT 0, 'NAVIDENO'
    WHERE NOT EXISTS (SELECT id FROM categories WHERE id = 0);

INSERT INTO categories (id, description)
SELECT 1, 'DECO'
    WHERE NOT EXISTS (SELECT id FROM categories WHERE id = 1);

INSERT INTO categories (id, description)
SELECT 2, 'BEBE'
    WHERE NOT EXISTS (SELECT id FROM categories WHERE id = 2);
