SELECT TRUNCATE(price, -4) PRICE_GROUP, COUNT(*) PRODUCTS
FROM  PRODUCT
GROUP BY 1
ORDER BY 1