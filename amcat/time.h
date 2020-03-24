#include<stdio.h>

typedef struct time
{
    int hours;
    int minutes;
    int seconds;
} TIME ;

convert(TIME t)
{
    return t.hours * 3600 + t.minutes * 60 + t.seconds;
}
int diffTime(TIME t1, TIME t2)
{

int inseconds1, inseconds2;
inseconds1 = convert(t1);
inseconds2 = convert(t2);
return abs(inseconds1 - inseconds2);
}

TIME diffTime_Time(TIME t1, TIME t2)
{
TIME temp;
int  diff;
diff = diffTime(t1, t2);
temp.hours = diff / 3600;
temp.minutes = (diff % 3600) / 60;
temp.seconds= (diff % 3600) % 60;
return temp;


}


