#include"time.h"

int main()
{
TIME lunch= {12,30,0},  tea={15,15,0}, diff;
diff = diffTime_Time(lunch, tea);
printf("%d %d %d", diff.hours, diff.minutes, diff.seconds);
return 0;
}
