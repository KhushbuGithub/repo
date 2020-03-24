#include<stdio.h>
#include<math.h>
/*
Problem
 You are required to complete the given code by reusing existing functions .you
can click on complie and run any time to check the compilation / execution
status of the program you can use System.out.println to debug your code. The
submitted code should be logically/syntactically correct and pass all testcases
.do not write the main() function has it is not required
Code Approach For this question you will need to complete the code as in
given implementation.we don’t expect you to modify the approach
You are given a pre-defined structure Point and also a collection of related
functions which can be used toperform some basic operations on the structure.
You will have to implement the function isRightTriangle(Ppoint *P1, Point
*P2,Point *P3) which accepts 3 points as input and checks whether the given 3
points can make a right angle triangle or not.
If they make a right angle triangle the function returns 1 else if returns 0.
*/

typedef struct point
{
int x;
int y;
} POINT;
double dist2Points(POINT  *p1, POINT *p2)
{
int par1, par2;
par1 = (p1->x - p2->x) * (p1->x - p2->x);
par2 = (p1->y - p2->y) * (p1->y - p2->y);
return sqrt((par1+par2));
}
isRightTriangle(POINT *p1, POINT *p2, POINT *p3)
{
   double  s1,s2, s3, sqrs1, sqrs2, sqrs3;
   int is1, is2, is3, max, rest;
       s1 = dist2Points(p1, p2);
       s2 = dist2Points(p1, p3);
       s3 =dist2Points(p2, p3);
       sqrs1 = s1 * s1;
       sqrs2 = s2 * s2;
       sqrs3 = s3 * s3;
       is1 = ceil(sqrs1);
       is2 = ceil(sqrs2);
       is3=ceil(sqrs3);
       max = (is1 > is2 ) ? (is1 > is3 ? is1 : is3) : (is2 > is3 ? is2 : is3);
       rest = is1 + is2 + is3 - max;
       if(max == rest) return 1;
       return 0;



}


int main()
{
//POINT p1 = {8,10}, p2 = {10,12}, p3 = {5,7};
POINT p1 = {-2,-3}, p2 = {2,1}, p3 = {5,-2};
printf("%d", isRightTriangle(&p1, &p2, &p3));
}












