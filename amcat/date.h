#include<stdio.h>

typedef struct date
{
   int dd , mm, yyyy;
} DATE;
int isLeap(int yyyy)
{
if(yyyy % 4== 0 && (yyyy%400 == 0 || yyyy % 100 !=0)) return 1;
return 0;
}
serialDate(DATE some_date)
{
int days_gone_in_year[] = {0,0,31,59,90,120,151,181,212,243,273,304,334};
int temp_year,days=0;
for(temp_year=0; temp_year < some_date.yyyy; temp_year++)
   days+=365+isLeap(temp_year);

return days + days_gone_in_year[some_date.mm]+some_date.dd;
}
