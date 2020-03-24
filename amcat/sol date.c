#include"date.h"

int diff_date(DATE d1, DATE d2)
{
    return abs(serialDate(d1) - serialDate(d2));
}
int main()
{
DATE today = {16,1,2019}, tomorrow = {17,1,2018};
printf("%d %d", serialDate(today), serialDate(tomorrow));
printf(" %d ", diff_date(today, tomorrow));
return 0;
}
