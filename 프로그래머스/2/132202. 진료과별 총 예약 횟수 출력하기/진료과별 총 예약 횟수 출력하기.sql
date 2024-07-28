select MCDP_CD as '진료과코드', count(*) as '5월예약건수' from APPOINTMENT  
    where month(APNT_YMD) = '05' and year(APNT_YMD) = '2022'
    group by MCDP_CD
    order by count(MCDP_CD), MCDP_CD;