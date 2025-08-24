#include<stdio.h>
#include<math.h>

bool check(float a, float b, float c){
	if (a < b+c && b < a+c && c < b+a){
		return 1;
	}
	return 0;
}
float perimeter(float a, float b, float c){
	if (check(a,b,c)) return a+b+c;
	else return -1;
}
float area(float a, float b, float c){
	float p = perimeter(a,b,c)/2;
	if (check(a,b,c)) return sqrt(p*(p-a)*(p-b)*(p-c));
	else return -1;
}
int main(){
	float a1,b1,c1,a2,b2,c2;
	scanf("%f%f%f", &a1, &b1, &c1);
	scanf("%f%f%f", &a2, &b2, &c2);
	if (area(a1,b1,c1) > area(a2,b2,c2)) {
		printf("%.3f %.3f\n",perimeter(a1,b1,c1), area(a1,b1,c1));
		printf("%.3f %.3f",perimeter(a2,b2,c2), area(a2,b2,c2));

	}
	else {
		printf("%.3f %.3f\n",perimeter(a2,b2,c2), area(a2,b2,c2));
		printf("%.3f %.3f",perimeter(a1,b1,c1), area(a1,b1,c1));
	}
	return 0;
}
