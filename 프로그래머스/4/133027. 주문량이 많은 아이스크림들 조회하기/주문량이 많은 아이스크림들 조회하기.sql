SELECT H.FLAVOR
FROM (
    SELECT SUM(TOTAL_ORDER) TOTAL, FLAVOR
    FROM FIRST_HALF
    GROUP BY FLAVOR
) H JOIN (
    SELECT SUM(TOTAL_ORDER) TOTAL, FLAVOR
    FROM JULY
    GROUP BY FLAVOR
) F
ON H.FLAVOR = F.FLAVOR
GROUP BY H.FLAVOR
ORDER BY H.TOTAL + F.TOTAL DESC
LIMIT 3